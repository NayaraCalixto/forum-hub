package br.com.alura.forumhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.alura.forumhub.dto.DadosCadastrarTopico;
import br.com.alura.forumhub.dto.DadosListagemTopico;
import br.com.alura.forumhub.dto.DadosTopico;
import br.com.alura.forumhub.model.curso.Curso;
import br.com.alura.forumhub.model.topico.Topico;
import br.com.alura.forumhub.model.usuario.Usuario;
import br.com.alura.forumhub.repository.curso.CursoRepository;
import br.com.alura.forumhub.repository.topico.TopicoRepository;
import br.com.alura.forumhub.repository.usuario.UsuarioRepository;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarTopico(@RequestBody @Valid DadosCadastrarTopico dados) {

        boolean topicoExiste = topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());
        if (topicoExiste) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body("Tópico já existe");
        }

        Usuario autor = usuarioRepository.findById(dados.autorId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));

        Curso curso = cursoRepository.findById(dados.cursoId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        Topico topico = new Topico(dados, autor, curso);
        Topico topicoSalvo = topicoRepository.save(topico);

        URI uri = URI.create("/topicos" + topicoSalvo.getId());
        return ResponseEntity.created(uri).body(topicoSalvo);

    }

    @GetMapping
    public Page<DadosListagemTopico> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
	    return topicoRepository.findAll(paginacao).map(DadosListagemTopico::new);
    }
    
    @GetMapping("/topicos/{id}")
    public ResponseEntity<DadosTopico> buscarPorId(@PathVariable Long id) {
    Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isPresent()) {
            DadosTopico dadosTopico = new DadosTopico(topico.get());
            return ResponseEntity.ok(dadosTopico);
        } else {
        return ResponseEntity.notFound().build();
        }
    }

}
