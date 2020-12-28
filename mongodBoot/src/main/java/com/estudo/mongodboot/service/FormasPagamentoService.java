package com.estudo.mongodboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.estudo.mongodboot.model.FormasPagamento;
import com.estudo.mongodboot.repository.FormasPagamentoRepository;

@Service
public class FormasPagamentoService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private FormasPagamentoRepository formasPagamentoRepository;
	
	public FormasPagamento salvar(FormasPagamento formasPagamento) {
		return this.mongoTemplate.save(formasPagamento);
	}
	
	public FormasPagamento atualizar(String formasPagamentoId, FormasPagamento formasPagamento) {
		formasPagamento.setId(formasPagamentoId);
		return this.mongoTemplate.save(formasPagamento);
	}
	
	public void remover(String formasPagamentoId) {
		this.mongoTemplate.remove(this.buscarPorId(formasPagamentoId));
	}
	
	public FormasPagamento buscarPorId(String formasPagamentoId) {
		return this.mongoTemplate.findById(formasPagamentoId, FormasPagamento.class);
	}

	public List<FormasPagamento> buscarPorNome(String nome) {
		return this.formasPagamentoRepository.buscarPorNome(nome);
	}

	public List<FormasPagamento> listar() {
		return this.mongoTemplate.findAll(FormasPagamento.class);
	}

}
