package kris.duff.mrdvd.springboot.database.myMrDvD.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kris.duff.mrdvd.springboot.database.myMrDvD.exercise.model.myMrDvdExerciseDataModel;

@Repository
public interface MyMrDvdExerciseRepository extends JpaRepository<myMrDvdExerciseDataModel, Long>{
	
}
