package CSSE2002.year2014.Q5;

public class B extends A{
	/**
	 * @require obj!=null && (obj.toString()).length() <=5
	 * @ensure \result.length == (obj.toString()).length()
	 * 			&& for each index i in \result,
	 * 				\result[i] == (obj.toString()).charAt(i)
	 */
	public char[] getChars(Object obj) {
		System.out.println(obj.toString() + " printed from class B method");
		return obj.toString().toCharArray();
	}
}
