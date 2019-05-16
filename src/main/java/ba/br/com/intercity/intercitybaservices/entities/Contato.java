package ba.br.com.intercity.intercitybaservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="contato")
public class Contato {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="tipo_contato", nullable=false)
	private String tipoContato;
	@Column(name="conteudo_contato",nullable=false)
	private String conteudo;
	
	
	
	
}
