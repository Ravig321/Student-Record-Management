package dao;

import dto.Student;

public interface StudentDao {

	
String save(Student student);
	
	Student findById(Integer sid);
	
	String updateById(Student student);
	
	String deleteById(Integer sid);
	
	
}

