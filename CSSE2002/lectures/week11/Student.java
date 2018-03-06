package week11;

import week4.Name;

/** A student. */
public interface Student {
	
	/** Enter the given mark out of 10 for the 
	 * given assignment. 
	 * @require  1 <= number && number <= 3 && 
	 *           0 <= mark && mark <= 10
	 * @ensure getMark >= mark
	 */
	public void enterAssignmentMark(int mark, int number);
	
	/** Enter the given mark out of 70 for the exam.
	 * @require  0 <= mark && mark <= 70
	 * @ensure getMark >= mark
	 */
	public void enterExamMark(int mark);
	
	/** The name of this Student. 
	 * @ensure \result != null
	 */
	public Name getName();
	
	/** The total mark out of 100 for this Student. 
	 * @ensure  0 < \result && \result <= 100
	 */
	public int getMark();
	
	/** The grade out of 7 for this Student. 
	 * @ensure  1 <= \result && \result <= 7
	 */
	public int getGrade();

}
