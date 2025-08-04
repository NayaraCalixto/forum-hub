package br.com.alura.forumhub.dto;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;


public record DadosTopico(
    Long id,
    String titulo,
    String mensagem,
    LocalDateTime dataCriacao,
    Status status,
    String autor,
    String curso) {
    
    }
