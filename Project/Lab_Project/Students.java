package Lab_Project;

import java.util.ArrayList;

//model
public class Students {
	
		String name;
		int id;
		String major;
		String Username;
		String Password;
		ArrayList<Grade> grades = new ArrayList<Grade>();	
		Grade grade;
		ArrayList<Courses> courses = new ArrayList<Courses>();

		
		public Students(String name, int id, String major, String username, String password, Grade grade) {
			this.name = name;
			this.id = id;
			this.major = major;
			Username = username;
			Password = password;
			this.grade = grade;
		}

		public Students() {
			this.Username = "Hicham";
			this.name = "Hicham";
			this.id = 8998;
			this.major = "CS";
			this.Password = "0000"; 	
			ArrayList<Courses> courses_ = new ArrayList<Courses>();
			for (int i = 0; i < 3; i++) {
			}
			this.grades = new ArrayList<Grade>();
			this.courses = courses_;
			
		}
		
		public String getUsername() {
			return Username;
		}
		public void setUsername(String username) {
			Username = username;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		public int getId() {
			return id;
		}

		public Grade getGrade() {
			return grade;
		}
		public void setGrade(Grade grade) {
			this.grade = grade;
		}
		
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		
		public void setCourses(ArrayList<Courses> courses) {
			this.courses = courses;
		}
		public ArrayList<Courses> getCourses() {
			return courses;
		}
			
		protected String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		
		public boolean CheckUserPass(String User, String Pass) {
			if(this.Username==User && this.Password==Pass) return true;
			else return false;		
		}
		public ArrayList<Grade> getGrades() {
			return grades;
		}
		public void setGrades(ArrayList<Grade> grades) {
			this.grades = grades;
		}
		

	

	
}

