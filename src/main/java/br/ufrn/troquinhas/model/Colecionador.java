package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Colecionador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne
	@JoinColumn(name="pontos_troca_id")
	private PontoTroca pontoTroca;

    @Column(length = 50)
    private String nome;
    
    @Column(length = 50)
    private String sobrenome;
    
    @Column(unique=true, length = 50)
    private String email;
    
    @JsonIgnore
	private String senha;
    
    @OneToOne
    Contato contato;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
    @JoinTable(name="colecionador_has_figurinhas",
    joinColumns=@JoinColumn(name="colecionador_id"), 
    inverseJoinColumns=@JoinColumn(name="figurinha_id"))
    private Set<Figurinha> figurinhasAdquiridas;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
	@JoinTable(name="colecionador_wants_figurinhas",
			joinColumns=@JoinColumn(name="colecionador_id"),
			inverseJoinColumns=@JoinColumn(name="figurinha_id"))
	private Set<Figurinha> figurinhasDesejadas;

}
