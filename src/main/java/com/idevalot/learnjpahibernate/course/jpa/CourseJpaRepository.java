package com.idevalot.learnjpahibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.idevalot.learnjpahibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager enityManager;

	public void insert(Course course) {
		enityManager.merge(course);
	}

	public Course findById(long id) {
		return enityManager.find(Course.class, id);
	}

	public void deleteById(long id) {
		Course course = enityManager.find(Course.class, id);
		enityManager.remove(course);
	}

}
