package week10;

import week4.Name;

/** A student. */
public class Student {
	
	private Name name; // the student's name
	private int [] marks; // the student's marks 
	private GradeCalculator gc;
	
	/** Create a new Student with the given name. 
	 * @require name != null
	 * @ensure getName == name && getMark == 0
	 */
	public Student(Name name, GradeCalculator gc){
		this.name = name;
		marks = new int [4];
		this.gc = gc;
	}
	
	/** Enter the given mark out of 10 for the 
	 * given assignment. 
	 * @require  1 <= number && number <= 3 && 
	 *           0 <= mark && mark <= 10
	 * @ensure getMark >= mark
	 */
	public void enterAssignmentMark(int mark, int number) {
		marks[number] = mark;
	}
	
	/** Enter the given mark out of 70 for the exam.
	 * @require  0 <= mark && mark <= 70
	 * @ensure getMark >= mark
	 */
	public void enterExamMark(int mark) {
		marks[0] = mark;
	}
	
	/** The name of this Student. 
	 * @ensure \result != null
	 */
	public Name getName(){
		return name;
	}
	
	/** The total mark out of 100 for this Student. 
	 * @ensure  0 < \result && \result <= 100
	 */
	public int getMark() {
		int result = 0;
		for (int i=0; i < marks.length; i++) 
			result += marks[i];
		return result;
	}
	
	/** The grade out of 7 for this Student. 
	 * @ensure  1 <= \result && \result <= 7
	 */
	public int getGrade(){
		return gc.calculateGrade(getMark());
	}

	public String toString(){
		return name + ": " + getGrade();
	}

}
