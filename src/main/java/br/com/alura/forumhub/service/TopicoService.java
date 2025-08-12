package br.com.alura.forumhub.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.alura.forumhub.dto.DadosAtualizarTopico;
import br.com.alura.forumhub.dto.DadosCadastrarTopico;
import br.com.alura.forumhub.dto.DadosListagemTopico;
import br.com.alura.forumhub.dto.DadosTopico;
import br.com.alura.forumhub.model.curso.Curso;
import br.com.alura.forumhub.model.topico.Topico;
import br.com.alura.forumhub.model.usuario.Usuario;
import br.com.alura.forumhub.repository.curso.CursoRepository;
import br.com.alura.forumhub.repository.topico.TopicoRepository;
import br.com.alura.forumhub.repository.usuario.UsuarioRepository;

@Service
public class TopicoService {
    
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public ResponseEntity<?> cadastrarTopico(DadosCadastrarTopico dadosCadastrar) {

        boolean topicoExiste = topicoRepository.existsByTituloAndMensagem(dadosCadastrar.titulo(), dadosCadastrar.mensagem());
        if (topicoExiste) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tópico já existe");
        }

        Usuario autor = usuarioRepository.findById(dadosCadastrar.autorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));

        Curso curso = cursoRepository.findById(dadosCadastrar.cursoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        Topico topico = new Topico(dadosCadastrar, autor, curso);
        Topico topicoSalvo = topicoRepository.save(topico);

        URI uri = URI.create("/topicos/" + topicoSalvo.getId());
        return ResponseEntity.created(uri).body(topicoSalvo);
    }

    public Page<DadosListagemTopico> listarTopicos(Pageable paginacao) {
        return topicoRepository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    public ResponseEntity<DadosTopico> buscarPorId(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.map(value -> ResponseEntity.ok(new DadosTopico(value)))
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<?> atualizarTopico(DadosAtualizarTopico dadosAtualizar) {

    Topico topico = topicoRepository.findById(dadosAtualizar.id())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado"));

    Usuario autor = usuarioRepository.findById(dadosAtualizar.autorId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));

    Curso curso = cursoRepository.findById(dadosAtualizar.cursoId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

    topico.setTitulo(dadosAtualizar.titulo());
    topico.setMensagem(dadosAtualizar.mensagem());
    topico.setAutor(autor);
    topico.setCurso(curso);

    topicoRepository.save(topico);
    return ResponseEntity.ok(new DadosTopico(topico));
    }

    @Transactional
    public ResponseEntity<Void> deletarTopico(Long id) {
	Optional<Topico> excluirTopico = topicoRepository.findById(id);

	    if(excluirTopico.isPresent()) {
		    topicoRepository.deleteById(id);
		    return ResponseEntity.noContent().build();
	    }
	return ResponseEntity.notFound().build();
    }

}

