package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.topico.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
    @NotNull 
    Long id,
    @NotBlank 
    String titulo,
    @NotBlank 
    String mensagem,
    @NotNull
    Status status,
    @NotNull 
    Long autorId,
    @NotNull 
    Long cursoId) {

}
