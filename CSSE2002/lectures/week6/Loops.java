package week6;

import java.util.*;

public class Loops {

	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(22);
		list.add(1);
		System.out.println(sum(list));
		System.out.println(min(list));
	}
	
	/** Returns the sum of the elements in a list. 
	 * @require list is not null
	 * @ensure returns the sum of values in list
	 */
	private static int sum(List<Integer> list) {
		//int result = 0;
		//for (int i=0; i < list.size(); i++) 
			/* loop invariant: result is the sum
			 * of all elements whose index is less
			 * than i
			 */
		//	result += list.get(i);
		//return result;
		if (list.size() == 0) return 0;
		return list.get(0) + 
				sum(list.subList(1,list.size()));
	}
	
	/** The minimum element in list. 
	 * @require !list.isEmpty
	 */
	private static int min(ArrayList<Integer> list) {
		//int result = list.get(0);
		//for (int i=1; i < list.size(); i++)
			/* loop invariant: result is the minimum
			 * of all elements whose index is less
			 * than i
			 */
		//	if (list.get(i) < result) 
		//		result = list.get(i);
		//return result;
		return min(list,0);
	}
	
	public static int min(ArrayList<Integer> list, int n) {
		int i = list.get(n);
		if (n == list.size()-1) return i;
		int m = min(list,n+1);
		if (m < i) return m;
		return i;
	}
}
