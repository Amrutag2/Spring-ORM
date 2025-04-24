package com.SpringJdbc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.SpringJdbc.entity.Student;


@Component("studentDao") //AUTOWIRE
public class studentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insert(Student student) {
		String query="insert into student(id,name,city) values (?,?,?)";
		int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	@Override
	public int change(Student student) {
		String query="update student set name=? , city=? where id =?";
		int res=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return res;
	
	}
	
	@Override
	public int delete(int studentID) {
		String query="delete from student where id = ?";
		int res=this.jdbcTemplate.update(query,studentID);
		return res;
	}
	
	@Override
	public Student getStudent(int studentId) {
		//selecting single student data
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student =this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}
	

	@Override
	public List<Student> getAllStudents() {
		String query="select * from student";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> students =this.jdbcTemplate.query(query,rowMapper);
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
