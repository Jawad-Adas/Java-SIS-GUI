package Lab_Project;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
//View
public class LoginView implements ActionListener {

	//Image image = new Image(null);
		JFrame frame = new JFrame();
		JButton Login = new JButton("Login");
		JButton Reset = new JButton("Reset");
		
		JTextField userIDField = new JTextField();
		JPasswordField userPasswordField = new JPasswordField();
		JLabel userIDLabel = new JLabel("Username:");
		JLabel userPasswordLabel = new JLabel("Password:");
		JLabel messageLabel = new JLabel();
		static String Username;
		static String Password;
		
		ArrayList<Students> students;
		ArrayList<Instructor> instructors;
		ArrayList<Administrator> admin;
		ArrayList<Courses> courses;
	public LoginView(ArrayList<Students> students, ArrayList<Instructor> instructors,ArrayList<Administrator> admin_ ,ArrayList<Courses> courses) {
	
		this.instructors = instructors;
		this.students = students;
		this.courses = courses;
		this.admin=admin_;
		
//		try {
//			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("pattern.png")))));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		frame.getContentPane().setBackground(new Color(105, 102, 103));


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,600, 600);

		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		userIDLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		userPasswordLabel.setBounds(50,150,75,25);
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		Login.setBounds(125,200,100,25);
		Login.addActionListener(this);
		Reset.setBounds(225,200,100,25);
		Reset.addActionListener(this);
		Login.setFocusable(false);
		Reset.setFocusable(false);
		
		frame.getContentPane().add(userIDLabel);
		frame.getContentPane().add(userPasswordLabel);
		frame.getContentPane().add(messageLabel);		
		frame.getContentPane().add(userPasswordField);
		frame.getContentPane().add(userIDField);
		frame.getContentPane().add(Login);
		frame.getContentPane().add(Reset);
		
		JLabel lblNewLabel = new JLabel("Student Information System");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 450, 46);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean found= false;
		if(e.getSource()==Reset) {//if reset button is clicked resets text fields
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==Login) {//if login button clicked checks if username and password matches
			String userID = userIDField.getText();
			String userPassword = String.valueOf(userPasswordField.getPassword());
			
			for (int i = 0; i < instructors.size(); i++) {
				if (instructors.get(i).getUsername().equals(userID) && instructors.get(i).getPassword().equals(userPassword)) {
				new InstructorView(instructors.get(i), courses, instructors, students,admin); 
				found = true; 
		       frame.dispose();
				}			
             // when input credentials match with existing instructor credentials, new instructor frame created, login frame disposed
			}
			
			if (found == false) { //if not found in instructors
				for (int i = 0; i < students.size(); i++) {
					if (students.get(i).getUsername().equals(userID) && students.get(i).getPassword().equals(userPassword)){
						new StudentView(students.get(i), students, courses, instructors,admin); // next GUI....
						System.out.println("Student view");
						found = true;
						frame.dispose();								

					}																		
			}
			
			for (int i = 0; i < admin.size(); i++) {
				if (admin.get(i).getUsername().equals(userID) && admin.get(i).getPassword().equals(userPassword)) {
					new AdministratorView(students,instructors,courses,admin); 
					 found = true;
					frame.dispose();
				}
				
             // when input credentials match with existing instructor credentials, new instructor frame created, login frame disposed
			}
						
			if (found == false) {                
				JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                userIDField.setText("");
    			userPasswordField.setText("");         
    		}
			
			

		}
		
	}
	

}
}
