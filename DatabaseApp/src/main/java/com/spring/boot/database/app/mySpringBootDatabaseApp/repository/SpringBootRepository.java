package com.spring.boot.database.app.mySpringBootDatabaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.database.app.mySpringBootDatabaseApp.model.SpringBootDataModel;

public interface SpringBootRepository extends JpaRepository<SpringBootDataModel, Long> {

}
