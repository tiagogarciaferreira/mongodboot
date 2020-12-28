package com.estudo.mongodboot.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.estudo.mongodboot.model.Cargo;
import com.estudo.mongodboot.service.CargoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;

	@PostMapping
	@ResponseBody
	public Cargo criar(@RequestBody Cargo cargo) {
		return this.cargoService.salvar(cargo);
	}

	@PutMapping("/{cargoId}")
	@ResponseBody
	public Cargo atualizar(@PathVariable String cargoId, @RequestBody Cargo cargo) {
		return this.cargoService.atualizar(cargoId, cargo);
	}
	
	@DeleteMapping("/{cargoId}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String cargoId) {
		this.cargoService.remover(cargoId);
	}
	
	@GetMapping("/{cargoId}")
	@ResponseBody
	public Cargo buscarPorId(@PathVariable String cargoId) {
		return this.cargoService.buscarPorId(cargoId);
	}
	
	@GetMapping("/range")
	@ResponseBody
	public List<Cargo> buscarPorRangeDeSalrio(@RequestParam("de") BigDecimal de, @RequestParam("ate") BigDecimal ate) {
		return this.cargoService.buscarPorRangeDeSalario(de, ate);
	}

	@GetMapping("/por-nome")
	@ResponseBody
	public List<Cargo> buscarPorNome(@RequestParam("nome") String nome) {
		return this.cargoService.buscarPorNome(nome);
	}

	@GetMapping
	@ResponseBody
	public List<Cargo> listar() {
		return this.cargoService.listar();
	}
	
}
