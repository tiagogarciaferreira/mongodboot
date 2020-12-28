package com.estudo.mongodboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.mongodboot.model.Cidade;
import com.estudo.mongodboot.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvar(Cidade cidade) {
		return this.cidadeRepository.save(cidade);
	}
	
	public Cidade atualizar(String cidadeId, Cidade cidade) {
		cidade.setId(cidadeId);
		return this.salvar(cidade);
	}
	
	public void remover(String cidadeId) {
		this.cidadeRepository.deleteById(cidadeId);
	}
	
	public Cidade buscarPorId(String cidadeId) {
		return this.cidadeRepository.findById(cidadeId).orElseThrow(() -> new IllegalArgumentException("Cidade não existe."));
	}
	
	public List<Cidade> buscarPorNome(String nome) {
		return this.cidadeRepository.findByNomeIgnoreCase(nome);
	}

	public List<Cidade> listar() {
		return this.cidadeRepository.findAll();
	}
	
}
