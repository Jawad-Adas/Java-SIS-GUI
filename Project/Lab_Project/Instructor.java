package Lab_Project;

import java.util.ArrayList;

public class Instructor {

	String name;
	int id;
	String Username;
	String Password;
	String Dept;
	ArrayList<Courses> courses = new ArrayList<Courses>();
	
	public Instructor() {
		this.name = "amyo";
		this.id = 0000;
		Username = "amyo";
		Password = "0000";
		Dept = "CMP";
		for (int i = 0; i < 1; i++)
		this.courses.add(new Courses());
	}
	
	
	public Instructor(String name, int id, String username, String password, String dept) {
		this.name = name;
		this.id = id;
		Username = username;
		Password = password;
		Dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public ArrayList<Courses> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [name=" + name + ", id=" + id + ", Username=" + Username + ", Password=" + Password
				+ ", Dept=" + Dept + ", courses=" + courses + "]";
	}
	
	
	
}
