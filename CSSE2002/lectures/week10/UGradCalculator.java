package week10;

public class UGradCalculator implements GradeCalculator {

	public int calculateGrade(int mark) {
		if (mark >= 85) return 7;
		if (mark >= 75) return 6;
		if (mark >= 65) return 5;
		if (mark >= 50) return 4;
		if (mark >= 45) return 3;
		if (mark >= 20) return 2;
		return 1;
	}
}
