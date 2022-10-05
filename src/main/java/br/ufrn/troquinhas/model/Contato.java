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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "contato")
    private Colecionador colecionador;

    @Column(name = "contato", length=50)
    private String numeroOuEmail;

    @Column(name = "descricao", length=50)
    private String descricao;

}
