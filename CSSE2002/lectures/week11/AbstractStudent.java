package week11;

import week4.Name;

/** A student. */
public abstract class AbstractStudent implements Student {
	
	protected Name name; // the student's name
	private int [] marks; // the student's marks

	/** Create a new Student with the given name. 
	 * @require name != null
	 * @ensure getName == name && getMark == 0
	 */
	public AbstractStudent(Name name) {
		this.name = name;
		marks = new int [4];
	}
	
	protected int getExamMark() {
		return marks[0];
	}
	
	public void enterAssignmentMark(int mark, int number) {
		marks[number] = mark;
	}

	public void enterExamMark(int mark) {
		marks[0] = mark;
	}

	public Name getName() {
		return name;
	}

	/** The sum of the assignmnent and exam marks for this Student. 
	 * @ensure  0 < \result && \result <= 100
	 */
	public int getMark() {
		int result = 0;
		for (int i=0; i < marks.length; i++) 
			result += marks[i];
		return result;
	}
	
	public abstract int getGrade();

	public String toString() {
		return name + ": " + getGrade();
	}
	
}
