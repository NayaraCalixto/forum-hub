package br.com.alura.forumhub.repository.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forumhub.model.curso.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
