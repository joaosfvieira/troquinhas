package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Colecionador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 50)
    private String nome;
    
    @Column(length = 50)
    private String sobrenome;
    
    @Column(unique=true, length = 50)
    private String email;
    
    @OneToOne
    Contato contato;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
    @JoinTable(name="colecionador_figurinhas",
    joinColumns=@JoinColumn(name="colecionador_id"), 
    inverseJoinColumns=@JoinColumn(name="figurinha_id"))
    private Set<Figurinha> figurinhas;
}
