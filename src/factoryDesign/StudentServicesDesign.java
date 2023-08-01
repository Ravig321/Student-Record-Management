package factoryDesign;

import services.StudentService;
import services.StudentServiceimp;

public class StudentServicesDesign {

	
	private StudentServicesDesign() {
		
	}

	static StudentService studentServices = null;
	
	public static StudentService getStudentServices() {
		if(studentServices==null) {
			studentServices = new StudentServiceimp();
		}
		return studentServices;
	}
	
	
}
