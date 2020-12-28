package com.estudo.mongodboot.model;


import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "formas_pagamento")
public class FormasPagamento {
	
	@Id
	private String id;
	private String nome;
	@CreatedDate
	private LocalDateTime dataCriacao;
	
	public FormasPagamento() {}
}
