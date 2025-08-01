package br.com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTopico(
    @NotBlank 
    String titulo,
    @NotBlank 
    String mensagem,
    @NotNull 
    Long autorId,
    @NotNull 
    Long cursoId) {

}
