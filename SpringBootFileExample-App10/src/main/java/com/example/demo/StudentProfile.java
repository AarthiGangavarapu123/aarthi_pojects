
package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import lombok.Data;

@Data
@Entity

public class StudentProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "stdname")
	private String stdName;
	
	@Column(name = "qualification")
	private String qlf;
	
	
	@Column(name = "resume",columnDefinition = "LONGBLOB")
	@Lob
	byte[] resume;
	
	
	@Column(name = "fileName")
	private String fileName;


	
}
