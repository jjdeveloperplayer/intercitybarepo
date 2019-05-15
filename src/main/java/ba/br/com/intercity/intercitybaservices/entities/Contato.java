package ba.br.com.intercity.intercitybaservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contato {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable=false)
	private String tipoContato;
	@Column(nullable=false)
	private String conteudo;
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public Contato(int id, String tipoContato, String conteudo) {
		super();
		this.id = id;
		this.tipoContato = tipoContato;
		this.conteudo = conteudo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
	
}
