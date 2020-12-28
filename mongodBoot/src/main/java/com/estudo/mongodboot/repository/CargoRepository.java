package com.estudo.mongodboot.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.estudo.mongodboot.model.Cargo;

@Repository
public interface CargoRepository extends MongoRepository<Cargo, String>{

	@Query("{$and:[{'salario':{$gte:?0}}, {'salario':{$lte: ?1}}]}")
	public List<Cargo> buscarPorRangeDeSalario(BigDecimal de, BigDecimal ate);
	public List<Cargo> findByNomeIgnoreCase(String nome);
	
}
