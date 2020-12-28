package com.estudo.mongodboot.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.mongodboot.model.Cargo;
import com.estudo.mongodboot.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo salvar(Cargo cargo) {
		return this.cargoRepository.save(cargo);
	}

	public Cargo atualizar(String cargoId, Cargo cargo) {
		cargo.setId(cargoId);
		return this.salvar(cargo);
	}
	
	public void remover(String cargoId) {
		this.cargoRepository.deleteById(cargoId);
	}
	
	public Cargo buscarPorId(String cargoId) {
		return this.cargoRepository.findById(cargoId).orElseThrow(() -> new IllegalArgumentException("Cargo não existe."));
	}
	
	public List<Cargo> buscarPorRangeDeSalario(BigDecimal de, BigDecimal ate) {
		return this.cargoRepository.buscarPorRangeDeSalario(de, ate);
	}

	public List<Cargo> buscarPorNome(String nome) {
		return this.cargoRepository.findByNomeIgnoreCase(nome);
	}

	public List<Cargo> listar() {
		return this.cargoRepository.findAll();
	}
}
