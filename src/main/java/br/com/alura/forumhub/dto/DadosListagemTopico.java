package br.com.alura.forumhub.dto;

import java.time.LocalDateTime;

import br.com.alura.forumhub.model.topico.Status;
import br.com.alura.forumhub.model.topico.Topico;

public record DadosListagemTopico(String titulo, 
                                String mensagem, 
                                LocalDateTime dataCriacao, 
                                Status status, 
                                String autor, 
                                String curso) {
                                
    public DadosListagemTopico(Topico topico) {
        this(
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getDataCriacao(),
            topico.getStatus(),
            topico.getAutor().getNome(), 
            topico.getCurso().getNome()  
        );
    }

}
