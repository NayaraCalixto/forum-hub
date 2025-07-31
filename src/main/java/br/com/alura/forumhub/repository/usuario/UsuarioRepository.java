package br.com.alura.forumhub.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forumhub.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
