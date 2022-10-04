package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "pontos_troca")
public class PontoTroca {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nome")
    private String nome;

	@OneToMany(mappedBy="pontoTroca")
	private Set<Colecionador> colecionadores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
}
