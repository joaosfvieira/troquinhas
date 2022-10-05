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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "raridade")
    private String raridade;
    
    @ManyToMany(mappedBy = "figurinhasAdquiridas")
//    joinColumns=@JoinColumn(name="figurinha_id"),
//    inverseJoinColumns=@JoinColumn(name="colecionador_id"))
    private Set<Colecionador> colecionadoresPossuem;

    @ManyToMany(mappedBy = "figurinhasDesejadas")
//    joinColumns=@JoinColumn(name="figurinha_id"),
//    inverseJoinColumns=@JoinColumn(name="colecionador_id"))
    private Set<Colecionador> colecionadoresDesejam;

}
