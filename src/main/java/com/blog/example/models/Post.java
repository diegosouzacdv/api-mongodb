package com.blog.example.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document  //no MongoDB a tabela é chamada de Colection a linha da Colection é chamado de documento
@Data
public class Post {
	
	@Id
	private String id;
	private String title;
	private String description;
	private Date date;
	
	@DBRef
	private User user;
}
