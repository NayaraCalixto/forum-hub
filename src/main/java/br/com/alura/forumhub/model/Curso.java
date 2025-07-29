package br.com.alura.forumhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "curso")
@Entity(name = "curso")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;	
	@Enumerated(EnumType.STRING)
	private Categoria categria;

    public Curso(String nome, Categoria categria) {
        this.nome = nome;
        this.categria = categria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategria() {
        return categria;
    }

}
