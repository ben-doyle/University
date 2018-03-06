package CSSE2002.year2014.Q5;

public class C extends A {
	/**
	 * require str!=null
	 * @ensure (\result.length ==
	 * 			(the minimum of str.length() and 10)) &&
	 * 			for each index i in \result,
	 * 			\result[i] == str.charAt(i)
	 */
	public char[] getChars(String str) {
		System.out.println(str + " printed from class C method");
		return str.toCharArray();
	}
}
