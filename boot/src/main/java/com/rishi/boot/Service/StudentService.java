package com.rishi.boot.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rishi.boot.Dao.StudentDao;
import com.rishi.boot.Entity.Student;

@Service
public class StudentService {
	
	@Autowired
	@Qualifier("FakeData")
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}
	
	public Student getStudentById(int id){
		return studentDao.getStudentById(id);
	}
	
	public void removeStudentById(int id){
		studentDao.removeStidentById(id);
	}

	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}
}
