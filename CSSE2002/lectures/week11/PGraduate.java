package week11;

import week4.Name;

public class PGraduate extends AbstractStudent {
	
	public PGraduate(Name name) {
		super(name);
	}
	
	public int getGrade() {
		int mark = getMark();
		if (mark >= 90) return 7;
		if (mark >= 80) return 6;
		if (mark >= 70) return 5;
		if (mark >= 50) return 4;
		if (mark >= 45) return 3;
		if (mark >= 20) return 2;
		return 1;
	}
	
}
