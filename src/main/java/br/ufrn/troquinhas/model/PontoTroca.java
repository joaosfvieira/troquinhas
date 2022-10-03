package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
}
