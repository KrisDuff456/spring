package kris.duff.mrdvd.springboot.database.myMrDvD.exercise.controller;

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

import kris.duff.mrdvd.springboot.database.myMrDvD.exercise.exception.ResourceNotFoundException;
import kris.duff.mrdvd.springboot.database.myMrDvD.exercise.model.myMrDvdExerciseDataModel;
import kris.duff.mrdvd.springboot.database.myMrDvD.exercise.repository.MyMrDvdExerciseRepository;

@RestController
@RequestMapping("/api")
public class MyMrDvdExerciseDvdController {
	
	@Autowired
	MyMrDvdExerciseRepository dvdRepo;
	
	//Create DVD 
	@PostMapping("/Dvd")
	public myMrDvdExerciseDataModel createDvD(@Valid @RequestBody myMrDvdExerciseDataModel mDDM) {
	      return dvdRepo.save(mDDM);
	}
	
	//Get DVD
	@PostMapping("Dvd/{id}")
	public myMrDvdExerciseDataModel getDvdID(@PathVariable(value = "id")Long filmId) {
		return dvdRepo.findById(filmId).orElseThrow(()-> new ResourceNotFoundException("myMrDvdExerciseDataModel","id",filmId));
	}
	//Get a list of DVDs
	@GetMapping("/Dvd")
	public List<myMrDvdExerciseDataModel> getAllDvds(){
		return dvdRepo.findAll();
	}
	//Update DVD
	@PutMapping("/Dvd/{id}")
	public myMrDvdExerciseDataModel updateDvd(@PathVariable(value = "id") Long filmId, @Valid @RequestBody myMrDvdExerciseDataModel dvdDetails) {
		
		myMrDvdExerciseDataModel mDDM = dvdRepo.findById(filmId).orElseThrow(() -> new ResourceNotFoundException("myMrDvdExerciseDataModel","id",filmId));
		
		mDDM.setTitleName(dvdDetails.getTitleName());
		mDDM.setDescription(dvdDetails.getDescription());
		mDDM.setFilmLenght(dvdDetails.getFilmLenght());
		
		myMrDvdExerciseDataModel updateData = dvdRepo.save(mDDM);
		return updateData;
	}
	//Delete DVD
	@DeleteMapping("/Dvd/{id}")
	public ResponseEntity<?> deleteDVD(@PathVariable(value = "id")Long filmId){
		myMrDvdExerciseDataModel mDDM = dvdRepo.findById(filmId).orElseThrow(()-> new ResourceNotFoundException("myMrDvdExerciseDataModel","id",filmId));
		
		dvdRepo.delete(mDDM);
		return ResponseEntity.ok().build();
	}

}
