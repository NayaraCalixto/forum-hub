package br.com.alura.forumhub.model.topico;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.forumhub.dto.DadosCadastrarTopico;
import br.com.alura.forumhub.model.curso.Curso;
import br.com.alura.forumhub.model.resposta.Resposta;
import br.com.alura.forumhub.model.usuario.Status;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "topico")
@NoArgsConstructor
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
    private List<Resposta> respostas;

    public Topico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Status status, Usuario autor,
            Curso curso, List<Resposta> respostas) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respostas = respostas;
    }

    public Topico(DadosCadastrarTopico dadosCadastrarTopico) {
        this.titulo = dadosCadastrarTopico.titulo();
        this.mensagem = dadosCadastrarTopico.mensagem();
        this.autor = new Usuario(dadosCadastrarTopico.autorId());
        this.curso = new Curso(dadosCadastrarTopico.cursoId());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Status getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }
  
}


