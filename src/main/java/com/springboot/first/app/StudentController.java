package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//localhost:
	@GetMapping(path="/student")
	public Student getStudent() {
		//spring uses jakson library and message converter
		// to convert java object to json object
		return new Student("Chary","Asuri");
	}
	
	@GetMapping("/listStudents")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("ramu","pandu"));
		students.add(new Student("ramu","pan"));
		students.add(new Student("ramu","pa"));
		students.add(new Student("ramu","p"));
		return students;
	}
	
	// http://localhost:8080/student/fistname of your choice/last name of your choice
	//@PathVariable is used to bind url template path variable to method variable
	@GetMapping("/student/{firstName}/{lastName}")//URL template path variable
	public Student studentPathVariable(@PathVariable("firstName") String firstName1,@PathVariable String lastName) {//without @pathVAriable the last name is printed as null therefore it is not reading the variable if the annotation is not used
		
		return new Student(firstName1,lastName);
	}
	
	//build a rest API to handle query parameters
	// http://localhost:8080/student(rest end point URL)?firstName = Ramesh(keyValue)&lastName=puri
	@GetMapping("/studentRequestParam")
	public Student studentQueryParam(@RequestParam(name = "firstName") String firstName,@RequestParam(name ="lastName")String lastName) {
		return new Student(firstName, lastName);
	}
	//notice above path variable is needed to be included in the get mapping annotaation where as req param was not concluding
	//that  the fundamental use case for both is different one is querying other is direcly is used as a variable 
	
}
