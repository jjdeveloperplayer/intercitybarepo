package ba.br.com.intercity.intercitybaservices.entities;

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
@Table(name="tipoveiculo")
public class TipoVeiculo {
	@Id
	@GeneratedValue
	private long id;
	private String tipo;
	private String categoria;
}
