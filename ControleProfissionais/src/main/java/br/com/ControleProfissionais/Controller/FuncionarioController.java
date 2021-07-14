package br.com.ControleProfissionais.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ControleProfissionais.dto.FuncionarioDTO;
import br.com.ControleProfissionais.service.FuncionarioService;

@RestController
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/funcionarios")
	public ResponseEntity<List<FuncionarioDTO>> listarTodos() {
		return ResponseEntity.ok(funcionarioService.listarTodos());
	}
	
	@PostMapping("/funcionario")
	public ResponseEntity<Void> createFuncionario(@RequestBody FuncionarioDTO funcionario) {
		funcionarioService.createFuncionario(funcionario);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/funcionarios/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.funcionarioService.deletaFuncionario(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
}
 