package br.com.alura.forumhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.alura.forumhub.dto.DadosCadastrarTopico;
import br.com.alura.forumhub.model.curso.Curso;
import br.com.alura.forumhub.model.topico.Topico;
import br.com.alura.forumhub.model.usuario.Usuario;
import br.com.alura.forumhub.repository.curso.CursoRepository;
import br.com.alura.forumhub.repository.topico.TopicoRepository;
import br.com.alura.forumhub.repository.usuario.UsuarioRepository;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        URI uri = URI.create("/topicos/" + topicoSalvo.getId());
        return ResponseEntity.created(uri).body(topicoSalvo);

    }

    


}
