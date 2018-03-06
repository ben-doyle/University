package week5;

/** A simple bank account. */
public class BankAccount {
	
	private int balance; // the balance
	// invariant: balance >= 0
	
	/** Create a new BankAccount.
	 * @ensure getBalance == 0
	 */
	public BankAccount() {
		balance = 0;
	}
	
	/** Return the balance of this account.
	 * @ensure \result >= 0
	 */
	public int getBalance() {
		return balance;
	}

	/** Deposit an amount into this BankAccount.
	 * @require amount >= 0
	 * @ensure 
	 *   getBalance == \old(getBalance) - amount &&
	 *   \result == getBalance
	 */
	public int deposit(int amount) {
		assert amount >= 0 :	 				
			"precondition of deposit violated";
		balance += amount;
		return balance;
	}
	
	/** Withdraw an amount from this BankAccount.
	 * @require amount >= 0 && amount <= getBalance
	 * @ensure 
	 *   getBalance == \old(getBalance) - amount &&
	 *   \result == getBalance
	 */
	public int withdraw(int amount) {
		assert amount >= 0 && amount <= balance :	 				
			"precondition of withdraw violated";
		balance -= amount; 
		return balance;
	}

}
