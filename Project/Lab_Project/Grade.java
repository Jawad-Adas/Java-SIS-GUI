package Lab_Project;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Grade {
	String letter;
	double grade;

	public Grade() {
		this.letter = "";
		this.grade = 0;
	}
	
	public Grade(double grade) {
		this.grade = grade;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	// ex1 b

	public void roundGrade() {
		int intPart = (int) this.getGrade();
		double decimal = this.getGrade() - intPart; // or use Tokenizer and Wrapper
		if(decimal>=0.5) {
			this.setGrade(Math.ceil(this.getGrade()));
		}else {
			this.setGrade( Math.floor(this.getGrade()));
		}
		
	}
	public void computeGrade() {
		this.roundGrade();
		if(grade <=59.00){
			this.setLetter("F");
		}
		else if(grade<=69.00){
			this.setLetter("D");
		}
		else if(grade<=79.00){
			this.setLetter("C");
		}
		else if(grade <=89.00){
			this.setLetter("B");
		}
		else if(grade<=100.00){
			this.setLetter("A");
		}

	}


	@Override
	public String toString() {
		return "LetterGrade=" + letter + ", NumericValue=" + grade ;
	}



}

