package com.spring.orm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("ormConfig.xml");
       StudentDao studentDao = (StudentDao)context.getBean("studentDao",StudentDao.class);
//       Student student = new Student(255,"Amruta VJTI","Matunga");
//       
//       int r = studentDao.insert(student);
//       System.out.println(r+" done");
       
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean go=true;
       while(go) {
    	   System.out.println("Press 1 to add new Student");
           System.out.println("Press 2 to display all Students");
           System.out.println("Press 3 to get details of single Student");
           System.out.println("Press 4 to delete students");
           System.out.println("Press 5 to update students");
           System.out.println("Press 6 to exit");
           
           try {
        	   int x = Integer.parseInt(br.readLine());
        	   switch(x) {
        	   
        	   case 1://add a new student
        		   System.out.println("enter user id");
        		   int uid = Integer.parseInt(br.readLine());
        		   System.out.println("enter user name");
        		   String uname = br.readLine();
        		   System.out.println("enter user city");
        		   String ucity = br.readLine();
        		   Student student = new Student(uid,uname,ucity);
        		   Integer i = (Integer)studentDao.insert(student);
        		   System.out.println(i+" student added");
        		   break;
        		   
        	   case 2: //display all student
        		   List<Student> s = studentDao.getAllStudents();
        		   for(Student st:s) {
        			   System.out.println("Id : "+st.getStudentId());
        			   System.out.println("Name : "+st.getStudentName());
        			   System.out.println("City : "+st.getStudentCity());
        			   System.out.println("==================================");
        		   }
        		   break;
        		   
        	   case 3:  //get single student data
        		   try {
            		   System.out.println("enter user id");
            		   int id = Integer.parseInt(br.readLine());
            		   Student stude = studentDao.getStudent(id);
            		   System.out.println("Id : "+stude.getStudentId());
        			   System.out.println("Name : "+stude.getStudentName());
        			   System.out.println("City : "+stude.getStudentCity());
        			   System.out.println("==================================");
        			   
        		   }catch(Exception e) {
        			   System.out.println("user with this id does not exists");
        		   }

        		   break;
        		   
        	   case 4: //delete student
        		   try {
            		   System.out.println("enter user id");
            		   int idx = Integer.parseInt(br.readLine());
            		  studentDao.getStudent(idx);
            		  System.out.println("user is deleted");
        		   }catch(Exception e) {
        			   System.out.println("user with this id does not exists");
        		   }
        		   break;
        		   
        	   case 5:  //update the student
        		   System.out.println("enter user id");
        		   int ui = Integer.parseInt(br.readLine());
        		   System.out.println("enter user name");
        		   String unae = br.readLine();
        		   System.out.println("enter user city");
        		   String uity = br.readLine();
        		   Student studnt = new Student(ui,unae,uity);
        		   studentDao.updateStudent(studnt);
        		   System.out.println("student updated");
        		   break;
        		   
        	   case 6: 
        		   go=false;
        		   break;   
        	   }
        	   
        	   
           }catch(Exception e) {
        	   System.out.println("Invalis input try with another one!!");
        	   System.out.println(e.getMessage());
           }
       }
       System.out.println("Thank ypu for using my studnets");
  }
}
