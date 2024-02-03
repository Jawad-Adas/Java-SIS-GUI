package Lab_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.Date;
public class DisplayData extends JFrame {

	
	Date dt = new Date();	
	JFrame frame = new JFrame();
	private JTable table;	
	String Semester=null;
	Object Data [][];
	
	public DisplayData(Students student) {
		
		//Here getMonth() method checks for the current month and depending on that it sets semester to either Spring,Fall , or Summer
		if(dt.getMonth()+1>=1 && dt.getMonth()<=5) Semester ="Spring";
		if(dt.getMonth()+1>=9 && dt.getMonth()<=12) Semester ="Fall";
		if(dt.getMonth()+1>=6 && dt.getMonth()<=8) Semester ="Summer";
		
		frame.setBounds(100, 100, 800, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		Data= new Object[student.getCourses().size()+2][6];
		Data[0][0]="Semester";
		Data[0][1]= Semester;
		Data[1][0]= "Courses";
		Data[1][1]= "Name";
		Data[1][2]= "Number";
		Data[1][3]= "Credits";
		Data[1][4]= "Grade";
			
		for(int i=0;i<student.getCourses().size();i++) {
			Data[i+2][0]= Integer.toString(i+1);
			Data[i+2][1]=student.getCourses().get(i).getName();
			Data[i+2][2]=student.getCourses().get(i).getCourseCode();
			Data[i+2][3]= student.getCourses().get(i).getCredits();
			
			Data[i+2][4]=student.getGrades().get(i).getGrade();
			Data[i+2][5]=null;
			
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Semester", Semester , null, null, null, null},
//				{"Courses", "Name", "Number", "Credits", "Grade", null},
//				{1, student.getCourses().get(0).getName(), student.getCourses().get(0).getCourseCode(), student.getCourses().get(0).getCredits(), student.getCourses().get(0).getGrade().getGrade(), null},
//				{2, student.getCourses().get(1).getName(), student.getCourses().get(1).getCourseCode(), student.getCourses().get(1).getCredits(), student.getCourses().get(1).getGrade().getGrade(), null},
//				{3, student.getCourses().get(2).getName(), student.getCourses().get(2).getCourseCode(), student.getCourses().get(2).getCredits(), student.getCourses().get(2).getGrade().getGrade(), null},
//				{4, student.getCourses().get(3).getName(), student.getCourses().get(3).getCourseCode(), student.getCourses().get(3).getCredits(), student.getCourses().get(3).getGrade().getGrade(), null},
//				{5, student.getCourses().get(4).getName(), student.getCourses().get(4).getCourseCode(), student.getCourses().get(4).getCredits(), student.getCourses().get(4).getGrade().getGrade(), null},
//				
//			}
				Data,
			new String[] {
				"Name:", student.getName(), "ID:", Integer.toString(student.getId()), "Major:", student.getMajor()
			}
		));
		scrollPane.setViewportView(table);
		
		frame.add(scrollPane);
		
		
		
	}

}
