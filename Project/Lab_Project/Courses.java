package Lab_Project;



import java.util.ArrayList;

public class Courses implements Cloneable{
	String name;
	int Credits;
	String courseCode;
	String department;
	Instructor instructor;
	ArrayList<Students> students;
	ArrayList<Grade> grades;
	Grade grade;
	

public Courses() {
	this.name = "hoop";
	this.Credits = 69;
	this.courseCode = Credits+name;
	this.department = "snoop";
	this.instructor = null;
	
	ArrayList<Students> students_ = new ArrayList<Students>();
	
	this.students = students_;
}

public Courses(Courses course) {
	this.name = course.getName();
	this.Credits = course.getCredits();
	this.courseCode = course.getCourseCode();
	this.department = course.getDepartment();
	
	this.instructor = course.getInstructor();
}

	public Courses(String name, int number, String department, Instructor instructor) {
		this.name = name;
		this.Credits = number;
		this.courseCode = number+name;
		this.department = department;
		this.instructor = instructor;
	}

	protected ArrayList<Grade> getGrades() {
		return grades;
	}

	protected void setGrades(ArrayList<Grade> student_grades) {
		this.grades = student_grades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return Credits;
	}

	public void setCredits(int number) {
		this.Credits = number;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public ArrayList<Students> getStudents() {
		return students;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	

	public void setStudents(ArrayList<Students> students) {
		this.students = students;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		
		
		return (Courses)super.clone();
	}
	
	


	
	

	
}

