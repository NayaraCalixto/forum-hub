package br.com.alura.forumhub.dto;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;

import br.com.alura.forumhub.model.curso.Curso;
import br.com.alura.forumhub.model.usuario.Usuario;

public record DadosTopico(
    Long id,
    String titulo,
    String mensagem,
    LocalDateTime dataCriacao,
    Status status,
    Usuario nomeUsuario,
    Curso nomeCurso) {

}
