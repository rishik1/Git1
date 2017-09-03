package com.rishi.boot.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rishi.boot.Entity.Student;

@Repository
@Qualifier("FakeData")
public class FakeStudentDao implements StudentDao {
	
	private static Map<Integer,Student> students;
	
	static{
		students = new HashMap<Integer, Student>(){
			{
				put(1, new Student(1,"rishi", "Computer Science"));
				put(2, new Student(2, "sagar", "Electronics"));
				put(3, new Student (3, "muffi", "IT"));
			} 
		};
	}
	
	
	public Collection<Student> getAllStudents(){
		return students.values();
	}
	
	public Student getStudentById(int id){
		return students.get(id);
	}
	
	public void removeStidentById(int id){
		students.remove(id);
	}

	public void updateStudent(Student student) {
		Student new_student = students.get(student.getId());
		students.put(student.getId(), student);
	}
}
