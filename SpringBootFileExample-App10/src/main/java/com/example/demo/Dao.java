package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dao extends JpaRepository<StudentProfile, Integer>{

	void save(Naukri sp);

	

	

}
