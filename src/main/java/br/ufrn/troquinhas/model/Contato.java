package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Colecionador colecionador;

    @Column(name = "contato", length=50)
    private String contato;

    @Column(name = "descricao", length=50)
    private String descricao;
}
