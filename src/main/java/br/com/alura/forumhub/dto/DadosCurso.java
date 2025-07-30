package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.curso.Categoria;

public record DadosCurso(
    Long id,
	String nome,
	Categoria categoria) {

}
