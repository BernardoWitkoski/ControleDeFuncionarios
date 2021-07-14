package br.com.ControleProfissionais.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ControleProfissionais.dto.CargoDTO;
import br.com.ControleProfissionais.repository.CargoRepository;
import br.com.ControleProfissionais.service.CargoService;

@RestController
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cargos")
	public ResponseEntity<List<CargoDTO>> listarTodos() {
		return ResponseEntity.ok(cargoService.listarTodos());
	}
	
	@PostMapping("/cargo")
	public ResponseEntity<Void> createCargo(@RequestBody CargoDTO cargo) {
		cargoService.createCargo(cargo);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("cargos/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.cargoService.deletaCargo(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
