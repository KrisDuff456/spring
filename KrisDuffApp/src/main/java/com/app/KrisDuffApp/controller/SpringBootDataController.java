package com.app.KrisDuffApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.KrisDuffApp.execption.ResourceNotFoundExeption;
import com.app.KrisDuffApp.model.SpringBootDataModel;
import com.app.KrisDuffApp.repository.SpringBootRepository;

@RestController
@RequestMapping("/api")
public class SpringBootDataController {

	@Autowired
	SpringBootRepository myRepo;
	
	//Method to create Person
	@PostMapping("/personmodel")
	public SpringBootDataModel createPerson(@Valid @RequestBody SpringBootDataModel sDM ) {
		return myRepo.save(sDM);
}
	//Method to get person id
	@GetMapping("person/{id}")
	public SpringBootDataModel getPersonbyID(@PathVariable(value ="id") Long personID) {
		return myRepo.findById(personID).orElseThrow(()-> new ResourceNotFoundExeption("","id",personID));
	}
	//Method to get all people
	@GetMapping("/person")
	public List<SpringBootDataModel> getAllPeople(){
		return myRepo.findAll();
	}
	//method to update person
	@PutMapping("/person{id}")
	public SpringBootDataModel updatePerson(@PathVariable(value = "id") Long personID,@Valid @RequestBody SpringBootDataModel personDetails) {
		SpringBootDataModel sDM = myRepo.findById(personID).orElseThrow(() -> new ResourceNotFoundExeption("Person","id", personID));
		
		sDM.setName(personDetails.getName());
		sDM.setAddress(personDetails.getAddress());
		sDM.setAge(personDetails.getAge());
		SpringBootDataModel updateDate = myRepo.save(sDM);
		return updateDate;
	}
	//method to delete person
	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id")Long personID){
		SpringBootDataModel sDM = myRepo.findById(personID).orElseThrow(() -> new ResourceNotFoundExeption("Person","id", personID));
		
		myRepo.delete(sDM);
		return ResponseEntity.ok().build();
    }
}
