package week2;

/** Thrown when an attempt is made to create a Poly with a negative exponent.
 */
public class NegExponentException extends RuntimeException {
	
	/** Constructs an NegExponentException with no detailed message. 
	 */
	public NegExponentException(){
		super();
	}
	
	/** Constructs an NegExponentException with the specified detail message. 
	 * @param s the detailed message
	 */ 
	public NegExponentException(String s){
		super(s);
	}
}
