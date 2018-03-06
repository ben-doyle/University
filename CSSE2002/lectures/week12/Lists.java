package week12;

import java.util.*;

public class Lists {

	public static void main(String [ ] args){
		List<Integer> aList = new ArrayList<Integer>();
		List<Integer> lList = new LinkedList<Integer>();
		fill(aList,100000);
		fill(lList,100000);
		System.out.println("ArrayList: " + operationTime(aList, 100000));
		System.out.println("LinkedList: " + operationTime(lList, 100000));
	}
	
	/** Add num random numbers between 1 and 100 to list. */
	public static void fill(List<Integer> list, int num){
		for (int i = 0; i < num; i++)
			list.add(new Integer((int)(100*Math.random()+1)));
	}
	
	/** The time (in milliseconds) to perform an operation 
	 * num times on list. 
	 */
	public static int operationTime(List<Integer> list, int num){
		double start = System.currentTimeMillis();
		Integer n;
		for (int i = 0; i < num; i++) {
			//n = list.get((int)(list.size()*Math.random()));
			n = list.remove(0);
			list.add(0,n);
		}
		return (int)(System.currentTimeMillis() - start);
	}

}
