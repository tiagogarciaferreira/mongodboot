package com.estudo.mongodboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.mongodboot.model.Cargo;
import com.estudo.mongodboot.model.Funcionario;
import com.estudo.mongodboot.repository.CargoRepository;
import com.estudo.mongodboot.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	
	public Funcionario salvar(Funcionario funcionario) {
		Cargo cargo = this.cargoRepository.findById(funcionario.getCargo().getId()).orElseThrow(() -> new IllegalArgumentException("Cargo inexistente."));
		funcionario.setCargo(cargo);
		return this.funcionarioRepository.save(funcionario);
	}

	public Funcionario atualizar(String funcionarioId, Funcionario funcionario) {
		funcionario.setId(funcionarioId);
		return this.salvar(funcionario);
	}

	public void remover(String funcionarioId) {
		this.funcionarioRepository.deleteById(funcionarioId);
	}

	public Funcionario buscarPorId(String funcionarioId) {
		return this.funcionarioRepository.findById(funcionarioId).orElseThrow(() -> new IllegalArgumentException("Funcionário não existe."));
	}
	
	public List<Funcionario> buscarPorRangeDeIdade(Integer de, Integer ate) {
		return this.funcionarioRepository.buscarPorRangeDeIdade(de, ate);
	}

	public List<Funcionario> buscarPorNome(String nome) {
		return this.funcionarioRepository.findByNomeIgnoreCase(nome);
	}

	public List<Funcionario> listar() {
		return this.funcionarioRepository.findAll();
	}


}
