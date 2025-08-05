package br.com.alura.forumhub.model.topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.forumhub.dto.DadosCadastrarTopico;
import br.com.alura.forumhub.model.curso.Curso;
import br.com.alura.forumhub.model.resposta.Resposta;
import br.com.alura.forumhub.model.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "topico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;	
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
    private Status status;
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(DadosCadastrarTopico dadosCadastrarTopico, Usuario autor, Curso curso) {
        this.titulo = dadosCadastrarTopico.titulo();
        this.mensagem = dadosCadastrarTopico.mensagem();
        this.autor = autor;
        this.curso = curso;
    }


}


