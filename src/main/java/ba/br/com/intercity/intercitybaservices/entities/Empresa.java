package ba.br.com.intercity.intercitybaservices.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="nome_oficial", nullable=false)
	private String nomeOficial;
	@Column(name="nome_fantasia", nullable=false)
	private String nomeFantasia;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_empresa", nullable = false, updatable = false)
	private List<Contato> contatos;
	
	public void verificaLista() {
		if(this.getContatos()==null) {
			this.setContatos(new ArrayList<>());
		}
	}
}
