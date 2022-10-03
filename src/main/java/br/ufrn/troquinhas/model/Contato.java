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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Colecionador getColecionador() {
		return colecionador;
	}

	public void setColecionador(Colecionador colecionador) {
		this.colecionador = colecionador;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}
