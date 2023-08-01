package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.StudentController;
import dto.Student;
import factoryDesign.StudentControllerDesign;

public class TestApp {
	 static StudentController studentController;
	public static void main(String[] args) throws NumberFormatException, IOException {
	 studentController = StudentControllerDesign.getStudentController();
	 
	 String name = null , city = null , status = null , email = null , country = null ;
//	 object of Student class
	 Student st = new Student();
	 int id;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while(true) {
		System.out.println("1. ADD");
		System.out.println("2. READ");
		System.out.println("3. UPDATE");
		System.out.println("4. DELETE");
		System.out.println("5. EXIT");
		System.out.println("Enter a choice [1,2,3,4,5]");
		
		Integer option = Integer.parseInt(br.readLine());	
		
		switch(option) {
		
		case 1:		
					System.out.println("Enter name : ");
					name = br.readLine();
					System.out.println("Enter city : ");
					city = br.readLine();
					System.out.println("Enter email : ");
					email = br.readLine();
					System.out.println("Enter country : ");
					country = br.readLine();
					
						
						st.setCity(city);
						st.setName(name);
						st.setEmail(email);
						st.setCountry(country);
						status = studentController.save(st);
						if(status.equalsIgnoreCase("Success")) {
							System.out.println("Data inserted successfully...");
						}
						else if(status.equalsIgnoreCase("failure")) {
							System.out.println("Failed to insert data...");

						}
						else {
							System.out.println("Some problem occurs...");

						}
					break;
					
					
				case 2:		System.out.println("Enter Student id");
							 id = Integer.parseInt(br.readLine());
							st = studentController.findById(id);
							if(st!=null) {
								System.out.println(st);
							
							}else {
								System.out.println("No Record Found for the given id");

							}
							break;
							
							
				case 3: System.out.println("Enter Student id");
						id = Integer.parseInt(br.readLine());
						st = studentController.findById(id);
						Student std = new Student();
						if(st!=null) {
							System.out.println("Old Name  = [ "+st.getName()+" ]");
							name = br.readLine();
							if(name==null || name.equalsIgnoreCase("")) {
								std.setName(st.getName());
							}else {
								std.setName(name);
							}
							System.out.println("Old Email  = [ "+st.getEmail()+" ]");
							email = br.readLine();
							if(email==null || email.equalsIgnoreCase("")) {
								std.setEmail(st.getEmail());
							}else {
								std.setEmail(email);
							}
							System.out.println("Old City  = [ "+st.getCity()+" ]");
							city = br.readLine();
							if(city==null || city.equalsIgnoreCase("")) {
								std.setCity(st.getCity());
							}else {
								std.setCity(city);
							}
							System.out.println("Old Country  = [ "+st.getCountry()+" ]");
							country = br.readLine();
							if(country==null || country.equalsIgnoreCase("")) {
								std.setCountry(st.getCountry());
							}else {
								std.setCountry(country);
							}
						}else {
							System.out.println("Invalid Student ID");
						}
						std.setSid(id);
						status = studentController.updateById(std);
						if(status.equalsIgnoreCase("Success")) {
							System.out.println("Data Updated successfully...");
						}
						else {
							System.out.println("Fails to update data...");

						}
					
					break;
			
			
			
		case 4:		System.out.println("Enter Student id");
					 id = Integer.parseInt(br.readLine());
					status = studentController.deleteById(id);
					if(status.equalsIgnoreCase("Success")) {
						System.out.println("Data Deleted successfully...");
					}
					else {
						System.out.println("Record do not exists...");

					}
					
					
					break;
			
		case 5 : System.out.println("Thank you for using our program...");
					System.exit(0);
			break;
			default:  System.out.println("Please Select a valid number...");
			break;

		
		}
		
		
		

	}
	
	
	
	
	
	}
	
	
		

}
