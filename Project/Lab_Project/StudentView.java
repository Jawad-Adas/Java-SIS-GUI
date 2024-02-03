package Lab_Project;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentView extends JFrame {

	JFrame studentsFrame = new JFrame();
	
	
	JPanel passpanel = new JPanel(new GridLayout(3,2));
    JPanel namepanel = new JPanel(new GridLayout(1,2));
	
	JLabel oldpasslabel = new JLabel("Enter Old Password:");
	JLabel newpass1label = new JLabel("Enter New Password:");
	JLabel newpass2label = new JLabel("Renter New Password:");

	JPasswordField oldpassField = new JPasswordField();
	JPasswordField newpass1Field = new JPasswordField();
	JPasswordField newpass2Field = new JPasswordField();

	JButton confirmpassbutton = new JButton("Change password");
	
	JLabel newnamelabel = new JLabel("Enter New Name:");
	JTextField newnameField = new JTextField();
	
	Students student;
	//Used in add course event handler
	Courses course;

	
	ArrayList<Students> students;
	ArrayList<Courses> courses;
	ArrayList<Instructor> instructors;
	ArrayList<Administrator> admin;
	
	public StudentView() {}//default constructor
	
	public StudentView(Students student1, ArrayList<Students> student_, ArrayList<Courses> courses_, ArrayList<Instructor> instructors_, ArrayList<Administrator> admin_) {
		student=student1;// assigning student to student1 which is passed by constructor
		
		//to call LoginView constuctor for Logout Button
		this.students = student_;
		this.courses = courses_;
		this.instructors = instructors_;
		this.admin=admin_;
		//Setting up the frame
		studentsFrame.getContentPane().setBackground(new Color(105, 102, 103));
		studentsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentsFrame.setSize(420,420);
		studentsFrame.setBounds(700, 250, 420, 420);
		studentsFrame.getContentPane().setLayout(null);
		studentsFrame.setVisible(true);
		
		//Creating a Label and setting its colors, font and bounds
		JLabel welcome = new JLabel("Students Page");
		welcome.setForeground(new Color(237, 222, 222));
		welcome.setFont(new Font("Bookman Old Style", Font.PLAIN, 19));
		welcome.setBounds(140, 11, 140, 35);
		
		//Creating MenuBar, Menus, and MenuItems. And naming them
		JMenuBar Menubar = new JMenuBar();
		JMenu Records = new JMenu("Student Records");
		JMenu Courses = new JMenu("Manage Courses");
		JMenu Personal = new JMenu("Personal Information");
		final JMenuItem AddCourse = new JMenuItem("Add Courses");
		JMenuItem DisplayRecords = new JMenuItem("Display Records");
		final JMenuItem SaveRecords = new JMenuItem("Save Records");
		JMenuItem ChangeUser = new JMenuItem("Change Username");
		JMenuItem ChangePass = new JMenuItem("Change Password");
		JMenuItem Logout = new JMenuItem("Logout");
		
		
		
		//Changin Colors, fonts, and font colors of all menus, menu items, and the menu bar
		
		Menubar.setBackground(new Color(105, 102, 103));
		
		Courses.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Courses.setForeground(new Color(237, 222, 222));		
		
		Records.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Records.setForeground(new Color(237, 222, 222));
		
		Personal.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Personal.setForeground(new Color(237, 222, 222));
		
		Logout.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Logout.setForeground(new Color(237, 222, 222));		
		
		
		AddCourse.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		AddCourse.setForeground(new Color(237, 222, 222));
		AddCourse.setBackground(new Color(172, 83, 83));
				
		DisplayRecords.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		DisplayRecords.setForeground(new Color(237, 222, 222));
		DisplayRecords.setBackground(new Color(172, 83, 83));
		
		SaveRecords.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		SaveRecords.setForeground(new Color(237, 222, 222));
		SaveRecords.setBackground(new Color(172, 83, 83));
					
		ChangeUser.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeUser.setForeground(new Color(237, 222, 222));
		ChangeUser.setBackground(new Color(172, 83, 83));
		
		ChangePass.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangePass.setForeground(new Color(237, 222, 222));
		ChangePass.setBackground(new Color(172, 83, 83));
		
		//Adding Menu bar, Menus and Menu Items
		Records.add(DisplayRecords);
		Records.add(SaveRecords);
		Courses.add(AddCourse);
		Personal.add(ChangeUser);
		Personal.add(ChangePass);		
		Menubar.add(Personal);
		Menubar.add(Records);
		Menubar.add(Courses);
		Menubar.add(Logout);
		
		
		studentsFrame.setJMenuBar(Menubar);
		studentsFrame.getContentPane().add(welcome);
		
		
		  Logout.addActionListener(new ActionListener() {
	  			public void actionPerformed(ActionEvent e) {
	  				studentsFrame.dispose();
	  				
	  				new LoginView(students, instructors, admin,courses);
	  				
	  			}
	  			});
		
		//EventHandeling for Add Courses Menu Item
		AddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel panel = new JPanel(new GridLayout(courses.size()+1,1));
           		panel.add(new JLabel("Choose a Course to Register"));
           		//Adding menu items to the popup
           		if(!(courses==null)) {
           			for (int i = 0; i < courses.size();i++) {
           		   JButton courseButton = new JButton(courses.get(i).getName() + " " + courses.get(i).getCourseCode());
           		   
           		   final Courses course = courses.get(i);
           		   
           		//Display course data on menu item click
           		courseButton.addActionListener(new ActionListener() {
                   	public void actionPerformed(ActionEvent ev) {
                   		boolean registered = false;
                   		
                   		//Check if student is already registered
                   		for (int k = 0; k < student.getCourses().size(); k++)
                   			if (student.getCourses().get(k) == course) {
                       			JOptionPane.showMessageDialog(null, "Course Already Registered!","Error",JOptionPane.INFORMATION_MESSAGE);
                       			 registered = true;
                   			}
                   		
                   		if (student.getCourses().size() < 5 && registered == false && course.getStudents().size()<20) {
							student.getCourses().add(course);
						
	                   		student.getGrades().add(new Grade());
	                   		course.getStudents().add(student);
                   		}
                   		else if(student.getCourses().size() >=5)
                   		{
                   			JOptionPane.showMessageDialog(null, "Cannot Register in more than 5 Courses!","Error",JOptionPane.INFORMATION_MESSAGE);

                   		}
                   		else if(course.getStudents().size()>=20) {
                   			JOptionPane.showMessageDialog(null, "Course Full","Error",JOptionPane.INFORMATION_MESSAGE);

                   		}
           		   
           		}
        	});
           		   
           		   panel.add(courseButton);
           			}
           		}
           		JOptionPane.showOptionDialog(null, panel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
           				{}, null); 
				
			}
		});
				
		
		//EventHandler for Display Records menu item
		DisplayRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayData view = new DisplayData(student);//if Display Record is chosen from menu DisplayData Constructor is called
			}
		});
		
		
		//EventHandler for Save Records menu item that saves student information into a text file
		SaveRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser DataFile = new JFileChooser(".");
                int choice = DataFile.showSaveDialog(SaveRecords);//Selects file
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = DataFile.getSelectedFile();
                      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                          
                          try{
                        	  FileWriter writer = new FileWriter(selectedFile);//Creates FileWriter to display records
                        	  writer.write("Name: "+student.getName()+"\n");//adds name to the text file
                        	  writer.write("ID: "+student.getId()+"\n");//add ID to the text file
                        	  writer.write("Major: "+student.getMajor()+"\n");//add Major to text file
                        	  writer.write("Courses: "+"\n");
                        	  for(int i=0;i<student.getCourses().size();i++) {//this for loop adds all courses registered by student one by one
                        		  writer.write("Course "+(i+1)+":\tName: "+student.getCourses().get(i).getName()+"\tCourse Code:"+student.getCourses().get(i).getCourseCode()+"\tCredits:"+student.getCourses().get(i).getCredits()+"\tGrade:"+student.getCourses().get(i).getGrade().getGrade()+"\n");			
                        	  }
                             
                        	  writer.close();                          
                          } catch (IOException e1) {                             
                              e1.printStackTrace();
                          }
                }
			}
		});
		
		
		//EventHandler for Change Username Menu that will let students change their usernames
		ChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				namepanel.add(newnamelabel);
			   	namepanel.add(newnameField);
			   	
			   	int a = JOptionPane.showOptionDialog(null, namepanel, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);  

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(newnameField.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter new Username");
			   		else {
			   		student.setUsername(newnameField.getText());
					JOptionPane.showMessageDialog(null, "Username Changed Successfully");
			   		}
			   		
			   	}
			}
		});
		
		
		
		
		//EventHandler for Change Password menu item that will let students change their passwords
		ChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setting up the pop up panel when Change password is clicked
				passpanel.add(oldpasslabel);
				passpanel.add(oldpassField);
				passpanel.add(newpass1label);
				passpanel.add(newpass1Field);
				passpanel.add(newpass2label);
				passpanel.add(newpass2Field);
				
				//Pop up pane without any icon or option dialogue, just the contents of passpanel
				int a = JOptionPane.showOptionDialog(null, passpanel, "Change Password", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
				{"Confirm", "Cancel"}, null);  
				
				
				if (a == JOptionPane.OK_OPTION) {
					//Compare current password with entered old password and compare new passwords for double entry data verification
					if (String.valueOf(oldpassField.getPassword()).equals(student.getPassword())
	        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword())))
	        		{
	        			student.setPassword(String.valueOf(newpass1Field.getPassword()));
	        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
	        			System.out.println(student.getPassword());

	        		}
	        		else {
	        			JOptionPane.showMessageDialog(null, "Incorrect Old password / New Passwords");
	        		}
					
				}
			}
		});
		
		
		//Creating Buttons
		final JButton AddCoursesButton = new JButton("Add Courses");
		JButton DisplayData = new JButton("Display Data");
		final JButton SaveData = new JButton("Save Student Data");//Save student data
		JButton ChangeUsername = new JButton("Change Username");
		JButton ChangePassword = new JButton("Change Password");
		
		//Setting the colors and fonts for buttons
		AddCoursesButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		AddCoursesButton.setForeground(new Color(237, 222, 222));
		AddCoursesButton.setBackground(new Color(172, 83, 83));
		
		
		
		DisplayData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		DisplayData.setForeground(new Color(237, 222, 222));
		DisplayData.setBackground(new Color(172, 83, 83));
		
		SaveData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		SaveData.setForeground(new Color(237, 222, 222));
		SaveData.setBackground(new Color(172, 83, 83));
		
		ChangeUsername.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeUsername.setForeground(new Color(237, 222, 222));
		ChangeUsername.setBackground(new Color(172, 83, 83));
		
		ChangePassword.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangePassword.setForeground(new Color(237, 222, 222));
		ChangePassword.setBackground(new Color(172, 83, 83));
				
		//Adding Buttons into frame and setting their bounds
		AddCoursesButton.setBounds(10, 115, 156, 33);
		DisplayData.setBounds(10, 165, 156, 33);
		SaveData.setBounds(10, 215, 156, 33);
		ChangeUsername.setBounds(200, 115, 156, 33);
		ChangePassword.setBounds(200, 165, 156, 33);
		
		studentsFrame.getContentPane().add(ChangePassword);
		studentsFrame.getContentPane().add(AddCoursesButton);
		studentsFrame.getContentPane().add(DisplayData);
		studentsFrame.getContentPane().add(SaveData);				
		studentsFrame.getContentPane().add(ChangeUsername);
				
		AddCoursesButton.setFocusable(false);
		DisplayData.setFocusable(false);
		SaveData.setFocusable(false);
		ChangeUsername.setFocusable(false);
		ChangePassword.setFocusable(false);
								
		
		//Creating Label and setting its color, font, and bounds
		JLabel lblSelfserviceSystem = new JLabel("Self-Service System:");
		JLabel lblPersonalInformation = new JLabel("Personal Information:");
				
		lblSelfserviceSystem.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblPersonalInformation.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		
		lblSelfserviceSystem.setForeground(new Color(237, 222, 222));
		lblPersonalInformation.setForeground(new Color(237, 222, 222));
		
		lblPersonalInformation.setBounds(200, 75, 194, 29);
		lblSelfserviceSystem.setBounds(10, 75, 166, 29);
		
		studentsFrame.getContentPane().add(lblPersonalInformation);
		studentsFrame.getContentPane().add(lblSelfserviceSystem);
		
//		//EventHandler when add course button is clicked
//		AddCoursesButton.addActionListener(new ActionListener() {//let uses add courses through a  text file that is formatted CourseCode;CourseName;CourseCredits;
//			public void actionPerformed(ActionEvent e) {
//				if((student.getCourses().size())==5) {// If student try to register more than 5 courses it shows a pop up message
//					JOptionPane.showMessageDialog(null, "Cannot Register in more than 5 Courses!","Error",JOptionPane.INFORMATION_MESSAGE);
//				}
//				else{//if student has less than 5 courses then he can register
//					JFileChooser LoadCourses = new JFileChooser();
//					LoadCourses.setApproveButtonText("Select File");
//					LoadCourses.setAcceptAllFileFilterUsed(false);
//					int choice = LoadCourses.showOpenDialog(AddCoursesButton);
//					if (choice == JFileChooser.APPROVE_OPTION) { 
//						File selectedFile = LoadCourses.getSelectedFile();
//							System.out.println("Selected file: " + selectedFile.getAbsolutePath());
//                            //FileReader reader = null;
//                            	try{                          
//                            		Scanner in = new Scanner(selectedFile);
//                            		in.useDelimiter(";");
//                            		                            	
//                            		// loop that takes Courses information from text file
//                            		while(in.hasNext() && student.getCourses().size()<5) {//keeps adding courses until end of file or student courses exceeds 5
//                            			Courses temp=new Courses();//temp Courses object to store file info in
//                            			temp.setCourseCode(in.next());//sets coursecode first
//                            			temp.setName(in.next());//sets course name second
//                            			temp.setCredits(Integer.parseInt(in.next()));// sets course credits last
//                            			temp.setGrade(new Grade(0));//sets grade to 0, only instructor is allowed to change grade
//                            			student.courses.add(temp);//adds temp object into the students courses ArrayList                   	                             			
//                            		}                            			                           		                             
//                            	} catch (IOException e1) {
//                            		e1.printStackTrace();
//                            	}				
//					}								
//				}
//			}});
//		
				
		AddCoursesButton.addActionListener(new ActionListener() {//let uses add courses through a  text file that is formatted CourseCode;CourseName;CourseCredits;
			public void actionPerformed(ActionEvent e) {
				
           		JPanel panel = new JPanel(new GridLayout(courses.size()+1,1));
           		panel.add(new JLabel("Choose a Course to Register"));
           		//Adding menu items to the popup
           		if(!(courses==null)) {
           			for (int i = 0; i < courses.size();i++) {
           		   JButton courseButton = new JButton(courses.get(i).getName() + " " + courses.get(i).getCourseCode());
           		   
           		   final Courses course = courses.get(i);
           		   
           		//Display course data on menu item click
           		courseButton.addActionListener(new ActionListener() {
                   	public void actionPerformed(ActionEvent ev) {
                   		boolean registered = false;
                   		
                   		//Check if student is already registered
                   		for (int k = 0; k < student.getCourses().size(); k++)
                   			if (student.getCourses().get(k) == course) {
                       			JOptionPane.showMessageDialog(null, "Course Already Registered!","Error",JOptionPane.INFORMATION_MESSAGE);
                       			 registered = true;
                   			}
                   		
                   		if (student.getCourses().size() < 5 && registered == false) {
							student.getCourses().add(course);
						
	                   		student.getGrades().add(new Grade());
	                   		course.getStudents().add(student);
                   		}
                   		else if(student.getCourses().size() >=5)
                   		{
                   			JOptionPane.showMessageDialog(null, "Cannot Register in more than 5 Courses!","Error",JOptionPane.INFORMATION_MESSAGE);

                   		}
           		   
           		}
        	});
           		   
           		   panel.add(courseButton);
           			}
           		}
           		JOptionPane.showOptionDialog(null, panel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
           				{}, null); 
			}
			});
		
		
		
		
		//Event HAndler for The button Display Record
		DisplayData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayData view = new DisplayData(student);//if Display Record button is clicked DisplayData Constructor is called
				
			}
		});		
		
		//EventHandler for Save Records button
		SaveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser DataFile = new JFileChooser(".");
                int choice = DataFile.showSaveDialog(SaveData);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = DataFile.getSelectedFile();
                      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                          
                          try{
                        	  FileWriter writer = new FileWriter(selectedFile);
                        	  writer.write("Name: "+student.getName()+"\n");
                        	  writer.write("ID: "+student.getId()+"\n");
                        	  writer.write("Major: "+student.getMajor()+"\n");
                        	  writer.write("Courses: "+"\n");
                        	  
                        	  for(int i=0;i<student.getCourses().size();i++) {
                        		  
                        		  	writer.write("Course "+(i+1)+":\tName: "+student.getCourses().get(i).getName()+"\tCourse Code:"+student.getCourses().get(i).getCourseCode()+"\tCredits:"+student.getCourses().get(i).getCredits()+"\tGrade:"+student.getGrades().get(i).getGrade());			
                        	  
                        	  }
                             
                        	  writer.close();                          
                          } catch (IOException e1) {                             
                              e1.printStackTrace();
                          }
                }
			}
		});
		
		
		
		//Event Handler for Change Username button
		ChangeUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setting up pop up panel for changing username
				namepanel.add(newnamelabel);
			   	namepanel.add(newnameField);
			   	
			   	int a = JOptionPane.showOptionDialog(null, namepanel, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);  

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(newnameField.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter new Username");
			   		else {
			   		student.setUsername(newnameField.getText());
					JOptionPane.showMessageDialog(null, "Username Changed Successfully");
			   		}
			   		
			   	}
			}
		});
		
		
		//EventHandler for Changing Password button
		ChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setting up a pop up panel to change password
				passpanel.add(oldpasslabel);
				passpanel.add(oldpassField);
				passpanel.add(newpass1label);
				passpanel.add(newpass1Field);
				passpanel.add(newpass2label);
				passpanel.add(newpass2Field);
				
				//Pop up pane without any icon or option dialogue, just the contents of passpanel
				int a = JOptionPane.showOptionDialog(null, passpanel, "Change Password", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
				{"Confirm", "Cancel"}, null);  
				
				
				if (a == JOptionPane.OK_OPTION) {
					//Compare current password with entered old password and compare new passwords for double entry data verification
					if (String.valueOf(oldpassField.getPassword()).equals(student.getPassword())
	        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword())))
	        		{
	        			student.setPassword(String.valueOf(newpass1Field.getPassword()));
	        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
	        			System.out.println(student.getPassword());

	        		}
	        		else {
	        			JOptionPane.showMessageDialog(null, "Incorrect Old Password / New Passwords Not Matching");
	        		}
					
				}
			}
		});
		
	}
}

