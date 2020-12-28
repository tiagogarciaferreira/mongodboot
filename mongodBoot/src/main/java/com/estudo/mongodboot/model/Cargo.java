package com.estudo.mongodboot.model;

import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document(collection = "cargo")
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private BigDecimal salario = BigDecimal.ZERO.setScale(2);
	
	public Cargo(){}
	
}
