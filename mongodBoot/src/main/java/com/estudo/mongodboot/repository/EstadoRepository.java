package com.estudo.mongodboot.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.estudo.mongodboot.model.Estado;

@Repository
public interface EstadoRepository extends MongoRepository<Estado, String> {

	public List<Estado> findByNomeIgnoreCase(String nome);
	public Estado findBySiglaIgnoreCase(String nome);
	
}
