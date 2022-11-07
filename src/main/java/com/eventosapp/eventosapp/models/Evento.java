package com.eventosapp.eventosapp.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty ;

@Entity   //define uma tabela no BD
public class Evento implements Serializable { //Interface que faz com que GenerateValue funcioone
	
	private static final long serialVersionUID = 1L;
	
	@Id //cod é um Id no BD
	@GeneratedValue(strategy=GenerationType.AUTO) //Cod é incrementado automaticamente
	private long cod;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String local;
	
	@NotEmpty
	private String data;
	
	@NotEmpty
	private String horario;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL) //para que os filhos de evento(convidado) não populem o bd sem necessidade. retira erro de instrução;
	private List <Convidado> convidado; //é uma lista porque são N convidados
	
	public long getCod() {
		return cod;
	}
	public void setCod(long cod) {
		this.cod = cod;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}		
	
	public List<Convidado> getConvidado() {
		return convidado;
	}
	public void setConvidado(List<Convidado> convidado) {
		this.convidado = convidado;
	}
	
	@Override
	public String toString() {
		return "Evento [nome=" + nome + ", local=" + local + ", data=" + data + ", horario=" + horario + "]";
	}
	
	
	
	
}
