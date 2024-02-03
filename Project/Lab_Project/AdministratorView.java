package Lab_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class AdministratorView extends JFrame {

	
	
	private JPanel contentPane;
	JLabel Choose = new JLabel();
	JTextField IDChosen = new JTextField();
	JPanel ChooseID = new JPanel(new GridLayout(1,2));
	int ID;
	
	JPanel namepanel = new JPanel(new GridLayout(1,2));
	JLabel newnamelabel = new JLabel("Enter New Name:");
	JTextField newnameField = new JTextField();
	boolean notfound=true;
	
	JPanel passpanel = new JPanel(new GridLayout(3,2));
	JLabel oldpasslabel = new JLabel("Enter Old Password:");
	JLabel newpass1label = new JLabel("Enter New Password:");
	JLabel newpass2label = new JLabel("Renter New Password:");
	JPasswordField oldpassField = new JPasswordField();
	JPasswordField newpass1Field = new JPasswordField();
	JPasswordField newpass2Field = new JPasswordField();
	JButton confirmpassbutton = new JButton("Change password");
	
	
	ArrayList<Students> students;
	ArrayList<Instructor> instructors;
	ArrayList<Courses> courses;
	ArrayList<Administrator> admin;
	
	
	
	public AdministratorView(ArrayList<Students> students_, ArrayList<Instructor> instructors_, ArrayList<Courses> courses_, ArrayList<Administrator> admin_) {
		
		this.students = students_;
		this.instructors = instructors_;
		this.courses = courses_;
		this.admin = admin_;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 420, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 102, 103));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setBackground(new Color(105, 102, 103));
		getContentPane().setLayout(null);
		final Container container = getContentPane();
		JLabel welcome = new JLabel("Admin Page");
		welcome.setForeground(new Color(237, 222, 222));
		welcome.setFont(new Font("Bookman Old Style", Font.PLAIN, 19));
		welcome.setBounds(140, 11, 140, 35);				
		getContentPane().add(welcome);
		
		
		//Creating MenuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(105, 102, 103));
		setJMenuBar(menuBar);
		
		//Creating and setting up Students Menu and its items
		JMenu Students = new JMenu("Students");
		Students.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Students.setForeground(new Color(237, 222, 222));
		menuBar.add(Students);
		
		JMenuItem DisplayStudentData = new JMenuItem("Display Student Records");
		DisplayStudentData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		DisplayStudentData.setForeground(new Color(237, 222, 222));
		DisplayStudentData.setBackground(new Color(172, 83, 83));
		Students.add(DisplayStudentData);
		
		final JMenuItem SaveStudentData = new JMenuItem("Sava Student Records");
		SaveStudentData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		SaveStudentData.setForeground(new Color(237, 222, 222));
		SaveStudentData.setBackground(new Color(172, 83, 83));
		Students.add(SaveStudentData);
		
		JMenuItem ChangeStudentUser = new JMenuItem("Change a Student's Username");
		ChangeStudentUser.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		ChangeStudentUser.setForeground(new Color(237, 222, 222));
		ChangeStudentUser.setBackground(new Color(172, 83, 83));
		Students.add(ChangeStudentUser);
		
		JMenuItem ChangeStudentPass = new JMenuItem("Change a Student's Password");
		ChangeStudentPass.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		ChangeStudentPass.setForeground(new Color(237, 222, 222));
		ChangeStudentPass.setBackground(new Color(172, 83, 83));
		Students.add(ChangeStudentPass);
				
		
		//Creating and setting up Instructors Menu and its items
		JMenu Instructors = new JMenu("Instructors");
		Instructors.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Instructors.setForeground(new Color(237, 222, 222));
		menuBar.add(Instructors);
		
		JMenuItem DisplayInstructorData = new JMenuItem("Display Instructor Records");
		
		DisplayInstructorData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		DisplayInstructorData.setForeground(new Color(237, 222, 222));
		DisplayInstructorData.setBackground(new Color(172, 83, 83));
		Instructors.add(DisplayInstructorData);
		
		JMenuItem DisplayCourseData = new JMenuItem("Dsiplay Instructor's Course Records");
		
		DisplayCourseData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		DisplayCourseData.setForeground(new Color(237, 222, 222));
		DisplayCourseData.setBackground(new Color(172, 83, 83));
		Instructors.add(DisplayCourseData);
		
		final JMenuItem SaveCourseData = new JMenuItem("Save Instructor's Course Records");
		
		SaveCourseData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		SaveCourseData.setForeground(new Color(237, 222, 222));
		SaveCourseData.setBackground(new Color(172, 83, 83));
		Instructors.add(SaveCourseData);
		
		JMenuItem ChangeInstructorPass = new JMenuItem("Change an Instructor's Password");
		
		ChangeInstructorPass.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		ChangeInstructorPass.setForeground(new Color(237, 222, 222));
		ChangeInstructorPass.setBackground(new Color(172, 83, 83));
		Instructors.add(ChangeInstructorPass);
		
		JMenuItem ChangeInstructorUser = new JMenuItem("Change an Instructor's Username");
		
		ChangeInstructorUser.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		ChangeInstructorUser.setForeground(new Color(237, 222, 222));
		ChangeInstructorUser.setBackground(new Color(172, 83, 83));
		Instructors.add(ChangeInstructorUser);
		
		final JMenuItem ReadCourseDataFile = new JMenuItem("Read Course Data File");
		
		ReadCourseDataFile.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));		
		ReadCourseDataFile.setForeground(new Color(237, 222, 222));
		ReadCourseDataFile.setBackground(new Color(172, 83, 83));
		Instructors.add(ReadCourseDataFile);
		
		JMenuItem Logout = new JMenuItem("Logout");
		Logout.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Logout.setForeground(new Color(237, 222, 222));	
		menuBar.add(Logout);
		
		
		
		
		
		
		
		
		
		
		//Setting Labels above buttons
		JLabel ManageStudents = new JLabel("Manage Students:");
		JLabel ManaeInstructors= new JLabel("Manage Instructors:");

		ManageStudents.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		ManaeInstructors.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		
		ManageStudents.setForeground(new Color(237, 222, 222));
		ManaeInstructors.setForeground(new Color(237, 222, 222));
		
		ManaeInstructors.setBounds(200, 75, 194, 29);
		ManageStudents.setBounds(10, 75, 166, 29);
		
		this.getContentPane().add(ManaeInstructors);
		this.getContentPane().add(ManageStudents);
		
		//Creating Student Buttons and setting colors, fonts, bounds
		JButton DisplayStudentDataBtn = new JButton("Display Student Data");
		
		
		DisplayStudentDataBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		DisplayStudentDataBtn.setForeground(new Color(237, 222, 222));
		DisplayStudentDataBtn.setBackground(new Color(172, 83, 83));
		DisplayStudentDataBtn.setBounds(10, 115, 166, 33);
		this.getContentPane().add(DisplayStudentDataBtn);		
		DisplayStudentDataBtn.setFocusable(false);
		
		final JButton SaveStudentDataBtn = new JButton("Save Student Data");
		
		
		SaveStudentDataBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		SaveStudentDataBtn.setForeground(new Color(237, 222, 222));
		SaveStudentDataBtn.setBackground(new Color(172, 83, 83));
		SaveStudentDataBtn.setBounds(10, 165, 166, 33);
		this.getContentPane().add(SaveStudentDataBtn);		
		SaveStudentDataBtn.setFocusable(false);
		
		JButton ChangeStudentUserBtn = new JButton("Change Username");
		
		
		ChangeStudentUserBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeStudentUserBtn.setForeground(new Color(237, 222, 222));
		ChangeStudentUserBtn.setBackground(new Color(172, 83, 83));
		ChangeStudentUserBtn.setBounds(10, 215, 166, 33);
		this.getContentPane().add(ChangeStudentUserBtn);		
		ChangeStudentUserBtn.setFocusable(false);
		
		JButton ChangeStudentPassBtn = new JButton("Change Password");
		
		
		ChangeStudentPassBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeStudentPassBtn.setForeground(new Color(237, 222, 222));
		ChangeStudentPassBtn.setBackground(new Color(172, 83, 83));
		ChangeStudentPassBtn.setBounds(10, 265, 166, 33);
		this.getContentPane().add(ChangeStudentPassBtn);		
		ChangeStudentPassBtn.setFocusable(false);
		
		//Creating Instructor Buttons and setting colors, fonts, bounds
		JButton DisplayInstructorDataBtn = new JButton("Display Instructor Data");
		
		
		DisplayInstructorDataBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		DisplayInstructorDataBtn.setForeground(new Color(237, 222, 222));
		DisplayInstructorDataBtn.setBackground(new Color(172, 83, 83));
		DisplayInstructorDataBtn.setBounds(200, 115, 200, 33);
		this.getContentPane().add(DisplayInstructorDataBtn);		
		DisplayInstructorDataBtn.setFocusable(false);
		
		JButton DisplayCourseDataBtn = new JButton("Display Courses Data");
		
		DisplayCourseDataBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		DisplayCourseDataBtn.setForeground(new Color(237, 222, 222));
		DisplayCourseDataBtn.setBackground(new Color(172, 83, 83));
		DisplayCourseDataBtn.setBounds(200, 165, 200, 33);
		this.getContentPane().add(DisplayCourseDataBtn);		
		DisplayCourseDataBtn.setFocusable(false);
		
		JButton SaveCourseDataBtn = new JButton("Save Course Data");
		
		SaveCourseDataBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		SaveCourseDataBtn.setForeground(new Color(237, 222, 222));
		SaveCourseDataBtn.setBackground(new Color(172, 83, 83));
		SaveCourseDataBtn.setBounds(200, 215, 200, 33);
		this.getContentPane().add(SaveCourseDataBtn);		
		SaveCourseDataBtn.setFocusable(false);
		
		JButton ChangeInstructorUserBtn = new JButton("Change Username");
		
		ChangeInstructorUserBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeInstructorUserBtn.setForeground(new Color(237, 222, 222));
		ChangeInstructorUserBtn.setBackground(new Color(172, 83, 83));
		ChangeInstructorUserBtn.setBounds(200, 265, 200, 33);
		this.getContentPane().add(ChangeInstructorUserBtn);		
		ChangeInstructorUserBtn.setFocusable(false);
		
		JButton ChangeInstructorPassBtn = new JButton("Change Password");
		
		ChangeInstructorPassBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeInstructorPassBtn.setForeground(new Color(237, 222, 222));
		ChangeInstructorPassBtn.setBackground(new Color(172, 83, 83));
		ChangeInstructorPassBtn.setBounds(200, 315, 200, 33);
		this.getContentPane().add(ChangeInstructorPassBtn);		
		ChangeInstructorPassBtn.setFocusable(false);
		
		//Logout menu item Event Handler
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//disposes frames in AdminView
				Frame[] frames = AdministratorView.getFrames();
				for (int i = 0; i < frames.length; i++) {
					frames[i].dispose();
				}
  				new LoginView(students, instructors, admin,courses);
			
			}});
		
		
		//Students Menu and Buttons Event Handling
		
			//Event handling for admin to display data for certain student through a menu
		DisplayStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Student to display his Records");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						DisplayData ViewData = new DisplayData(students.get(i));
			   						notfound=false;
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

			   		}
	   					if(notfound)JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   			
			   		 notfound=true;
			   			
			   		}
			}
			}});
		
		
			//Event handling for admin to save student records through a menu
		SaveStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//asks user to enter id of student to display his data
				Choose.setText("Choose Student to display his Records");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				//pop up for the admin to choose id
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Student ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
			   			ID=Integer.parseInt(IDChosen.getText());
			   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						notfound=false;
			   						JFileChooser DataFile = new JFileChooser(".");
			   		                int choice = DataFile.showSaveDialog(SaveStudentData);
			   		                if (choice == JFileChooser.APPROVE_OPTION) {
			   		                    File selectedFile = DataFile.getSelectedFile();
			   		                      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			   		                          
			   		                          try{
			   		                        	  FileWriter writer = new FileWriter(selectedFile);
			   		                        	  writer.write("Name: "+students.get(i).getName()+"\n");
			   		                        	  writer.write("ID: "+students.get(i).getId()+"\n");
			   		                        	  writer.write("Major: "+students.get(i).getMajor()+"\n");
			   		                        	  writer.write("Courses: "+"\n");
			   		                        	  for(int j=0;j<students.get(i).getCourses().size();j++) {
			   		                        		  writer.write("Course "+(j+1)+":\tName: "+students.get(i).getCourses().get(j).getName()+"\tCourse Code:"+students.get(i).getCourses().get(j).getCourseCode()+"\tCredits:"+students.get(i).getCourses().get(j).getCredits()+"\tGrade:"+students.get(i).getCourses().get(j).getGrade().getGrade()+"\n");			
			   		                        	  }
			   		                             
			   		                        	  writer.close();                          
			   		                          } catch (IOException e1) {                             
			   		                              e1.printStackTrace();
			   		                          }
			   		                }
			   						
			   					}
			   					//JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   			
			   		 
			   			if(notfound)JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			   		}
			}
			   	notfound = true;
			}
		});
		
			//Event handling for admin to change student username through a menu
		ChangeStudentUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Student to Change his username");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Student ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						notfound=false;
			   						namepanel.add(newnamelabel);
			   					   	namepanel.add(newnameField);
			   					   	
			   					   	int a1 = JOptionPane.showOptionDialog(null, namepanel, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   								{"Confirm", "Cancel"}, null);  

			   					   	if (a1 == JOptionPane.OK_OPTION) {
			   					   		if(newnameField.getText().equals("")) //Check if name is entered
			   								JOptionPane.showMessageDialog(null, "Please Enter new Username");
			   					   		else {
			   					   		students.get(i).setUsername(newnameField.getText());			   					   		
			   							JOptionPane.showMessageDialog(null, "Username Changed Successfully");
			   					   		}
			   					   		
			   					   	}
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}	
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;
			}
		});
		
		
			//Event handling for admin to change student password through a menu
		ChangeStudentPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Student to Change his Password");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Student ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						notfound=true;
			   						//setting up a pop up panel to change password
			   						passpanel.add(oldpasslabel);
			   						passpanel.add(oldpassField);
			   						passpanel.add(newpass1label);
			   						passpanel.add(newpass1Field);
			   						passpanel.add(newpass2label);
			   						passpanel.add(newpass2Field);
			   					   	
			   						//Pop up pane without any icon or option dialogue, just the contents of passpanel
			   						int a1 = JOptionPane.showOptionDialog(null, passpanel, "Change Password", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   						{"Confirm", "Cancel"}, null); 

			   						if (String.valueOf(oldpassField.getPassword()).equals(students.get(i).getPassword())
			   		        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword()))){
			   		        			students.get(i).setPassword(String.valueOf(newpass1Field.getPassword()));
			   		        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
			   		        			System.out.println(students.get(i).getPassword());

			   		        		}
			   					   		else {
			   					   			JOptionPane.showMessageDialog(null, "Incorrect Old Password / New Passwords Not Matching");
			   					   		}
			   					   		
			   					   	}
			   					}
			   				}catch(Exception e1) {
			   				e1.printStackTrace();			   							   				
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   			}			   						   		 			   			
			   			
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			   	}
			   notfound=true;	
			}			   								
		});
		
			//Event Handling for Admin displaying student data through a button
		DisplayStudentDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Student to display his Records");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						DisplayData ViewData = new DisplayData(students.get(i));
			   						notfound=false;
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
	   					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   		 notfound=true;
			   			
			   		}
			}
			}
		});
			
			//Event Handling for Admin to save Student data
		SaveStudentDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//asks user to enter id of student to display his data
				Choose.setText("Choose Student to display his Records");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				//pop up for the admin to choose id
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Student ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						notfound=false;
			   						JFileChooser DataFile = new JFileChooser(".");
			   		                int choice = DataFile.showSaveDialog(SaveStudentDataBtn);
			   		                if (choice == JFileChooser.APPROVE_OPTION) {
			   		                    File selectedFile = DataFile.getSelectedFile();
			   		                      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			   		                          
			   		                          try{
			   		                        	  FileWriter writer = new FileWriter(selectedFile);
			   		                        	  writer.write("Name: "+students.get(i).getName()+"\n");
			   		                        	  writer.write("ID: "+students.get(i).getId()+"\n");
			   		                        	  writer.write("Major: "+students.get(i).getMajor()+"\n");
			   		                        	  writer.write("Courses: "+"\n");
			   		                        	  for(int j=0;j<students.get(i).getCourses().size();j++) {
			   		                        		  writer.write("Course "+(j+1)+":\tName: "+students.get(i).getCourses().get(j).getName()+"\tCourse Code:"+students.get(i).getCourses().get(j).getCourseCode()+"\tCredits:"+students.get(i).getCourses().get(j).getCredits()+"\tGrade:"+students.get(i).getCourses().get(j).getGrade().getGrade()+"\n");			
			   		                        	  }
			   		                             
			   		                        	  writer.close();                          
			   		                          } catch (IOException e1) {                             
			   		                              e1.printStackTrace();
			   		                          }
			   		                }
			   						
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
	   					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
			   		 
			   			
			   		}
			}
					notfound=true;

			}
		});
		
			//Event Handling for admin changing username through a button
		ChangeStudentUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Student to Change his username");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Student ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						notfound=false;
			   						namepanel.add(newnamelabel);
			   					   	namepanel.add(newnameField);
			   					   	
			   					   	int a1 = JOptionPane.showOptionDialog(null, namepanel, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   								{"Confirm", "Cancel"}, null);  

			   					   	if (a1 == JOptionPane.OK_OPTION) {
			   					   		if(newnameField.getText().equals("")) //Check if name is entered
			   								JOptionPane.showMessageDialog(null, "Please Enter new Username");
			   					   		else {
			   					   		students.get(i).setUsername(newnameField.getText());			   					   		
			   							JOptionPane.showMessageDialog(null, "Username Changed Successfully");
			   					   		}
			   					   		
			   					   	}
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}		
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;
			}
		});
		
			//Event Handling for Admin to change Student Password through a button
		ChangeStudentPassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Student to Change his Password");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Student ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Student");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<students.size();i++) {
			   					if(ID==students.get(i).getId()) {
			   						notfound=false;
			   						//setting up a pop up panel to change password
			   						passpanel.add(oldpasslabel);
			   						passpanel.add(oldpassField);
			   						passpanel.add(newpass1label);
			   						passpanel.add(newpass1Field);
			   						passpanel.add(newpass2label);
			   						passpanel.add(newpass2Field);
			   					   	
			   						//Pop up pane without any icon or option dialogue, just the contents of passpanel
			   						int a1 = JOptionPane.showOptionDialog(null, passpanel, "Change Password", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   						{"Confirm", "Cancel"}, null); 
			   						
			   						if (a1 == JOptionPane.OK_OPTION) {
				   						if (String.valueOf(oldpassField.getPassword()).equals(students.get(i).getPassword())
				   		        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword()))){
				   		        			students.get(i).setPassword(String.valueOf(newpass1Field.getPassword()));
				   		        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
				   		        			System.out.println(students.get(i).getPassword());
	
				   		        		}
				   					   		else {
				   					   			JOptionPane.showMessageDialog(null, "Incorrect Old Password / New Passwords Not Matching");
				   					   		}
			   					   		
			   					   	}
			   					}
			   					}
			   				}catch(Exception e1) {
			   				e1.printStackTrace();			   							   				
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   			}			   						   		 			   			
			   		}	
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   notfound=true;	
			}
		});
		
		//______________________________________________________________________________________________________________________________________
		
		
		//Instructor Menu and Button Event Handling
		
			//Event handling for Instructor Menus
		
				//Event Handling so Admin can display Instructor data through the menu
		DisplayInstructorData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Instructor to Display their Data");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   				 		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", instructors.get(i).getName(), "ID", String.valueOf(instructors.get(i).getId()), "Department", instructors.get(i).getDept()},0);
			   			       		JTable instructorTable = new JTable(tableModel);

			   			       		JScrollPane tablePane = new JScrollPane(instructorTable);
			   			       		JPanel tablePanel = new JPanel(new GridLayout(1,1,0,0));
			   			       		

			   			       		tableModel.addRow(new String[] {"Term", "Fall 2022"});
			   			       		tableModel.addRow(new String[] {"Courses"});
			   			       		tableModel.addRow(new String[] {"Name", "Number"});
			   			       		if(!(instructors.get(i).getCourses()==null)) {
			   			       			for (int j = 0; j < instructors.get(i).getCourses().size(); j++) {
			   			           		
			   			       			tableModel.addRow(new String[] {instructors.get(i).getCourses().get(j).getName(), instructors.get(i).getCourses().get(j).getCourseCode()});
			   			       			}
			   			       		}
			   			    		tablePanel.add(tablePane);
			   			       		
			   			       		
			   			       		JOptionPane.showOptionDialog(null, tablePanel, "Instructor Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   			       				{}, null);
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}	
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;

				
				
//		 		
			}
		});
				//Event Handling so Admin can display Instructor course data through the menu
		DisplayCourseData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Choose.setText("Choose Instructor to Display their Data");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						final Instructor instructor = instructors.get(i);
			   						
			   						JPanel panel = new JPanel(new GridLayout(instructor.getCourses().size()+1,1));
			   						
			   						
			   		           		//Adding menu items to the popup
			   		           		if(!(instructor.getCourses()==null)) {
			   		           			for (int j = 0; j < instructor.getCourses().size();j++) {
			   		           		   JButton courseItem = new JButton(instructor.getCourses().get(j).getName() + " " + instructor.getCourses().get(j).getCourseCode());
			   		           		   
			   		           		   final Courses course = instructor.getCourses().get(i);
			   		           		   
			   		           		//Display course data on menu item click
			   		           		courseItem.addActionListener(new ActionListener() {
			   		                   	public void actionPerformed(ActionEvent ev) {
			   		                   		
			   		                   		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", instructor.getName(), "ID", String.valueOf(instructor.getId()), "Department", instructor.getDept()},0);
			   		                   		JTable courseTable = new JTable(tableModel);

			   		                   		JScrollPane tablePane = new JScrollPane(courseTable);
			   		                   		JPanel tablePanel = new JPanel(new GridLayout(1,1,0,0));
			   		                   		
			   		                   		tablePanel.add(tablePane);
			   		                   		tableModel.addRow(new String[] {"Term", "Fall 2022","","","",""});
			   		                   		tableModel.addRow(new String[] {"Course",course.getCourseCode(),course.getCourseCode(),course.getName(),"",""});
			   		                   		
			   		                   		tableModel.addRow(new String[] {"ID","Name","Grade","","",""});

			   		                   		if (course.getStudents() != null) {
			   		                   		for (int j = 0; j < course.getStudents().size(); j ++) {
			   		                       		tableModel.addRow(new String[] {String.valueOf(course.getStudents().get(j).getId()),course.getStudents().get(j).getName(),String.valueOf(course.getStudents().get(j).getGrade().getGrade()),"","",""});
			   		                   		}
			   		                   		}
			   		                   		

			   		                   		JOptionPane.showOptionDialog(null, tablePanel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   		                   				{}, null);
			   		           		   
			   		           		}
			   		        	});
			   		           		   
			   		           		   panel.add(courseItem);
			   		           			}
			   		           		}
			   		           	JOptionPane.showOptionDialog(null, panel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
   		                   				{}, null);			   		           		
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}		
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;

				
			}
		});
				//Event Handling so Admin can save Instructor course data through the menu
		SaveCourseData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Choose.setText("Choose Instructor to Change his username");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						final Instructor instructor = instructors.get(i);
			   						JPanel CourseDataPanel = new JPanel(new BorderLayout());
			   	      				
			   	      				
			   	      				JLabel lbl = new JLabel("Choose a Course to Save");
			   	      				
			   	      				JPanel coursesPanel = new JPanel(new GridLayout(instructor.getCourses().size(),1));
			   	      				
			   	      				for (int j = 0; j < instructor.getCourses().size();j++) {
			   	      				JButton courseButton = new JButton(instructor.getCourses().get(j).getName() + instructor.getCourses().get(j).getCourseCode());
			   	      				
			   	      				final Courses course = instructor.getCourses().get(j);
			   	      				
			   	      				courseButton.addActionListener(new ActionListener() {
			   	      	      			public void actionPerformed(ActionEvent e) {   
			   	      	      				
			   	          				JFileChooser DataFile = new JFileChooser(".");
			   	                          int choice = DataFile.showSaveDialog(SaveCourseData);//Selects file
			   	                          if (choice == JFileChooser.APPROVE_OPTION) {
			   	                              File selectedFile = DataFile.getSelectedFile();
			   	                                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			   	                                    
			   	                                    try{
			   	                                  	  FileWriter writer = new FileWriter(selectedFile);//Creates FileWriter to display records
			   	                                  	  writer.write("Name; "+instructor.getName() + "; ID ; "+instructor.getId() +  "; Department; " + instructor.getDept() + "\n");//adds name to the text file
			   	                                  	  writer.write("Term; Fall2022;\n");//add ID to the text file
			   	                                  	  writer.write("Course: "+ course.getCourseCode() + "; " + course.getName()+"\n");
			   	                                  	  writer.write("ID ; Name; Grade"+"\n");
			   	                                  	  
			   	                                  	  
			   	    
			   	                                  	  for(int j=0; j < course.getStudents().size(); j++) {//this for loop adds all courses registered by instructor one by one
			   	                                  		  writer.write(course.getStudents().get(j).getId() + " ; " + course.getStudents().get(j).getName() + " ; " + course.getStudents().get(j).getGrade().getGrade());			
			   	                                  	  }
			   	                                       
			   	                                  	  writer.close();                          
			   	                                    } catch (IOException e1) {                             
			   	                                        e1.printStackTrace();
			   	                                    }
			   	                          }
			   	      	      				
			   	      	      				
			   	      	      			}
			   	      	      			});
			   	      				
			   	      				coursesPanel.add(courseButton);
			   	      				}
			   	      				
			   	      			
			   	      				
			   	      				CourseDataPanel.add(lbl,BorderLayout.NORTH);
			   	      				CourseDataPanel.add(coursesPanel,BorderLayout.SOUTH);
			   	      				
			   	      				JOptionPane.showOptionDialog(null, CourseDataPanel, "Save Course", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   	      						{}, null); 
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}		
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;
			   	
				
			}
		});
				//Event Handling so Admin can Change Instructor's Username
		ChangeInstructorPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Choose.setText("Choose Instructor to Change his Password");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						//setting up a pop up panel to change password
			   						passpanel.add(oldpasslabel);
			   						passpanel.add(oldpassField);
			   						passpanel.add(newpass1label);
			   						passpanel.add(newpass1Field);
			   						passpanel.add(newpass2label);
			   						passpanel.add(newpass2Field);
			   					   	
			   						//Pop up pane without any icon or option dialogue, just the contents of passpanel
			   						int a1 = JOptionPane.showOptionDialog(null, passpanel, "Change Password", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   						{"Confirm", "Cancel"}, null); 
			   						if (a1 == JOptionPane.OK_OPTION) {
			   						if (String.valueOf(oldpassField.getPassword()).equals(instructors.get(i).getPassword())
			   		        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword()))){
			   		        			instructors.get(i).setPassword(String.valueOf(newpass1Field.getPassword()));
			   		        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
			   		        			System.out.println(instructors.get(i).getPassword());

			   		        		}
			   					   		else {
			   					   			JOptionPane.showMessageDialog(null, "Incorrect Old Password / New Passwords Not Matching");
			   					   		}
			   					   		
			   					   	}
			   					}
			   					}
			   				}catch(Exception e1) {
			   				e1.printStackTrace();			   							   				
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   			}			   						   		 			   			
			   		}	
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   notfound=true;	
				
				
			}
		});
				//Event Handling so Admin can Change Instructor's Password
		ChangeInstructorUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Choose.setText("Choose Instructor to Change his username");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						namepanel.add(newnamelabel);
			   					   	namepanel.add(newnameField);
			   					   	
			   					   	int a1 = JOptionPane.showOptionDialog(null, namepanel, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   								{"Confirm", "Cancel"}, null);  

			   					   	if (a1 == JOptionPane.OK_OPTION) {
			   					   		if(newnameField.getText().equals("")) //Check if name is entered
			   								JOptionPane.showMessageDialog(null, "Please Enter new Username");
			   					   		else {
			   					   		instructors.get(i).setUsername(newnameField.getText());			   					   		
			   							JOptionPane.showMessageDialog(null, "Username Changed Successfully");
			   					   		}
			   					   		
			   					   	}
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}		
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
			   	
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;

				
				
			}
		});
		
			
			//Event Handling for Instructor's Management Buttons
				
				//Event Handling so Admin can Display Instructor Data	
		DisplayInstructorDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			   	
			   	Choose.setText("Choose Instructor to Display their Data");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   				 		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", instructors.get(i).getName(), "ID", String.valueOf(instructors.get(i).getId()), "Department", instructors.get(i).getDept()},0);
			   			       		JTable instructorTable = new JTable(tableModel);

			   			       		JScrollPane tablePane = new JScrollPane(instructorTable);
			   			       		JPanel tablePanel = new JPanel(new GridLayout(1,1,0,0));
			   			       		

			   			       		tableModel.addRow(new String[] {"Term", "Fall 2022"});
			   			       		tableModel.addRow(new String[] {"Courses"});
			   			       		tableModel.addRow(new String[] {"Name", "Number"});
			   			       		if(!(instructors.get(i).getCourses()==null)) {
			   			       			for (int j = 0; j < instructors.get(i).getCourses().size(); j++) {
			   			           		
			   			       			tableModel.addRow(new String[] {instructors.get(i).getCourses().get(j).getName(), instructors.get(i).getCourses().get(j).getCourseCode()});
			   			       			}
			   			       		}
			   			    		tablePanel.add(tablePane);
			   			       		
			   			       		
			   			       		JOptionPane.showOptionDialog(null, tablePanel, "Instructor Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   			       				{}, null);
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}			  
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;

				

			   	
			   	
			   	
			}
		});
		
				//Event Handling so Admin can Display Course Data
		DisplayCourseDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setText("Choose Instructor to Display their Data");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						final Instructor instructor = instructors.get(i);
			   						
			   						JPanel panel = new JPanel(new GridLayout(instructor.getCourses().size()+1,1));
			   						
			   						
			   		           		//Adding menu items to the popup
			   		           		if(!(instructor.getCourses()==null)) {
			   		           			for (int j = 0; j < instructor.getCourses().size();j++) {
			   		           		   JButton courseItem = new JButton(instructor.getCourses().get(j).getName() + " " + instructor.getCourses().get(j).getCourseCode());
			   		           		   
			   		           		   final Courses course = instructor.getCourses().get(i);
			   		           		   
			   		           		//Display course data on menu item click
			   		           		courseItem.addActionListener(new ActionListener() {
			   		                   	public void actionPerformed(ActionEvent ev) {
			   		                   		
			   		                   		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", instructor.getName(), "ID", String.valueOf(instructor.getId()), "Department", instructor.getDept()},0);
			   		                   		JTable courseTable = new JTable(tableModel);

			   		                   		JScrollPane tablePane = new JScrollPane(courseTable);
			   		                   		JPanel tablePanel = new JPanel(new GridLayout(1,1,0,0));
			   		                   		
			   		                   		tablePanel.add(tablePane);
			   		                   		tableModel.addRow(new String[] {"Term", "Fall 2022","","","",""});
			   		                   		tableModel.addRow(new String[] {"Course",course.getCourseCode(),course.getName(),"",""});
			   		                   		
			   		                   		tableModel.addRow(new String[] {"ID","Name","Grade","","",""});

			   		                   		if (course.getStudents() != null) {
			   		                   		for (int j = 0; j < course.getStudents().size(); j ++) {
			   		                       		tableModel.addRow(new String[] {String.valueOf(course.getStudents().get(j).getId()),course.getStudents().get(j).getName(),String.valueOf(course.getStudents().get(j).getGrade().getGrade()),"","",""});
			   		                   		}
			   		                   		}
			   		                   		

			   		                   		JOptionPane.showOptionDialog(null, tablePanel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   		                   				{}, null);
			   		           		   
			   		           		}
			   		        	});
			   		           		   
			   		           		   panel.add(courseItem);
			   		           			}
			   		           		}
			   		           	JOptionPane.showOptionDialog(null, panel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
   		                   				{}, null);			   		           		
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}		
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	
			   	notfound=true;
				
				
			}
		});
		
				//Event Handling so Admin can Save Course Data
		SaveCourseDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Choose.setText("Choose Instructor to Change his username");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						final Instructor instructor = instructors.get(i);
			   						JPanel CourseDataPanel = new JPanel(new BorderLayout());
			   	      				
			   	      				
			   	      				JLabel lbl = new JLabel("Choose a Course to Save");
			   	      				
			   	      				JPanel coursesPanel = new JPanel(new GridLayout(instructor.getCourses().size(),1));
			   	      				
			   	      				for (int j = 0; j < instructor.getCourses().size();j++) {
			   	      				JButton courseButton = new JButton(instructor.getCourses().get(j).getName() + instructor.getCourses().get(j).getCourseCode());
			   	      				
			   	      				final Courses course = instructor.getCourses().get(j);
			   	      				
			   	      				courseButton.addActionListener(new ActionListener() {
			   	      	      			public void actionPerformed(ActionEvent e) {   
			   	      	      				
			   	          				JFileChooser DataFile = new JFileChooser(".");
			   	                          int choice = DataFile.showSaveDialog(SaveCourseData);//Selects file
			   	                          if (choice == JFileChooser.APPROVE_OPTION) {
			   	                              File selectedFile = DataFile.getSelectedFile();
			   	                                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			   	                                    
			   	                                    try{
			   	                                  	  FileWriter writer = new FileWriter(selectedFile);//Creates FileWriter to display records
			   	                                  	  writer.write("Name; "+instructor.getName() + "; ID ; "+instructor.getId() +  "; Department; " + instructor.getDept() + "\n");//adds name to the text file
			   	                                  	  writer.write("Term; Fall2022;\n");//add ID to the text file
			   	                                  	  writer.write("Course: "+ course.getCourseCode() + "; " + course.getName()+"\n");
			   	                                  	  writer.write("ID ; Name; Grade"+"\n");
			   	                                  	  
			   	                                  	  
			   	    
			   	                                  	  for(int j=0; j < course.getStudents().size(); j++) {//this for loop adds all courses registered by instructor one by one
			   	                                  		  writer.write(course.getStudents().get(j).getId() + " ; " + course.getStudents().get(j).getName() + " ; " + course.getStudents().get(j).getGrade().getGrade());			
			   	                                  	  }
			   	                                       
			   	                                  	  writer.close();                          
			   	                                    } catch (IOException e1) {                             
			   	                                        e1.printStackTrace();
			   	                                    }
			   	                          }
			   	      	      				
			   	      	      				
			   	      	      			}
			   	      	      			});
			   	      				
			   	      				coursesPanel.add(courseButton);
			   	      				}
			   	      				
			   	      			
			   	      				
			   	      				CourseDataPanel.add(lbl,BorderLayout.NORTH);
			   	      				CourseDataPanel.add(coursesPanel,BorderLayout.SOUTH);
			   	      				
			   	      				JOptionPane.showOptionDialog(null, CourseDataPanel, "Save Course", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   	      						{}, null); 
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;
			   	
			   	
				
			}
		});
		
				//Event Handling so Admin can Change Instructor's Username
		ChangeInstructorUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Choose.setText("Choose Instructor to Change his username");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						namepanel.add(newnamelabel);
			   					   	namepanel.add(newnameField);
			   					   	
			   					   	int a1 = JOptionPane.showOptionDialog(null, namepanel, "Change Username", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   								{"Confirm", "Cancel"}, null);  

			   					   	if (a1 == JOptionPane.OK_OPTION) {
			   					   		if(newnameField.getText().equals("")) //Check if name is entered
			   								JOptionPane.showMessageDialog(null, "Please Enter new Username");
			   					   		else {
			   					   		instructors.get(i).setUsername(newnameField.getText());			   					   		
			   							JOptionPane.showMessageDialog(null, "Username Changed Successfully");
			   					   		}
			   					   		
			   					   	}
			   					}
			   				}			   							   				
			   			}catch(Exception e1) {
			   				e1.printStackTrace();
			   			}		
			   		}catch(NumberFormatException e2){
						JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

		   			}
			   		}	
			   	}
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   	notfound=true;

				
				
			}
		});
				
				//Event Handling so Admin can Change Instructor's Password
		ChangeInstructorPassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Choose.setText("Choose Instructor to Change his Password");
				ChooseID.add(Choose);
				ChooseID.add(IDChosen);
				
				int a = JOptionPane.showOptionDialog(null, ChooseID, "Instructor ID", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
						{"Confirm", "Cancel"}, null);
				

			   	if (a == JOptionPane.OK_OPTION) {
			   		if(IDChosen.getText().equals("")) //Check if name is entered
						JOptionPane.showMessageDialog(null, "Please Enter the ID of the Instructor");
			   		else {
			   			try {
				   			ID=Integer.parseInt(IDChosen.getText());
				   			
				   			
			   			
			   			try {			   				
			   				for(int i=0;i<instructors.size();i++) {
			   					if(ID==instructors.get(i).getId()) {
			   						notfound=false;
			   						//setting up a pop up panel to change password
			   						passpanel.add(oldpasslabel);
			   						passpanel.add(oldpassField);
			   						passpanel.add(newpass1label);
			   						passpanel.add(newpass1Field);
			   						passpanel.add(newpass2label);
			   						passpanel.add(newpass2Field);
			   					   	
			   						//Pop up pane without any icon or option dialogue, just the contents of passpanel
			   						int a1 = JOptionPane.showOptionDialog(null, passpanel, "Change Password", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			   						{"Confirm", "Cancel"}, null); 
			   						if (a1 == JOptionPane.OK_OPTION) {
			   						if (String.valueOf(oldpassField.getPassword()).equals(instructors.get(i).getPassword())
			   		        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword()))){
			   		        			instructors.get(i).setPassword(String.valueOf(newpass1Field.getPassword()));
			   		        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
			   		        			System.out.println(instructors.get(i).getPassword());

			   		        		}
			   					   		else {
			   					   			JOptionPane.showMessageDialog(null, "Incorrect Old Password / New Passwords Not Matching");
			   					   		}
			   					   		
			   					   	}
			   					}
			   					}
			   				}catch(Exception e1) {
			   				e1.printStackTrace();			   							   				
			   			}
			   			}catch(NumberFormatException e2){
							JOptionPane.showMessageDialog(null, "Please Enter an ID Number, not String");

			   			}
			   			}			   						   		 			   			
			   		}	
					if(notfound) JOptionPane.showMessageDialog(null, "ID not found", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);

			   notfound=true;	
				
			}
		});
		
		
		//Read data file saved by Instructor
		ReadCourseDataFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
		  				JFileChooser LoadCourse = new JFileChooser();
						LoadCourse.setApproveButtonText("Select File");
						LoadCourse.setAcceptAllFileFilterUsed(false);
						int choice = LoadCourse.showOpenDialog(ReadCourseDataFile);
						if (choice == JFileChooser.APPROVE_OPTION) { 
		  				
							File selectedFile = LoadCourse.getSelectedFile();
							System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		                    //FileReader reader = null;
		                    	try{                          
		                    		Scanner in = new Scanner(selectedFile);
		                    		
		                    		String data = "";
		                    		
		                    		while(in.hasNextLine() != false) {
		                    			
		                    		data = data + in.nextLine() + "\n";
		                    		
		                    		}
		                    		
		                    		//Dividing the entire text into lines
		                    		String tb_data[] = data.split("\n");
		                			String row[][] = new String[tb_data.length][6];

		                			//Column Data
		                    		String[] row1 = tb_data[0].split(";");
		                    		
		                    		System.out.println(tb_data[0]);
		                    		
		                    		for (int i = 0; i < 6 ; i++)
		                    		{
		                        		System.out.print(row1[i]);

		                    		}
		                    		
		                    		//The block of text is saved into a 2d array
		                    		for (int i = 1; i < tb_data.length; i++) {
		                    			StringTokenizer st = new StringTokenizer(tb_data[i], ";");
		                    			 
		                    			int j = 0;
		                    			 
		                    			while (st.hasMoreTokens()) {
			                    			row[i-1][j] = st.nextToken();
			                        		System.out.print(row[i-1][j]+" ");

			                    			j++;
		                    			}
		                        		System.out.println();

		                    		}
		                    		
		                    		DefaultTableModel tablemodel = new DefaultTableModel(row,row1);
		                    		
		                    		
		                    		
		                    		JTable table = new JTable(tablemodel);
		                    		JScrollPane pane = new JScrollPane(table);
		                    		JPanel panel = new JPanel();
		                    		panel.add(pane);
		                    		
		                    		JOptionPane.showOptionDialog(null, panel, "Course File", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
			 	      						{}, null); 
		                    		
		            				in.close();                   		
		                    		
		                    	} catch (IOException e1) {
		                        // TODO Auto-generated catch block
		                        e1.printStackTrace();
		                    	}				
												
		  			}
		  			
			}
		});
		
		
		
		this.setVisible(true);
	}
	
	
	
	
}
