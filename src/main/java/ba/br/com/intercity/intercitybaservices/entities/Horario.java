package ba.br.com.intercity.intercitybaservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.joda.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Horario {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="dia_semana")
	private byte diaSemana;
	private LocalTime hora;
	@Column(name="loca_partida")
	private String localPartida;
}
