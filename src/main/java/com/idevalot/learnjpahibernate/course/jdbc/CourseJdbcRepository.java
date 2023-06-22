package com.idevalot.learnjpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.idevalot.learnjpahibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = """
				insert into COURSE (id, name, author)
				values(?, ?, ?);
			""";

	private static String DELETE_QUERY = """ 
				DELETE FROM COURSE WHERE id = ? 
			""";
	
	private static String SELETE_QUERY = """ 
			SELECT id, name, author FROM COURSE where id = ?
		""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {
		//	ResultSet -> Bean => Row Mapper => 
		return springJdbcTemplate.queryForObject(SELETE_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
