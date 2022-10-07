package com.eventosapp.eventosapp.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty ;

@Entity
public class Convidado implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id //cod é um Id no BD
	@GeneratedValue(strategy=GenerationType.AUTO) //Cod é incrementado automaticamente
	private long id;
	
	@NotEmpty
	private String rg;
	
	@NotEmpty
	private String nomeConvidado;
	
	@ManyToOne()
	private Evento evento;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeConvidado() {
		return nomeConvidado;
	}
	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	@Override
	public String toString() {
		return "Convidado [id=" + id + ", rg=" + rg + ", nomeConvidado=" + nomeConvidado + ", evento=" + evento + "]";
	}
	
	
	
	
	
	
	

}
