package br.com.ControleProfissionais.dto;

import br.com.ControleProfissionais.entity.CargoEntity;
import lombok.Data;

@Data
public class FuncionarioDTO {

	
	private String nome;
	
	private String email;
	
	private boolean situacao;

	private Long cargo;
	
}
