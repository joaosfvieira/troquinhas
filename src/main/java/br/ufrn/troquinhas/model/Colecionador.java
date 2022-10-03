package br.ufrn.troquinhas.model;

import lombok.Getter;
import lombok.Setter;

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
    
    @Column(length = 50)
    private String email;
    
    @OneToOne
    Contato contato;
}
