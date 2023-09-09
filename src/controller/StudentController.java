package controller;

import dto.Student;

public interface StudentController {


String save(Student student);
	
	Student findById(Integer sid);
	
	String updateById(Student student);
	
	String deleteById(Integer sid);
	
	
}

