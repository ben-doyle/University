package week4;

import java.util.HashSet;

public class Equals {
	
	public static void main(String [] args) {
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1 + " " + s2);
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = new StringBuilder("abc");
		System.out.println(sb1 + " " + sb2);
		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2));
		

		Name n = new Name("Larissa","Meinicke");
		Name n1 = new Name("Larissa","Meinicke");
		System.out.println(n + "\t" + n1);
		System.out.println(n.equals(n1));
		
		CaseInsensitiveName n2 = 
			new CaseInsensitiveName("Larissa","Meinicke");
		CaseInsensitiveName n3 = 
			new CaseInsensitiveName("larissa","meinicke");
		System.out.println(n2.equals(n3));
		
		// symmetry broken (before equals changed)
		System.out.println(n1.equals(n2));
		System.out.println(n2.equals(n1));
		
		// transitivity broken (after equals changed)
		System.out.println(n1.equals(n2));
		System.out.println(n2.equals(n3));
		System.out.println(n1.equals(n3));
	
		// hashCode must be overriden to prevent duplicates in set
		HashSet<Name> s = new HashSet<Name>();
		s.add(n1);
		s.add(n2);
		System.out.println(s);
	}
}
