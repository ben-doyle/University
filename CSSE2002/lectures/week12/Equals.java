package week12;

import java.util.*;

// Used to show consequences of overriding equal in mutable classes. 
public class Equals {

	public static void main(String [] args) {
		HashSet<ArrayList<?>> s = 
			new HashSet<ArrayList<?>>();
		ArrayList<Object> list1 =
			new ArrayList<Object>();
		ArrayList<Object> list2 = 
			new ArrayList<Object>();
		
		list1.add("dog");
		list1.add("cat");
		list1.add("mouse");
		
		list2.add("dog");
		list2.add("cat");
		
		s.add(list1);
		s.add(list2);  
		list2.add("mouse"); // duplicate lists: list1 and list2
	
		s.remove(list1);  
		System.out.println(s.contains(list2));
		s.add(list2); 		// duplicates: list2 and list2
		list2.remove("dog");    // shows they are same list
		
		list2.add(list2);
		//s.add(list2);		// run-time error
		System.out.println(s);
	}
}
