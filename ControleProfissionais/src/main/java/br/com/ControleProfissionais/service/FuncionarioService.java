package br.com.ControleProfissionais.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ControleProfissionais.dto.CargoDTO;
import br.com.ControleProfissionais.dto.FuncionarioDTO;
import br.com.ControleProfissionais.entity.CargoEntity;
import br.com.ControleProfissionais.entity.FuncionarioEntity;
import br.com.ControleProfissionais.repository.CargoRepository;
import br.com.ControleProfissionais.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	
	public void createFuncionario(FuncionarioDTO funcionario) {
		CargoEntity cargoEntity = this.cargoRepository.getById(funcionario.getCargo());
		FuncionarioEntity funcionarioEntity = new FuncionarioEntity();
		funcionarioEntity.setNome(funcionario.getNome());
		funcionarioEntity.setEmail(funcionario.getEmail());
		funcionarioEntity.setSituacao(funcionario.isSituacao());
		funcionarioEntity.setCargo(cargoEntity);
		this.funcionarioRepository.save(funcionarioEntity);
	}
	

	public List<FuncionarioDTO> listarTodos() {
		List<FuncionarioDTO> funcionarioDTOS = new ArrayList<>();
		//CargoDTO cargoDTO = new CargoDTO();
		CargoEntity cargoEntity = new CargoEntity();
		List<FuncionarioEntity> funcionarioEntities = funcionarioRepository.findAll();
		funcionarioEntities.stream().forEach(object -> {
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
			funcionarioDTO.setId(object.getId());
			funcionarioDTO.setNome(object.getNome());
			funcionarioDTO.setEmail(object.getEmail());
			funcionarioDTO.setSituacao(object.isSituacao());
			//funcionarioDTO.setCargo(cargoDTO.getId());
			funcionarioDTO.setCargo(cargoEntity.getId());
			funcionarioDTOS.add(funcionarioDTO);
		});
		return funcionarioDTOS;
	}
	
	public void deletaFuncionario(Long id) {
		FuncionarioEntity funcionario = this.funcionarioRepository.findById(id)
				.orElseThrow(() -> new NullPointerException());
		this.funcionarioRepository.delete(funcionario);
	}
	
}
