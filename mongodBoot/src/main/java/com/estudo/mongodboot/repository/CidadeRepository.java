package com.estudo.mongodboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudo.mongodboot.model.Cidade;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String>{

	public List<Cidade> findByNomeIgnoreCase(String nome);

}
