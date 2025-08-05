package br.com.alura.forumhub.dto;


import java.time.LocalDateTime;

import br.com.alura.forumhub.model.topico.Status;
import br.com.alura.forumhub.model.topico.Topico;


public record DadosTopico(
    Long id,
    String titulo,
    String mensagem,
    LocalDateTime dataCriacao,
    Status status,
    String autor,
    String curso) {

    public DadosTopico(Topico topico) {
        this(topico.getId(), 
        topico.getTitulo(), 
        topico.getMensagem(), 
        topico.getDataCriacao(), 
        topico.getStatus(), 
        topico.getAutor().getNome(), 
        topico.getCurso().getNome());
    }
    
    }
