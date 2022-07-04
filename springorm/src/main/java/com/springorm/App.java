package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/springorm/config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
		/*
		 * Student stud=new Student(); stud.setStudentCity("gwalior");
		 * stud.setStudentId(500); stud.setStudentName("jyoti");
		 * 
		 * int r=studentDao.insert(stud); System.out.println(r);
		 */
		 
		
		  BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		  boolean go=true;
		  
		  while(go) { 
		  System.out.println("Press 1 for add new student");
		  System.out.println("Press 2 for display all students");
		  System.out.println("Press 3 for getting the details of single student");
		  System.out.println("Press 4 for delete student");
		  System.out.println("Press 5 for updating the student");
		  System.out.println("Press 6 for exit");
		  
		  try { 
			  int ip=Integer.parseInt(br.readLine()); 
			  switch(ip) 
			  { 
			  case 1:
		        System.out.println("Enter user Id"); 
		        int uid=Integer.parseInt(br.readLine());
		  System.out.println("Enter user name"); 
		  String name=br.readLine();
		  System.out.println("Enter user city"); 
		  String city=br.readLine();
		  
		  Student s=new Student();
		  s.setStudentId(uid); 
		  s.setStudentName(name);
		  s.setStudentCity(city);
		  
		  int r=studentDao.insert(s); 
		  System.out.println(r+ " student added");
		  System.out.println("******************"); System.out.println();
		 break;
		  
		  case 2: System.out.println("************************************");
		  List<Student>students=studentDao.getAllStudents(); 
		  for(Student stud:students)
		  { 
		  System.out.println("Name "+stud.getStudentName());
		  System.out.println("id "+stud.getStudentId());
		  System.out.println("city "+stud.getStudentCity());
		  System.out.println("*****************************************"); } break;
		  
		  case 3: 
			  System.out.println("Enter user Id"); 
		        int userid=Integer.parseInt(br.readLine());
		        Student st=studentDao.getStudent(userid);
		        System.out.println("Name "+st.getStudentName());
				  System.out.println("id "+st.getStudentId());
				  System.out.println("city "+st.getStudentCity());
		        
			  
			  break;
		  
		  case 4:
			  System.out.println("enter the user id");
			  int usid=Integer.parseInt(br.readLine());
		        studentDao.delete(usid);
		        System.out.println("Student deleted");
			  
			  break;
			  
			  
			  case 5:
				  //will do later this updation part .
				  break; 
			  case 6: go=false; 
			  break;
		  
		  }
		  
		  } catch(Exception e) {
		  System.out.println("Invalid input , try for another one");
		  System.out.println(e.getMessage()); }
		  
		  } System.out.println("thank you for using the application");
		 
        
    }
}
