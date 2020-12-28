package com.estudo.mongodboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.mongodboot.model.Estado;
import com.estudo.mongodboot.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return this.estadoRepository.save(estado);
	}

	public Estado atualizar(String estadoId, Estado estado) {
		estado.setId(estadoId);
		return this.salvar(estado);
	}
	
	public void remover(String estadoId) {
		this.estadoRepository.deleteById(estadoId);
	}
	
	public Estado buscarPorId(String estadoId) {
		return this.estadoRepository.findById(estadoId).orElseThrow(() -> new IllegalArgumentException("Estado não existe."));
	}

	public Estado buscarPorSigla(String sigla) {
		return this.estadoRepository.findBySiglaIgnoreCase(sigla);
	}
	
	public List<Estado> buscarPorNome(String nome) {
		return this.estadoRepository.findByNomeIgnoreCase(nome);
	}

	public List<Estado> listar() {
		return this.estadoRepository.findAll();
	}
}
