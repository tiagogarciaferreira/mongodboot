package com.estudo.mongodboot.model.events;

import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;

import com.estudo.mongodboot.model.FormasPagamento;

@Component
public class FormasPagamentoCallback implements BeforeSaveCallback<FormasPagamento>{

	@Override
	public FormasPagamento onBeforeSave(FormasPagamento formaPagamento, Document document, String collection) {
		System.out.println("Evento antes de salvar a entidade!!!");
		return formaPagamento;
	}

}
