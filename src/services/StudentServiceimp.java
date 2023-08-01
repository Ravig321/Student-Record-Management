package services;

import dao.StudentDao;
import dto.Student;
import factoryDesign.StudentDaoDesign;

public class StudentServiceimp implements StudentService{

	 StudentDao studentDao = StudentDaoDesign.getStudentDao();

	@Override
	public String save(Student student) {
		return 	studentDao.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
	
		return studentDao.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		return 	studentDao.updateById(student);

	}

	@Override
	public String deleteById(Integer sid) {
		return studentDao.deleteById(sid);

	}

}
