package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.curso.Curso;
import br.com.alura.forumhub.model.usuario.Usuario;

public record DadosCadastrarTopico(
    String titulo,
    String mensagem,
    Usuario autor,
    Curso curso) {

}
