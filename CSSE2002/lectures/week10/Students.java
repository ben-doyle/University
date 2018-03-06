package week10;

import week4.Name;
import java.util.ArrayList;
import java.util.Collections;

public class Students {
	
	public static void main(String [] args) {
		Name n1 = new Name("Bill","Shorten");
		Name n2 = new Name("Malcolm", "Turnbull");
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(n1);
		names.add(n2);
		// Collections.sort(names);
		// System.out.println(names);
		Student s1 = new Student(n1,new UGradCalculator());
		Student s2 = new Student(n2,new PGradCalculator());
		s1.enterAssignmentMark(10,1);
		s1.enterAssignmentMark(10,2);
		s1.enterAssignmentMark(10,3);
		s1.enterExamMark(60);
		s2.enterAssignmentMark(10,1);
		s2.enterAssignmentMark(10,2);
		s2.enterAssignmentMark(10,3);
		s2.enterExamMark(45);
		
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		Collections.sort(students, new StudentByName());
		System.out.println(students);
		Collections.sort(students, new StudentByGrade());
		System.out.println(students);	
	}
}
