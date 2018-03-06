package CSSE2002.year2014.Q5;

public class D extends A {
	/**
	 * @require str!=null && str.length() <= 5
	 * @ensure \result.length == str.length() &&
	 * 			for each index i in \result,
	 * 				\result[i] == str.charAt(i)
	 */
	public char[] getChars(String str) {
		System.out.println(str + " printed from class D method");
		return str.toCharArray();
	}
}
