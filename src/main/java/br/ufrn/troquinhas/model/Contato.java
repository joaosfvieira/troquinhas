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
    private Integer idContato;

    @OneToOne
    private Usuario usuario;

    @Column(name = "contato")
    private String contato;

    @Column(name = "descricao")
    private String descricao;
}
