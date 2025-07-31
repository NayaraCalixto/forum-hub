package br.com.alura.forumhub.repository.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forumhub.model.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

    boolean existsByTituloAndMensagem(String titulo, String mensagem);

}
