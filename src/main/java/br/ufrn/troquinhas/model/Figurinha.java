package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

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
}
