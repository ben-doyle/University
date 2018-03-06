package week10;

import java.util.Comparator;

public class StudentByGrade implements Comparator<Student> {	
	
	public int compare(Student s1, Student s2) {
		Integer g2 = s2.getGrade();
		return g2.compareTo(s1.getGrade());
	}
}
