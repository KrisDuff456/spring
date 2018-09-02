package com.spring.boot.database.app.mySpringBootDatabaseApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.database.app.mySpringBootDatabaseApp.model.SpringBootDataModel;
import com.spring.boot.database.app.mySpringBootDatabaseApp.repository.SpringBootRepository;

@RestController
@RequestMapping("/api")
public class SpringBootDataAppController {

	@Autowired
	SpringBootRepository myRepository;
	
	@PostMapping("/Person")
	public SpringBootDataModel createPerson(@Valid @RequestBody SpringBootDataModel sBDM) {
		return myRepository.save(sBDM);
	}
	
}
