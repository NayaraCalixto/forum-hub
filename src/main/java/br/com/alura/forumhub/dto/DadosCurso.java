package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.Categoria;

public record DadosCurso(
    Long id,
	String nome,
	Categoria categoria) {

}
