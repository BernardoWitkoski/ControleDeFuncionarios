package br.com.ControleProfissionais.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ControleProfissionais.dto.CargoDTO;
import br.com.ControleProfissionais.entity.CargoEntity;
import br.com.ControleProfissionais.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	public void createCargo(CargoDTO cargo) {
		CargoEntity cargoEntity = new CargoEntity();
		cargoEntity.setDescricao(cargo.getDescricao());
		this.cargoRepository.save(cargoEntity);
	}
	
	public List<CargoDTO> listarTodos() {
		List<CargoDTO> cargoDTOS = new ArrayList<>();
		List<CargoEntity> cargoEntities = cargoRepository.findAll();
		cargoEntities.stream().forEach(object -> {
			CargoDTO cargoDTO = new CargoDTO();
			cargoDTO.setId(object.getId());
			cargoDTO.setDescricao(object.getDescricao());
			cargoDTOS.add(cargoDTO);
		});
		return cargoDTOS;
	}
	
	public void deletaCargo(Long id) {
		CargoEntity cargo = this.cargoRepository.findById(id)
				.orElseThrow(() -> new NullPointerException());
		this.cargoRepository.delete(cargo);
	}
	
}
