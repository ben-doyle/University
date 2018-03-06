package week2;

import java.util.ArrayList;

/** Represents an immutable polynomial with
 * integer coefficients. A typical Poly is
 * 5x^2 + 3x + 2.
 */
public class Poly {

	// version 1:
	// private int [] terms;

	// version 2:
	// private ArrayList<Integer> coeffs = new ArrayList<Integer>();
	// private ArrayList<Integer> exps = new ArrayList<Integer>();
	private ArrayList<Term> terms = new ArrayList<Term>();

	/** Initialises this to the zero polynomial.
	 */
	public Poly() {
		// version 1:
		// terms = new int [1];

		// version 2:
		// coeffs.add(0);
		// exps.add(0);

		// version 3:
		terms.add(new Term(0,0));
	}

	/** Initialises this to a monomial, cx^n.
	 * @param c the coefficient
	 * @param n the exponent
	 * @throws NegExponentException, if n < 0
	 */
	public Poly(int c, int n)
			throws NegExponentException{
		if (n < 0) throw new NegExponentException();
		// version 1:
		// terms = new int [n+1];
		// terms[n] = c;

		// version 2:
		// coeffs.add(c);
		// exps.add(n);

		// version 3:
		terms.add(new Term(c,n));
	}

	public String toString(){
		// version 1:
		// String s = "0";
		// for (int i=0; i < terms.length; i++) {
		// 	if (terms[i] != 0) {
		//		if (s.equals("0")) s = toString(i);
		//		else s = toString(i) " + " + s;
		// 	}
		// }

		// version 2:
		// String s = "0";
		// for (int i=0; i < coeffs.size(); i++) {
		//	if (s.equals("0")) s = toString(i);
		//	else s = toString(i) + " + " + s;
		// }

		// version 3:
		String s = "" + terms.get(0);
		for (int i=1; i < terms.size(); i++){
			s = s + " + " + terms.get(i);
		}
		return s;
	}

	// version 1:
	// public String toString(int n) {
	//	int c = terms[n];

	// version 2:
	// public String toString(int i) {
	//	int c = coeffs.get(i);
	// 	int n = exps.get(i);

	// versions 1 and 2:
	//	switch(n) {
	//		case 0: return "" + c;
	//		case 1: return c + "x";
	//		default: return c + "x^" + n;
	//	}
	// }
}
