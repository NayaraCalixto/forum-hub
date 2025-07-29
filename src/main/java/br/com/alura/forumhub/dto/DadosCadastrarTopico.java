package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.Curso;
import br.com.alura.forumhub.model.Usuario;

public record DadosCadastrarTopico(
    String titulo,
    String mensagem,
    Usuario autor,
    Curso curso) {

}
