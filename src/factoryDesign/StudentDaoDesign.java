package factoryDesign;

import dao.StudentDao;
import dao.StudentDaoimpl;

public class StudentDaoDesign {

	private StudentDaoDesign() {
		
	}
		
	static StudentDao studentDao = null;
	
	public static StudentDao getStudentDao() {
		if(studentDao==null) {
		studentDao = new StudentDaoimpl();
		}
		return studentDao;
	}

}
