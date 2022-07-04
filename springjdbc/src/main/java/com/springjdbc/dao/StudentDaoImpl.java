package com.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    // inserting the student object into the DB.
	public int insert(Student student) {
		// TODO Auto-generated method stub
		
		 String query="insert into student(id,name,city) values(?,?,?)";
		 int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		 
		return r;
	}
	
	// updating the student object present in the DB.
	public int change(Student student)
	{
		String query ="update student set name=?,city=? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		
		return r;
	}
	
	// Deleting the student object present in the DB.
	public int delete(int studentId)
	{
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query,studentId);
		return r;
	}
	
	// for getting only single student object
	public Student getStudent(int studentId) {
		
		String query="select * from student where id=?";
		RowMapper<Student>rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	
    // for getting the list of objects 
	public List<Student>getAllStudents()
	{
		String query="select * from student";
		List <Student>students=this.jdbcTemplate.query(query,new RowMapperImpl());
		
		return students;
	}
	
	

}
