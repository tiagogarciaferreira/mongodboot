package com.estudo.mongodboot.repository.formasPagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.estudo.mongodboot.model.FormasPagamento;

@Repository
public class FormasPagamentoRepositoryImpl implements FormasPagamentoQueries{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<FormasPagamento> buscarPorNome(String nome) {
		Query query = new Query();
		query.addCriteria(Criteria.where("nome").is(nome).regex("^"+nome+"$", "i"));
		return mongoTemplate.find(query, FormasPagamento.class);
	}
	
}
