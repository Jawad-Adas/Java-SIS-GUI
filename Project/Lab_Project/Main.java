package Lab_Project;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Students> students = new ArrayList<Students>();
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
		ArrayList<Administrator> admin = new ArrayList<Administrator>();
		ArrayList<Courses> courses = new ArrayList<Courses>();
		
		
		
		
		//(String name, int id, String major, String username, String password, Grade grade)
		students.add(new Students("Jawad", 88888, "CS", "Jawad", "1234", new Grade()));
		students.add(new Students("Ali", 88726, "CVE", "Ali", "1111", new Grade()));
		students.add(new Students("Rayan", 89059, "COE", "Rayan", "0000", new Grade()));
		students.add(new Students("Tameem", 88948, "CS", "Tameem", "0000", new Grade()));
		students.add(new Students("Amjad", 89059, "CS", "Amjad", "0000", new Grade()));

		//	public Instructor(String name, int id, String username, String password, String dept)
		instructors.add(new Instructor("Hicham", 80988, "Hicham", "0000", "CMP"));
		instructors.add(new Instructor("Michel", 12345, "Michel", "0000", "CMP"));
		instructors.add(new Instructor("Sofian", 99898, "Sofian", "1234", "CHM"));
		
		//Administrator(String Username,String Password)
		admin.add(new Administrator("Admin", "Admin"));

		
		
		
		
		LoginView Login = new LoginView(students, instructors, admin,courses);
		
		
		
	}
	
	public static Students GetInfo() {
		Students student=new Students();
		student.setName("jawad");
		student.setId(87996);
		student.setPassword("jawad123");
		student.setUsername("JawadAdas");
		
		return student;
	}
	
	
	
}
