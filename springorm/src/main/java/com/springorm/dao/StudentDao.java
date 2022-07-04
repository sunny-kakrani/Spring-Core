package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entity.Student;

public class StudentDao {
	
	
	private HibernateTemplate hiberTemplate;
	
	
    //for inserting the student !
	@Transactional
	public int insert(Student student)
	{
		Integer i =(Integer)this.hiberTemplate.save(student);
		return i;
	}
	//get the single object !
	
	public Student getStudent(int studentId) {
		
		Student stud=this.hiberTemplate.get(Student.class, studentId);
		return stud;
		
	}
	
	//get all the students !
	public List<Student>getAllStudents(){
		
		List<Student> students=this.hiberTemplate.loadAll(Student.class);
		return students;
	}
	@Transactional
	public void delete(int studentId)
	{
		Student s=this.hiberTemplate.get(Student.class, studentId);
		this.hiberTemplate.delete(s);
		
	}
	@Transactional
	public void update(Student student) {
		this.hiberTemplate.update(student);
	}
	
	
	
	
	public HibernateTemplate getHiberTemplate() {
		return hiberTemplate;
	}
	public void setHiberTemplate(HibernateTemplate hiberTemplate) {
		this.hiberTemplate = hiberTemplate;
	}
	
	

}
