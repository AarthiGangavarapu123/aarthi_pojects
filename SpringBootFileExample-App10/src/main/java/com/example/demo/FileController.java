package com.example.demo;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FileController {
	
	@Autowired
	Dao dao;
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
		
		StudentProfile sp = new StudentProfile();
		//sp.setId(1);
		sp.setQlf("mca");
		sp.setStdName("aarthi");
		System.out.println("from postman:"+sp);
		sp.setFileName(file.getOriginalFilename());
		try {
			sp.setResume(file.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 dao.save(sp);
		return ResponseEntity.ok("File uploaded successfully"+file.getOriginalFilename());
		
	}
	@PostMapping("/multiupload")
	public ResponseEntity<String> upload1(@RequestParam("file") MultipartFile[] file)throws IOException{
		for(MultipartFile f : file) {
			Naukri sp = new Naukri();
			sp.setName("chowdary");
			sp.setFile(f.getBytes());
			dao.save(sp);
		}
		return ResponseEntity.ok("File uploaded successfully");
	}
	
	@GetMapping("/download/{sid}")
	public ResponseEntity<Resource> download(@PathVariable("sid") int sid){
		Optional<StudentProfile> findById = dao.findById(sid);
		if(findById.isPresent()) {
			StudentProfile studentProfile = findById.get();
            ByteArrayResource resource = new ByteArrayResource(studentProfile.getResume());
          return   ResponseEntity.ok()
            .contentLength(studentProfile.getResume().length)
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + studentProfile.getFileName() + "\"")
            .body(resource);
		}else {
            return ResponseEntity.badRequest().build();
		}


	
}}
