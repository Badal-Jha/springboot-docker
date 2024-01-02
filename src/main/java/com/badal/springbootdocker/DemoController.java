package com.badal.springbootdocker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {

	@GetMapping
	ResponseEntity<String> getUsers(){
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Happy coding!!");
	}
}
