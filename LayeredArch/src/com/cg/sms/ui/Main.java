package com.cg.sms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.sms.dto.Student;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;

public class Main {

	
	public static void main(String args[]){
	
		StudentService service = new StudentServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do{
			System.out.println("1. Add Student");
			System.out.println("2. Display Student Details");
			System.out.println("3. Update Details");
			System.out.println("4. Display Student List");
			System.out.println("5 Exit");
			System.out.println("Enter Your Choice");
			ch = sc.nextInt();
		switch (ch){
		case 1 :
		
		
			System.out.println("Enter Name:");
			String name = sc.next();
			
			
			System.out.println("Enter Course Name:");
			String cname = sc.next();
			
			System.out.println("Enter Age:");
			int age = sc.nextInt();
			
			System.out.println("Enter Mobile No:");
			String mobile = sc.next();
			Student student = new Student();
			student.setName(name);
			student.setCoursename(cname);
			student.setAge(age);
			student.setMobileno(mobile);
			int rn = service.addStudent(student);
			System.out.println("Student record added" + rn);
		break;
		
		case 2 :
			System.out.println("Enter Roll No:");
			rn = sc.nextInt();
			
			student = service.getStudent(rn);
			if(student==null){
				System.out.println("record not found");
			}else{
				
				System.out.println(student.getName());
				System.out.println(student.getAge());
				System.out.println(student.getCoursename());
				System.out.println(student.getMobileno());
			}
		break;
		
		case 3 :
			System.out.println("Enter Roll no:");
			rn = sc.nextInt();
			
			student = service.getStudent(rn);
			if(student == null){
				System.out.println("Record not found");
			}else{
				System.out.println("Enter New Mobile number :");
				String mobileno =sc.next();
				student.setMobileno(mobileno);
				student= service.updateStudent(student);
				System.out.println("Record updated:");
				
				System.out.println(student.getName());
				System.out.println(student.getMobileno());
			}
		break;
		
		case 4 :
			System.out.println("Enter Course Name");
			String s = sc.next();
			ArrayList<Student> arr = new ArrayList<Student>();
			arr = service.getStudentList(s);
			for(Student stu:arr)
			{
				System.out.println("Name:"+stu.getName());
				System.out.println("age:"+stu.getAge());
				System.out.println("course:"+stu.getCoursename());
				System.out.println("mobile:"+stu.getMobileno());
			
			}
	}
		}while(ch!=5);
	}
}
