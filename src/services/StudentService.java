package services;

import dto.Student;

public interface StudentService {

	
	String save(Student student);
	
	Student findById(Integer sid);
	
	String updateById(Student student);
	
	String deleteById(Integer sid);
	
	
}
