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
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarTopico(@RequestBody @Valid DadosCadastrarTopico dados) {
        return topicoService.cadastrarTopico(dados);
    }

    @GetMapping
    public Page<DadosListagemTopico> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
	    return topicoService.listarTopicos(paginacao);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DadosTopico> buscarPorId(@PathVariable Long id) {
        return topicoService.buscarPorId(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizarTopico(DadosAtualizarTopico dadosAtualizar) {
        return topicoService.atualizarTopico(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        return topicoService.deletarTopico(ResponseEntity.notFound().build());
    }

}
