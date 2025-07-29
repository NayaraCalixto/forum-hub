package br.com.alura.forumhub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forumhub.dto.DadosCadastrarTopico;
import br.com.alura.forumhub.dto.DadosTopico;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @GetMapping
    public String olaMundo(){
            return "Hello World!";
        }

    // @PostMapping
    // public void cadastrarTopico(@RequestBody @Valid DadosTopico dadosTopico) {
   
    // }

    @PostMapping
    public void cadastrarTopico(@RequestBody @Valid DadosCadastrarTopico dadosCadastrarTopico){
        System.out.println(dadosCadastrarTopico);
    }


    


}
