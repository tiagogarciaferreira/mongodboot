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

import com.estudo.mongodboot.model.Funcionario;
import com.estudo.mongodboot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	@ResponseBody
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionarioService.salvar(funcionario);
	}
	
	@PutMapping("/{funcionarioId}")
	@ResponseBody
	public Funcionario atualizar(@PathVariable String funcionarioId, @RequestBody Funcionario funcionario) {
		return this.funcionarioService.atualizar(funcionarioId, funcionario);
	}
	
	@DeleteMapping("/{funcionarioId}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String funcionarioId) {
		this.funcionarioService.remover(funcionarioId);
	}

	@GetMapping("/{funcionarioId}")
	@ResponseBody
	public Funcionario buscarPorId(@PathVariable String funcionarioId) {
		return this.funcionarioService.buscarPorId(funcionarioId);
	}
	
	@GetMapping("/range")
	@ResponseBody
	public List<Funcionario> buscarPorRangeDeIdade(@RequestParam("de") Integer de, @RequestParam("ate") Integer ate) {
		return this.funcionarioService.buscarPorRangeDeIdade(de, ate);
	}

	@GetMapping("/por-nome")
	@ResponseBody
	public List<Funcionario> buscarPorNome(@RequestParam("nome") String nome) {
		return this.funcionarioService.buscarPorNome(nome);
	}

	@GetMapping
	@ResponseBody
	public List<Funcionario> listar() {
		return this.funcionarioService.listar();
	}
}
