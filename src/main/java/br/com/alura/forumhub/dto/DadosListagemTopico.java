package br.com.alura.forumhub.dto;

import java.time.LocalDateTime;

import br.com.alura.forumhub.model.topico.Status;
import br.com.alura.forumhub.model.topico.Topico;

public record DadosListagemTopico(String titulo, 
                                String mensagem, 
                                LocalDateTime dataCriacao, 
                                Status status, 
                                Long autor, 
                                Long curso) {
                                
    public DadosListagemTopico(Topico topico) {
        this(
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getDataCriacao(),
            topico.getStatus(),
            topico.getAutor().getId(), 
            topico.getCurso().getId()  
        );
    }

}
