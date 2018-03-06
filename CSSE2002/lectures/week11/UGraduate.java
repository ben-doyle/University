package week11;

import week4.Name;

public class UGraduate extends AbstractStudent {
	
	public UGraduate(Name name) {
		super(name);
	}
	
	public int getGrade(){
		int mark = getMark();
		if (mark >= 85) return 7;
		if (mark >= 75) return 6;
		if (mark >= 65) return 5;
		if (mark >= 50) return 4;
		if (mark >= 45) return 3;
		if (mark >= 20) return 2;
		return 1;
	}	

	public int getExamMark() {
		return super.getExamMark();
	}	
}
