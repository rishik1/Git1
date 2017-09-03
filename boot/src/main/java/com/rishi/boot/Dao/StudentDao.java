package com.rishi.boot.Dao;

import java.util.Collection;

import com.rishi.boot.Entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	void removeStidentById(int id);

	void updateStudent(Student student);

}