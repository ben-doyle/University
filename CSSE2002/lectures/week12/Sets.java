package week12;

import java.util.*;

public class Sets {
	
	public static void main(String [ ] args){
		List<String> list = new ArrayList<String>();
		list.add("rat");
		list.add("gerbil");
		list.add("mouse");
		list.add("rat");
		list.add("mouse");
		System.out.println(list);
		System.out.println(numUnique(list));
		removeDuplicates(list);
		System.out.println(list);
		
		SortedSet<String> s = new TreeSet<String>(list);
		s.add("zebra");
		s.add("aardvark");
		s.add("monkey");
		s.add("giraffe");
		System.out.println(s);
		Set<String> s1 = s.subSet("ant", "moon");
		System.out.println(s1);
		s1.clear();
		System.out.println(s1);
		System.out.println(s);
	}
	
	public static <T> int numUnique(Collection<T> c) {
		Set<T> s = new HashSet<T>(c);
		return s.size();
	}
	
	public static void removeDuplicates(Collection<String> c) {
		//Set<String> s = new HashSet<String>(c);
		//c.clear();
		//c.addAll(s);
		Set<String> s = new HashSet<String>();
		Iterator<String> it = c.iterator();
		while (it.hasNext())
			if (! s.add(it.next())) it.remove();
	}
}
