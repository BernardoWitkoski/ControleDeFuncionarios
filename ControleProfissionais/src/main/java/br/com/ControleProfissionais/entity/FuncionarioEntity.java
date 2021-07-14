package br.com.ControleProfissionais.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Funcionarios")
public class FuncionarioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String Nome;
	
	private String Email;
	
	@Column(nullable = false)
	private boolean Situacao;
	
	@ManyToOne
	@JoinColumn(name = "id_cargo", referencedColumnName = "id", nullable = false)
	private CargoEntity Cargo; 
	
}

