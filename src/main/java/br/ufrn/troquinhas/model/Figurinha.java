package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "figurinhas")
public class Figurinha {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "raridade")
    private String raridade;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
    @JoinTable(name="colecionador_figurinhas",
    joinColumns=@JoinColumn(name="figurinha_id"), 
    inverseJoinColumns=@JoinColumn(name="colecionador_id"))
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

	public String getRaridade() {
		return raridade;
	}

	public void setRaridade(String raridade) {
		this.raridade = raridade;
	}

	public Set<Colecionador> getColecionadores() {
		return colecionadores;
	}

	public void setColecionadores(Set<Colecionador> colecionadores) {
		this.colecionadores = colecionadores;
	}
    
}
