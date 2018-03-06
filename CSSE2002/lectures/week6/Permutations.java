package week6;

import java.util.ArrayList;

public class Permutations {

	public static void main(String [] args) {
		System.out.println(permutations("mezia"));
	}
	
	public static ArrayList<String> permutations(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() == 0) return result;
		if (s.length() == 1) {
			result.add(s);
			return result;
		}
		for (int i=0; i < s.length(); i++) {
			String rest = s.substring(0,i) +
						s.substring(i+1);
			ArrayList<String> list = permutations(rest);
			for (String p: list)
				result.add(s.charAt(i) + p);
		}
		return result;
	}
}
