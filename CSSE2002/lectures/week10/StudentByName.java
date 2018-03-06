package week10;

import java.util.Comparator;

public class StudentByName implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}

