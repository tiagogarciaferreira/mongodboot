package com.estudo.mongodboot.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "funcionario")
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private Integer idade;
	@DBRef 
	private Cargo cargo;
	
	public Funcionario(){}
}
