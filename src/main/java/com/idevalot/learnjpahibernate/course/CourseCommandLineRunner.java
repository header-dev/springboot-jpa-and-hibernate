package com.idevalot.learnjpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.idevalot.learnjpahibernate.course.jdbc.CourseJdbcRepository;
import com.idevalot.learnjpahibernate.course.jpa.CourseJpaRepository;
import com.idevalot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(
				new Course(1, "Learn AWS JPA", "WizDev")
				);
		repository.save(
				new Course(2, "Learn Azure Now JPA!", "WizDev")
				);
		repository.save(
				new Course(3, "Learn DevOps Now JPA", "WizDev")
				);
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("WizDev"));
		System.out.println(repository.findByAuthor(""));
		
		
		System.out.println(repository.findByName("Learn DevOps Now JPA"));
		System.out.println(repository.findByName("Learn Azure Now JPA!"));
		
	}

}
