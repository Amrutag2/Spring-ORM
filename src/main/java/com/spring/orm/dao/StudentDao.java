package com.spring.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

import java.util.List;

import javax.transaction.Transactional;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return 1;
	}

	
	//get the single data(object)
	public Student getStudent(int studentId) {
		Student student = (Student)this.hibernateTemplate.get(Student.class,studentId);
		return student;
		
	}
	
	//get all rows
	public List<Student> getAllStudents(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//delete
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = (Student)this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//updating
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
