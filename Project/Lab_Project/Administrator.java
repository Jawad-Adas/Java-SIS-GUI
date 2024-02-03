package Lab_Project;

public class Administrator {
	
	String Name;	
	String Username;
	String Password;
	
	
	Administrator(){
		this.Username = "Amjad";
		this.Password = "2003";
		
	}
	
	Administrator(String Username,String Password){
		this.Username=Username;
		this.Password=Password;
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
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
