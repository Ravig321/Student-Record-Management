package controller;

import dto.Student;
import factoryDesign.StudentServicesDesign;
import services.StudentService;

public class StudentControllerImpl implements StudentController {
	StudentService studentService = StudentServicesDesign.getStudentServices();

	@Override
	public String save(Student student) {
		return studentService.save(student);
	}

	@Override
	public Student findById(Integer sid) {
		return studentService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		return studentService.deleteById(sid);
	}

	

}
