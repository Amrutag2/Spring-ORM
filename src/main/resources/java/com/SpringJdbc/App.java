package com.SpringJdbc;

import java.util.List;

/**
 * Hello world!
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.SpringJdbc.Dao.StudentDao;
import com.SpringJdbc.entity.Student;

public class App {
    public static void main(String[] args) {
        System.out.println("My Program started...........");
        //spring jdbc-> JdbcTemplate
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class); 
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
//        
//        //insert query
//        String query="insert into student(id,name,city) values (?,?,?)";
//        //fire query - no connection established
//        int result = jdbcTemplate.update(query,46,"Sneha","Mumbai");
//        System.out.println(result+" this is no of records inserted");
//        
        //2nd way using dao
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        Student student = new Student();
        //insert
//        student.setId(21);
//        student.setName("Jack");
//        student.setCity("Delhi");
//        int r = studentDao.insert(student);
//        System.out.println("student add "+r);
        
        //update
//        student.setId(21);
//        student.setCity("Delhiask");
//        student.setName("Jack-jill");
//        int r = studentDao.change(student);
//        System.out.println("student add "+r);
        
        //delete
//        int r = studentDao.delete(1);
//        System.out.println("student deleted "+r);
        
        
        //Selecting
        Student s1 = studentDao.getStudent(21);
        System.out.println(s1);
        System.out.println(s1.getId());
        System.out.println(s1.getCity());
        System.out.println(s1.getName());
        
        List<Student> s2 = studentDao.getAllStudents();
        for(Student s:s2) {
        	System.out.println(s);
        }
    }
}
