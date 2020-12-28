package com.estudo.mongodboot.controller;

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

import com.estudo.mongodboot.model.FormasPagamento;
import com.estudo.mongodboot.service.FormasPagamentoService;

@Controller
@RequestMapping("/formas_pagamento")
public class FormasPagamentoController {

	@Autowired
	private FormasPagamentoService formasPagamentoService;

	@PostMapping
	@ResponseBody
	public FormasPagamento criar(@RequestBody FormasPagamento formasPagamento) {
		return this.formasPagamentoService.salvar(formasPagamento);
	}

	@PutMapping("/{formasPagamentoId}")
	@ResponseBody
	public FormasPagamento atualizar(@PathVariable String formasPagamentoId, @RequestBody FormasPagamento formasPagamento) {
		return this.formasPagamentoService.atualizar(formasPagamentoId, formasPagamento);
	}

	@DeleteMapping("/{formasPagamentoId}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String formasPagamentoId) {
		this.formasPagamentoService.remover(formasPagamentoId);
	}

	@GetMapping("/{formasPagamentoId}")
	@ResponseBody
	public FormasPagamento buscarPorId(@PathVariable String formasPagamentoId) {
		return this.formasPagamentoService.buscarPorId(formasPagamentoId);
	}

	@GetMapping("/por-nome")
	@ResponseBody
	public List<FormasPagamento> buscarPorNome(@RequestParam("nome") String nome) {
		return this.formasPagamentoService.buscarPorNome(nome);
	}

	@GetMapping
	@ResponseBody
	public List<FormasPagamento> listar() {
		return this.formasPagamentoService.listar();
	}

}
