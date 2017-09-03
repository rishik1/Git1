package com.rishi.boot.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.Collection;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.boot.Entity.Student;
import com.rishi.boot.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Student getStudenById(@PathVariable("id") int id){
		return studentService.getStudentById(id);
	}
	
	@RequestMapping(value ="/{id}" , method=RequestMethod.DELETE)
	public void removeStudentById(@PathVariable("id") int id){
		studentService.removeStudentById(id);
	}
	
	@RequestMapping(value="/student/",method=RequestMethod.PUT,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student){
		studentService.updateStudent(student);
	}
	

}
