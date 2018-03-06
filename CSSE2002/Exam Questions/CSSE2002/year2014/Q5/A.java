package CSSE2002.year2014.Q5;

public class A {
	/**
	 * @require str!=null && str.length() <=10
	 *
	 * @ensure \result.length == str.length()
	 * 			&& for each index i in \result,
	 * 			\result[i] == str.charAt(i)
	 */
	public char[] getChars(String str) {
		System.out.println(str + " printed from class A method");
		return str.toCharArray();
	}




}




