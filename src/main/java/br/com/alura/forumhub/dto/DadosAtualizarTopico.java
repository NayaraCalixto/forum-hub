package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.topico.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
    @NotNull 
    Long id,
    String titulo,
    String mensagem,
    Status status,
    Long cursoId) {

}
