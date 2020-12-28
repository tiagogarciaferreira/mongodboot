package com.estudo.mongodboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudo.mongodboot.model.FormasPagamento;
import com.estudo.mongodboot.repository.formasPagamento.FormasPagamentoQueries;

@Repository
public interface FormasPagamentoRepository extends MongoRepository<FormasPagamento, String>, FormasPagamentoQueries {

}
