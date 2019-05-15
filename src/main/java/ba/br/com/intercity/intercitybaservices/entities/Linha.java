package ba.br.com.intercity.intercitybaservices.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Linha {
	@Id
	private String id;
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tipo_veiculo")
	private TipoVeiculo tipo;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_linha")
	private List<LocalLinha> locais;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_linha")
	private List<Horario> horarios;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="empresa")
	private Empresa empresa;
}

