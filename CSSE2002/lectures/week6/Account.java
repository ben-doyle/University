package week6;

/** A bank account. */
public class Account {

	// minimum allowed balance
	private final static int MIN_BALANCE = 100;

	private int balance;       // the balance
	private int deposits;      // total deposits
	private int withdrawals;   // total withdrawals
	/*@ invariant balance >= MIN_BALANCE && MIN_BALANCE == 100 &&
     			  balance == deposits - withdrawals && deposits >= 0 &&
     			  withdrawals >= 0 && getBalance() == balance;
      @*/

	/** Open new bank account. */
	/*@ requires initialAmount >= minBalance();
	    ensures getBalance() == initialAmount;
  	  @*/
	public Account(int initialAmount) {
		balance = initialAmount;
		deposits = initialAmount;
		withdrawals = 0;
	}	

	/** Return the minimum allowed balance of this account. */
	/*@ pure
	 	ensures \result == MIN_BALANCE;
	  @*/
	public int minBalance() {
		return MIN_BALANCE;
	}

	/** Return the balance of this account. */
	/*@ pure
	 	ensures \result == balance;
	  @*/
	public int getBalance() {
		return balance;
	}



	/** Withdraw an amount from this account.
	 * @param amount The amount to withdraw
	 */
	/*@ requires amount >= 0 && getBalance()-amount >= minBalance();
		ensures getBalance() == \old(getBalance()) - amount;
	  @*/
	public void withdraw(int amount) {
		update(-amount);
		withdrawals += amount;
	}

	
	
	/** Update this account by an amount which may be positive or
	 * negative.
	 * @param The amount
	 */
	 /*@ modifies balance;
	     ensures getBalance() == \old(getBalance()) + amount;
	     helper 
	   @*/
	private void update(int amount) {
		balance += amount;
	}

}
