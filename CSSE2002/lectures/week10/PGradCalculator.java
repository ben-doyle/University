package week10;

public class PGradCalculator implements GradeCalculator {
	
	public int calculateGrade(int mark) {
		if (mark >= 90) return 7;
		if (mark >= 80) return 6;
		if (mark >= 70) return 5;
		if (mark >= 50) return 4;
		if (mark >= 45) return 3;
		if (mark >= 20) return 2;
		return 1;
	}
	
}
