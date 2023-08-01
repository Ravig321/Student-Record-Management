package factoryDesign;

import controller.StudentController;
import controller.StudentControllerImp;

public class StudentControllerDesign {

	private static StudentController studentController =null;

	private StudentControllerDesign() {

	}
	
	public static StudentController getStudentController() {
		if(studentController==null) {
			studentController = new StudentControllerImp();
		}
		return studentController;
	}
	

}
