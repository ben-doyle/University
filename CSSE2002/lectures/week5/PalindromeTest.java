package week5;

public class PalindromeTest {

	public static void main(String[] args) {
		// test case inputs
		String[] in = { "racecar", "race", "a", "", "deed", "dead", "aa" };
		// expected outputs
		boolean[] out = { true, false, true, true, true, false, true };
		for (int i = 0; i < in.length; i++) {
			// run test
			boolean result = palindrome(in[i]);
			if (result != out[i]) {
				System.out.println("Error with input: " + in[i]
						+ "\n\tActual output: " + result
						+ "\n\tExpected ouput: " + out[i]);
			} else {
				System.out.println("Passed");
			}
		}
	}

	/**
	 * Determine whether a given string is a palindrome.
	 * 
	 * @require s != null
	 * @ensure result is true <==> for all i, 0 <= i < s.length,
	 *         s.charAt(i).equals(s.charAt(s.length-1-i))
	 */
	private static boolean palindrome(String s) {
		int low = 0; // indices of characters in s
		int high = s.length() - 1;
		while (high > low) {
			if (s.charAt(low) != s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}

}
