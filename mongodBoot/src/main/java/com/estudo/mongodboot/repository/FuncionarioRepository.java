package com.estudo.mongodboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudo.mongodboot.model.Funcionario;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String>{

	@Query("{$and:[{'idade':{$gte:?0}}, {'idade':{$lte: ?1}}]}")
	public List<Funcionario> buscarPorRangeDeIdade(Integer de, Integer ate);
	public List<Funcionario> findByNomeIgnoreCase(String nome);
	
}
