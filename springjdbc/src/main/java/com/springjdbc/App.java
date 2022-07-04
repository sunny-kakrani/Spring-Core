package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started.....!");
        
        ApplicationContext context= new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
        
        // StudentDao interface he and hum application context(IOC) se StudentDaoImpl ka object mang rahe he!
        StudentDao studentDao= context.getBean("studentDao", StudentDao.class);
        
		/*
		 * Student stud1=new Student();
		 * 
		 * stud1.setId(666); stud1.setName("john"); stud1.setCity("hyderabad"); int
		 * res=studentDao.insert(stud1); System.out.println("Student added"+res);
		 * 
		 * Student stud2= new Student(); stud2.setId(777); stud2.setName("yakub");
		 * stud2.setCity("delhi");
		 * 
		 * res=studentDao.insert(stud2); System.out.println("Student added"+res);
		 */
         
         
			/*
			 * trying to update the student one! stud1.setId(666);
			 * stud1.setName("john baptist"); stud1.setCity("Israel");
			 * 
			 * int res=studentDao.change(stud1); System.out.println("update done"+res);
			 * 
			 */
        
        
			/*
			 * trying to delete the student from DB. int r=studentDao.delete(666);
			 * System.out.println("deleted record"+r); 
			 */
        
        
			/*
			 * Getting the single Student Object from DB. Student
			 * s=studentDao.getStudent(777); System.out.println(s);
			 */
    
		
        
        Student stud1=new Student();
		
		  stud1.setId(666); stud1.setName("john"); stud1.setCity("hyderabad"); 
		  int res=studentDao.insert(stud1); System.out.println("Student added"+res);
		 List<Student>students=studentDao.getAllStudents(); 
		 for(Student s:students)
		  System.out.println(s);
		 
        
        
        
       /* ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
         StudentDao studentDao=context.getBean("studentDao",StudentDao.class);  
         Student stud=new Student();*/
			/*
			 * stud.setId(666); stud.setName("john"); stud.setCity("hyderabad"); int
			 * res=studentDao.insert(stud); System.out.println("Student added"+res);
			 */
			/*
			 * stud.setId(666); stud.setName("john baptist"); stud.setCity("Israel");
			 * 
			 * int res=studentDao.change(stud); System.out.println("update done"+res);
			 */
			/*
			 * int r=studentDao.delete(200); System.out.println("deleted record"+r);
			 */
        /* Student s=studentDao.getStudent(666);
        System.out.println(s);
    */
		/*
		 * List<Student>students=studentDao.getAllStudents(); for(Student s:students)
		 * System.out.println(s);
		 */
         
    }     
}
