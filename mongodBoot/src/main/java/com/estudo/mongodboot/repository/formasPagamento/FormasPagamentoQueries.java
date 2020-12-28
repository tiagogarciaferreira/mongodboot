package com.estudo.mongodboot.repository.formasPagamento;

import java.util.List;

import com.estudo.mongodboot.model.FormasPagamento;

public interface FormasPagamentoQueries {

	public List<FormasPagamento> buscarPorNome(String nome);
	
}
