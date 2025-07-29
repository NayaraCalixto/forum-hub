package br.com.alura.forumhub.dto;

import java.time.LocalDateTime;

public record DadosResposta(Long id,
	String titulo,	
	String mensagem,
	DadosTopico tópico,
	LocalDateTime dataCriacao,
	String nomeUsuario,
	Boolean solucao) {

}
