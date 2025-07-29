package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.Perfil;

public record DadosUsuario(
    Long id,
	String nome,	
	String email,
	String senha,
	Perfil perfil) {

}
