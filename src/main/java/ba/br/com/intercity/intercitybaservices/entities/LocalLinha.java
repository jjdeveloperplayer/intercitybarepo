package ba.br.com.intercity.intercitybaservices.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LocalLinha {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private byte ordem;
}
