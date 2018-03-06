package week12;

import java.util.*;

public class Palindrome {
	
	public static void main(String[] args) {	
		List<Character> l = new LinkedList<Character>();
		String s = "A man, a plan, a canal: Panama!";
		fill(l,s);
		System.out.println(l);
		System.out.println(isPalindrome(l));
	}
	
	public static boolean isPalindrome(List<Character> l){
		ListIterator<Character> forward = l.listIterator();
		ListIterator<Character> backward = l.listIterator(l.size());
		while (forward.nextIndex() < backward.nextIndex()) {
			if (! forward.next().equals(backward.previous())) {
				return false;
			}
		}
		return true;
	}
		
	private static void fill(List<Character> l, String s) {
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				c = Character.toLowerCase(c);
				l.add(new Character(c));
			}
		}
	}

}

