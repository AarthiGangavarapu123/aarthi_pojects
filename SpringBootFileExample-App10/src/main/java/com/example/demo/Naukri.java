package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;


@Entity
@Data
public class Naukri {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		private String name;
		
		@Column(name = "resume",columnDefinition = "LONGBLOB")
		@Lob
		byte[] file;
	}

