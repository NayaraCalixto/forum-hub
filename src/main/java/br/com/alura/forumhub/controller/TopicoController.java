package br.com.alura.forumhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forumhub.dto.DadosCadastrarTopico;
import br.com.alura.forumhub.model.topico.Topico;
import br.com.alura.forumhub.repository.curso.CursoRepository;
import br.com.alura.forumhub.repository.topico.TopicoRepository;
import br.com.alura.forumhub.repository.usuario.UsuarioRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public void cadastrarTopico(@RequestBody @Valid DadosCadastrarTopico dadosCadastrarTopico){
        boolean topicoExiste = topicoRepository.existsByTituloAndMensagem(dadosCadastrarTopico.titulo(), dadosCadastrarTopico.mensagem());
        if (topicoExiste) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tópico já existe");
        }

        topicoRepository.save(new Topico(dadosCadastrarTopico));
    }


    


}
