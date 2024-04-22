package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.entity.UploadStudent;
import com.example.demo.repo.StdRepository;

@Service
public class StudentService {
	
	@Autowired
	private StdRepository repository;
  
	 public Page<UploadStudent> getUsersPgebypage(int pageNum, int pageSize){
 		 PageRequest of = PageRequest.of(pageNum -1, pageSize);
 		  Page<UploadStudent> all = repository.findAll(of);
 		 return all;
 	 }

	 public List<UploadStudent> getAllProductsSortedByPriceAndName() {
		   Sort sort = Sort.by(Sort.Direction.ASC, "category").and(Sort.by(Sort.Direction.DESC, "price"));
	       return repository.findAll(sort);
		
	 }

	public List<UploadStudent> getAllStudentsSortedByEmailAndName() {
		// TODO Auto-generated method stub
		return null;
	}


	    }

	 
	

