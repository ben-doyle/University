package week2;

public class Term {
	
	private int coeff; 
	private int exp;
	
	public Term(int c, int n){
		coeff = c;
		exp = n;
	}
	
	public int getCoeff(){
		return coeff;
	}
	
	public int getExp(){
		return exp;
	}
	
	public String toString(){
		if (coeff == 0) return "0";
		switch (exp){
			case 0: return "" + coeff;
			case 1: return coeff + "x";
			default: return coeff + "x^" + exp;
		}
	}
}










