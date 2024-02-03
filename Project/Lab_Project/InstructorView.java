package Lab_Project;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InstructorView{

	JFrame frame = new JFrame();      
    JPanel p2 = new JPanel();
    
    Date dt = new Date();	
    String Semester=null;
    
    Instructor instructor;
    ArrayList<Courses> courses;
    ArrayList<Students> students;
    ArrayList<Instructor> instructors;

    //panel for changing password
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
	
	//Used in  Change Grade Event Handeler
	Students tmpStd;
	Grade tmpGrd;
	
	ArrayList<Administrator> admin;
   
   public InstructorView(Instructor instructor_, ArrayList<Courses> courses_, ArrayList<Instructor> _instructors, ArrayList<Students> _students,ArrayList<Administrator> admin_) {
    
	   	this.instructor = instructor_;
	   	this.courses = courses_;
	   	this.admin=admin_;
	   
	   	this.instructors = _instructors;
	   	this.students = _students;
	   	frame.getContentPane().setBackground(new Color(105, 102, 103));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setBounds(700, 250, 420, 420);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);	
		
		//Creating a Label and setting its colors, font and bounds
		JLabel welcome = new JLabel("Instructor Page");
		welcome.setForeground(new Color(237, 222, 222));
		welcome.setFont(new Font("Bookman Old Style", Font.PLAIN, 19));
		welcome.setBounds(135, 11, 200, 35);
		
		//Creating MenuBar, Menus, and MenuItems. And naming them
		JMenuBar Menubar = new JMenuBar();
		JMenu Courses = new JMenu("Manage Courses");
		JMenu Personal = new JMenu("Personal Information");
		
		final JMenuItem AddCourse = new JMenuItem("Add Courses");
		final JMenuItem SaveCourseData = new JMenuItem("Save Records");
		JMenuItem ChangeUser = new JMenuItem("Change Username");
		JMenuItem ChangePass = new JMenuItem("Change Password");
		JMenuItem Logout = new JMenuItem("Logout"); 
		JMenuItem ChangeGrade = new JMenuItem("Change Grade");		
		JMenuItem ReadCourseFile = new JMenuItem("Read Course File");
				
		
		//Changing Colors, fonts, and font colors of all menus, menu items, and the menu bar
		
		Menubar.setBackground(new Color(105, 102, 103));
		
		Courses.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Courses.setForeground(new Color(237, 222, 222));		
		
		Logout.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Logout.setForeground(new Color(237, 222, 222));
		Logout.setBackground(new Color(105, 102, 103));
		
		Personal.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		Personal.setForeground(new Color(237, 222, 222));
		
		AddCourse.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		AddCourse.setForeground(new Color(237, 222, 222));
		AddCourse.setBackground(new Color(172, 83, 83));
				
		
		SaveCourseData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		SaveCourseData.setForeground(new Color(237, 222, 222));
		SaveCourseData.setBackground(new Color(172, 83, 83));
					
		ChangeUser.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeUser.setForeground(new Color(237, 222, 222));
		ChangeUser.setBackground(new Color(172, 83, 83));
		
		ChangePass.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangePass.setForeground(new Color(237, 222, 222));
		ChangePass.setBackground(new Color(172, 83, 83));
		
		ChangeGrade.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ChangeGrade.setForeground(new Color(237, 222, 222));
		ChangeGrade.setBackground(new Color(172, 83, 83));
		
		ReadCourseFile.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		ReadCourseFile.setForeground(new Color(237, 222, 222));
		ReadCourseFile.setBackground(new Color(172, 83, 83));
		
		
		//Adding Menu bar, Menus and Menu Items
		Courses.add(SaveCourseData);
		Courses.add(AddCourse);
		Courses.add(ChangeGrade);
		Courses.add(ReadCourseFile);
		Personal.add(ChangeUser);
		Personal.add(ChangePass);
		Menubar.add(Personal);
		Menubar.add(Courses);
		Menubar.add(Logout);


		frame.setJMenuBar(Menubar);
		frame.getContentPane().add(welcome);
		
		JButton changepass = new JButton("Change Password");
		JButton changename = new JButton("Change Name");
		JButton CourseData = new JButton("Course Data");
	    JButton DisplayRecordsBtn = new JButton("Display Records");
	    
	    JLabel lblSelfserviceSystem = new JLabel("Self-Service System:");
		JLabel lblPersonalInformation = new JLabel("Personal Information:");
		
		lblSelfserviceSystem.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		lblPersonalInformation.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		
		lblSelfserviceSystem.setForeground(new Color(237, 222, 222));
		lblPersonalInformation.setForeground(new Color(237, 222, 222));
		
		lblPersonalInformation.setBounds(200, 75, 194, 29);
		lblSelfserviceSystem.setBounds(10, 75, 166, 29);
	    
		frame.getContentPane().add(lblPersonalInformation);
		frame.getContentPane().add(lblSelfserviceSystem);
		
	    DisplayRecordsBtn.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
	    DisplayRecordsBtn.setForeground(new Color(237, 222, 222));
	    DisplayRecordsBtn.setBackground(new Color(172, 83, 83));
	    DisplayRecordsBtn.setBounds(10, 115, 156, 33);
	    
	    CourseData.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
	    CourseData.setForeground(new Color(237, 222, 222));
	    CourseData.setBackground(new Color(172, 83, 83));
	    CourseData.setBounds(10, 165, 156, 33);
	    
	    
	    changename.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
	    changename.setForeground(new Color(237, 222, 222));
	    changename.setBackground(new Color(172, 83, 83));
	    changename.setBounds(200, 115, 156, 33);
	    
	    changepass.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
	    changepass.setForeground(new Color(237, 222, 222));
	    changepass.setBackground(new Color(172, 83, 83));
	    changepass.setBounds(200, 165, 156, 33);
	    
	    frame.getContentPane().add(DisplayRecordsBtn);
		frame.getContentPane().add(CourseData);
		frame.getContentPane().add(changename);
		frame.getContentPane().add(changepass);		      
        frame.setVisible(true);
        
        
        
        if(dt.getMonth()+1>=1 && dt.getMonth()<=5) Semester ="Spring";
		if(dt.getMonth()+1>=9 && dt.getMonth()<=12) Semester ="Fall";
		if(dt.getMonth()+1>=6 && dt.getMonth()<=8) Semester ="Summer";
        
		ReadCourseFile.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				JFileChooser LoadCourse = new JFileChooser();
				LoadCourse.setApproveButtonText("Select File");
				LoadCourse.setAcceptAllFileFilterUsed(false);
				int choice = LoadCourse.showOpenDialog(AddCourse);
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
		
        
        Logout.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				frame.dispose();
  				
  				new LoginView(students, instructors, admin,courses);
  				
  			}
  			});
 	   
       
        ChangeGrade.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				
  				JPanel CoursesPanel = new JPanel(new BorderLayout());

  				JLabel lbl = new JLabel("Which course would you like to change the grades of?");
  				
  				JPanel savecoursesPanel = new JPanel(new GridLayout(instructor.getCourses().size(),1));
  				
  				for (int i = 0; i < instructor.getCourses().size();i++) {
	  				JButton courseButton = new JButton(instructor.getCourses().get(i).getName() + instructor.getCourses().get(i).getCourseCode());
	  				 
	  				final Courses course = instructor.getCourses().get(i);
	 				savecoursesPanel.add(courseButton);
	 				
	 				
	 				courseButton.addActionListener(new ActionListener() {
	 	      			public void actionPerformed(ActionEvent e) {
	 	      				JPanel studentsPanel = new JPanel(new GridLayout(course.getStudents().size(),1));
	 	      				JLabel selectStudent = new JLabel("Select the Student you would like to change the grade for");
	 	      				
	 	      				studentsPanel.add(selectStudent);
	 	      				for (int i = 0; i < course.getStudents().size(); i++) {
	 	      					
	 	      					for (int j = 0; j < course.getStudents().get(i).getCourses().size(); j++) {
	 	      						if (course.getStudents().get(i).getCourses().get(j) == course) {
	 	      							tmpStd = course.getStudents().get(i);
	 	      							tmpGrd = tmpStd.getGrades().get(j);
	 	      							JButton studentButton = new JButton(tmpStd.getName() + " Grade: " + 
	 	      						tmpStd.getGrades().get(j).getGrade());
	 	      							
	 	      							
	 	      							studentButton.addActionListener(new ActionListener() {
	 	      			 	      			public void actionPerformed(ActionEvent e) {
		 	      			 	      			JPanel changegradePanel = new JPanel(new GridLayout(2,2));
	 	      			 	      				
	 	      			 	      				JLabel currentGrade = new JLabel("Current Grade: " + tmpGrd.getGrade());
	 	      			 	      				JLabel newGrade = new JLabel("Enter New Grade");
	 	      			 	      				JTextField newGradeField = new JTextField();
	 	      			 	      				
	 	      			 	      			changegradePanel.add(currentGrade);
	 	      			 	      			changegradePanel.add(new JLabel());
	 	      			 	      			changegradePanel.add(newGrade);
	 	      			 	      			changegradePanel.add(newGradeField);
	 	      			 	      			
	 	      			 	      			
	 	      			 	      			
	 	      			 	      			
	 	      			 	      		int a = JOptionPane.showOptionDialog(null, changegradePanel, "Change Grade of " + tmpStd.getId(), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
	 	   	 	      						{"Confirm", "Cancel"}, null); 
	 	      			 	      		
		 	      			 	      		if (a == JOptionPane.OK_OPTION) {
		 	      			 	      			try {
		 	      			 	      			tmpGrd.setGrade(Double.parseDouble(newGradeField.getText()));
		 	      			 	      			}
		 	      			 	      			catch(NumberFormatException e1) {
		 	      			 	      			JOptionPane.showMessageDialog(null, "Enter a valid number","Error",JOptionPane.INFORMATION_MESSAGE);

		 	      			 	      			}
		 	      			 	      		}
		 	      			 	      			}
		 	      			 	      				
		 	      							}	
		 	      			 	      			);
		 	      							
		 		 	      					studentsPanel.add(studentButton);
		 	      						}
		 	      					}
		 	      					
		 	      				}
		 	      				
		 	      				JOptionPane.showOptionDialog(null, studentsPanel, "Change Grade", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
		 	      						{}, null); 
		 	      				
		 	      			}
	
		 				});
  				}
  				
  				
  				CoursesPanel.add(lbl,BorderLayout.NORTH);
  				CoursesPanel.add(savecoursesPanel,BorderLayout.SOUTH);
  				
  				
  				JOptionPane.showOptionDialog(null, CoursesPanel, "Change Grades", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
  						{}, null); 
  				
  			}
  			});
        
        
      //EventHandler for Saving Course Data menu item that saves the selected course information into a text file
      		SaveCourseData.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
      				
      				JPanel CourseDataPanel = new JPanel(new BorderLayout());
      				
      				
      				JLabel lbl = new JLabel("Choose a Course to Save");
      				
      				JPanel coursesPanel = new JPanel(new GridLayout(instructor.getCourses().size(),1));
      				
      				for (int i = 0; i < instructor.getCourses().size();i++) {
      				JButton courseButton = new JButton(instructor.getCourses().get(i).getName() + instructor.getCourses().get(i).getCourseCode());
      				
      				final Courses course = instructor.getCourses().get(i);
      				
      				courseButton.addActionListener(new ActionListener() {
      	      			public void actionPerformed(ActionEvent e) {   
      	      				
          				JFileChooser DataFile = new JFileChooser(".");
                          int choice = DataFile.showSaveDialog(SaveCourseData);//Selects file
                          if (choice == JFileChooser.APPROVE_OPTION) {
                              File selectedFile = DataFile.getSelectedFile();
                                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                                    
                                    try{
                                  	  FileWriter writer = new FileWriter(selectedFile);//Creates FileWriter to display records
                                  	  writer.write("Name;"+instructor.getName() + ";ID; "+instructor.getId() +  ";Department;" + instructor.getDept() + ";\n");//adds name to the text file
                                  	  writer.write("Term;Fall2022;\n");//add ID to the text file
                                  	  writer.write("Course:;"+course.getCourseCode()+";"+course.getName()+";\n");
                                  	  writer.write("ID;Name;Grade"+";\n");
                                  	  
                                  	  
                                  	  if(course.getStudents()!=null) {
                                  		  for(int j=0; j < course.getStudents().size(); j++) {//this for loop adds all courses registered by instructor one by one
                                  		  writer.write(course.getStudents().get(j).getId() + " ; " + course.getStudents().get(j).getName() + " ; " + course.getStudents().get(j).getGrade().getGrade());			
                                  		  }
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
      		});

        //Creates and displays PopupMenu on click
        CourseData.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent ev) {
           		
           		JPanel panel = new JPanel(new GridLayout(instructor.getCourses().size()+1,1));
           		panel.add(new JLabel("Choose a Course to Display"));
           		//Adding menu items to the popup
           		if(!(instructor.getCourses()==null)) {
           			for (int i = 0; i < instructor.getCourses().size();i++) {
           		   JButton courseButton = new JButton(instructor.getCourses().get(i).getName() + " " + instructor.getCourses().get(i).getCourseCode());
           		   
           		   final Courses course = instructor.getCourses().get(i);
           		   
           		//Display course data on menu item click
           		courseButton.addActionListener(new ActionListener() {
                   	public void actionPerformed(ActionEvent ev) {
                   		
                   		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", instructor.getName(), "ID", String.valueOf(instructor.getId()), "Department", instructor.getDept()},0);
                   		JTable courseTable = new JTable(tableModel);

                   		JScrollPane tablePane = new JScrollPane(courseTable);
                   		JPanel tablePanel = new JPanel(new GridLayout(1,1,0,0));
                   		
                   		tablePanel.add(tablePane);
                   		tableModel.addRow(new String[] {"Term", "Fall 2022","","","",""});
                   		tableModel.addRow(new String[] {"Course",course.getCourseCode(),course.getName(),"","",""});
                   		
                   		tableModel.addRow(new String[] {"ID","Name","Grade","","",""});

                   		if (course.getStudents() != null) {
                   		for (int j = 0; j < course.getStudents().size(); j ++) {
                   			
                   			for(int c = 0; c < course.getStudents().get(j).getCourses().size(); c++) {
                   				if (course.getStudents().get(j).getCourses().get(c) == course)
                       		tableModel.addRow(new String[] {String.valueOf(course.getStudents().get(j).getId()),course.getStudents().get(j).getName(),String.valueOf(course.getStudents().get(j).getGrades().get(c).getGrade()),"","",""});
                   			}
                   		}
                   		}
                   		

                   		JOptionPane.showOptionDialog(null, tablePanel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
                   				{}, null);
           		   
           		}
        	});
           		   
           		   panel.add(courseButton);
           			}
           		}
           		JOptionPane.showOptionDialog(null, panel, "Course Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
           				{}, null);           		
           		
           	}
        	});
        
        //Display the Records for the instructor on a table using JOptionPane
        DisplayRecordsBtn.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent ev) {
       		
       		DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", instructor.getName(), "ID", String.valueOf(instructor.getId()), "Department", instructor.getDept()},0);
       		JTable instructorTable = new JTable(tableModel);

       		JScrollPane tablePane = new JScrollPane(instructorTable);
       		JPanel tablePanel = new JPanel(new GridLayout(1,1,0,0));
       		

       		tableModel.addRow(new String[] {"Term", "Fall 2022"});
       		tableModel.addRow(new String[] {"Courses"});
       		tableModel.addRow(new String[] {"Name", "Number"});
       		if(!(instructor.getCourses()==null)) {
       			for (int i = 0; i < instructor.getCourses().size(); i++) {
           		
       			tableModel.addRow(new String[] {instructor.getCourses().get(i).getName(), instructor.getCourses().get(i).getCourseCode()});
       			}
       		}
    		tablePanel.add(tablePane);
       		JFrame f = new JFrame();
       		
       		
       		JOptionPane.showOptionDialog(null, tablePanel, "Instructor Data", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
       				{}, null);
       		
       		
       	}
    	});
        
   //ActionListener for Instructor Change password
   changepass.addActionListener(new ActionListener() {
   	public void actionPerformed(ActionEvent ev) {
   	 
			
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
				if (String.valueOf(oldpassField.getPassword()).equals(instructor.getPassword())
        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword())))
        		{
        			instructor.setPassword(String.valueOf(newpass1Field.getPassword()));
        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
        			System.out.println(instructor.getPassword());

        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Incorrect Old password / New Passwords");
        		}
				
			}
   	 
   	}
   	 
   	});
   
   
   //Event Handler for changename Button
   changename.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent ev) {
	   		
	   	namepanel.add(newnamelabel);
	   	namepanel.add(newnameField);
	   	
	   	int a = JOptionPane.showOptionDialog(null, namepanel, "Change Name", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
				{"Confirm", "Cancel"}, null);  

	   	if (a == JOptionPane.OK_OPTION) {
	   		if(newnameField.getText().equals("")) //Check if name is entered
				JOptionPane.showMessageDialog(null, "Please Enter a Name");
	   		else {
	   		instructor.setName(newnameField.getText());
			JOptionPane.showMessageDialog(null, "Name Changed Successfully");
	   	}
	   		
	   	}
	   		
	   	}
	   	 
  	});
   
 //EventHandler for Change Username Menu that will let Instructor change their usernames
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
 			   		instructor.setUsername(newnameField.getText());
 					JOptionPane.showMessageDialog(null, "Username Changed Successfully");
 			   		}
 			   		
 			   	}
 			}
 		});
 		
 		
 		
 		
 		//EventHandler for Change Password menu item that will let Instructor change their passwords
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
 					if (String.valueOf(oldpassField.getPassword()).equals(instructor.getPassword())
 	        				&& String.valueOf(newpass1Field.getPassword()).equals(String.valueOf(newpass2Field.getPassword())))
 	        		{
 	        			instructor.setPassword(String.valueOf(newpass1Field.getPassword()));
 	        			JOptionPane.showMessageDialog(null, "Password Changed Successfully");
 	        			System.out.println(instructor.getPassword());

 	        		}
 	        		else {
 	        			JOptionPane.showMessageDialog(null, "Incorrect Old password / New Passwords");
 	        		}
 					
 				}
 			}
 		});
 		
 		
 		//Event handler for AddCourse menuItem for the instructor to add a new course
 		AddCourse.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				
 				JPanel CoursePanel= new JPanel(new GridLayout(3,2));
 				
 				JLabel CourseNumberLabel = new JLabel("Enter Course Number");
 				JTextField CourseNumberField = new JTextField();
 				
 				JLabel CourseNameLabel = new JLabel("Enter Course Name");
 				JTextField CourseNameField = new JTextField();
 				
 				JLabel CourseCreditsLabel = new JLabel("Enter Course Credits");
 				JTextField CourseCreditsField = new JTextField();
 				
 				
 				CoursePanel.add(CourseNumberLabel);
 				CoursePanel.add(CourseNumberField);
 				CoursePanel.add(CourseNameLabel);
 				CoursePanel.add(CourseNameField);
 				CoursePanel.add(CourseCreditsLabel);
 				CoursePanel.add(CourseCreditsField);
 				
 				int a = JOptionPane.showOptionDialog(null, CoursePanel, "Add New Course", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[] 
 						{"Confirm", "Cancel"}, null);  
 						
 						
 						if (a == JOptionPane.OK_OPTION) {
 								
 							Courses tmp = new Courses();
 							try {
 							tmp.setCredits(Integer.parseInt(CourseCreditsField.getText()));
 							tmp.setDepartment(instructor.getDept());
 							tmp.setName(CourseNameField.getText());
 							tmp.setInstructor(instructor);
 							tmp.setCourseCode(instructor.getDept()+CourseNumberField.getText());
 							
 							if (instructor.getCourses().size() < 3 && !(instructor.getCourses()==null)) {
 							courses.add(tmp);
 							instructor.getCourses().add(tmp);
 							}
 							else {
 								JOptionPane.showMessageDialog(null, "Only a Maximum of 3 Courses can be Added");
 							}
 							}
 							catch(NumberFormatException e2) {
 								JOptionPane.showMessageDialog(null, "Invalid Data Entries");

 							}
 								
 						}
 				
 				
 			}
 			});
   
}
}
