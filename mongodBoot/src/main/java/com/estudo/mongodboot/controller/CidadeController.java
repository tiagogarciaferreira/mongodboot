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

import com.estudo.mongodboot.model.Cidade;
import com.estudo.mongodboot.service.CidadeService;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@PostMapping
	@ResponseBody
	public Cidade criar(@RequestBody Cidade cidade) {
		return this.cidadeService.salvar(cidade);
	}
	
	@PutMapping("/{cidadeId}")
	@ResponseBody
	public Cidade atualizar(@PathVariable String cidadeId, @RequestBody Cidade cidade) {
		return this.cidadeService.atualizar(cidadeId, cidade);
	}
	
	@DeleteMapping("/{cidadeId}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String cidadeId) {
		this.cidadeService.remover(cidadeId);
	}
	
	@GetMapping("/{cidadeId}")
	@ResponseBody
	public Cidade buscarPorId(@PathVariable String cidadeId) {
		return this.cidadeService.buscarPorId(cidadeId);
	}

	@GetMapping("/por-nome")
	@ResponseBody
	public List<Cidade> buscarPorNome(@RequestParam("nome") String nome) {
		return this.cidadeService.buscarPorNome(nome);
	}

	@GetMapping
	@ResponseBody
	public List<Cidade> listar() {
		return this.cidadeService.listar();
	}
}
