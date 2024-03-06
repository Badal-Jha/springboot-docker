package com.badal.springbootdocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    @Autowired
    StudentRepository studentRepository;
	@GetMapping
	ResponseEntity<String> getUsers(){
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Happy coding!!");
	}
	@GetMapping("/save")	
	ResponseEntity<String> postStudent(){
		System.out.println("call to save");
		studentRepository.save(new Student("Badal",3));
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Happy coding!!");
	}
	
}
