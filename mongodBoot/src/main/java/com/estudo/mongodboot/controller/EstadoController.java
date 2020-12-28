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

import com.estudo.mongodboot.model.Estado;
import com.estudo.mongodboot.service.EstadoService;

@Controller
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;

	@PostMapping
	@ResponseBody
	public Estado criar(@RequestBody Estado estado) {
		return this.estadoService.salvar(estado);
	}

	@PutMapping("/{estadoId}")
	@ResponseBody
	public Estado atualizar(@PathVariable String estadoId, @RequestBody Estado estado) {
		return this.estadoService.atualizar(estadoId, estado);
	}
	
	@DeleteMapping("/{estadoId}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String estadoId) {
		this.estadoService.remover(estadoId);
	}
	
	@GetMapping("/{estadoId}")
	@ResponseBody
	public Estado buscarPorId(@PathVariable String estadoId) {
		return this.estadoService.buscarPorId(estadoId);
	}
	
	@GetMapping("/por-sigla")
	@ResponseBody
	public Estado buscarPorSigla(@RequestParam("sigla") String sigla) {
		return this.estadoService.buscarPorSigla(sigla);
	}

	@GetMapping("/por-nome")
	@ResponseBody
	public List<Estado> buscarPorNome(@RequestParam("nome") String nome) {
		return this.estadoService.buscarPorNome(nome);
	}

	@GetMapping
	@ResponseBody
	public List<Estado> listar() {
		return this.estadoService.listar();
	}
	
}
