package com.cg.sms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.cg.sms.dto.Student;

public class StudentDAOImpl implements StudentDAO {
	Map<Integer, Student> studentMap;
	public StudentDAOImpl(){
		studentMap = DataStore.createCollection();
	}
	@Override
	public int addStudent(Student student) {
		
		int rollno = (int)(1000 * Math.random());
		student.setRollno(rollno);
		studentMap.put(rollno, student);
		
		
		return rollno;
	}
	@Override
	public Student getStudent(int rn) {
		// TODO Auto-generated method stub
		Student stud = studentMap.get(rn);
		
		
		return stud;
	}
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentMap.put(student.getRollno(), student);
		return student;
	}
	@Override
	public ArrayList<Student> getStudentList(String coursename) {
		// TODO Auto-generated method stub
		//Collection<Student> studlist
		ArrayList<Student> a = new ArrayList<Student>();
		
		for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
			Student s=new Student();
			s=entry.getValue();
		    if((s.getCoursename()).equals(coursename))
		    {
		
		    	a.add(s);
		    }
		    
	}
		
		return a;
	}
	
	

}
