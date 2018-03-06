package CSSE2002.year2008;

import java.util.ArrayList;

/**
 * A bank account.
 */
public class Account {
    private final String accountName; // the account name
    private int balance; // the account balance
    // the history of deposits and withdrawals
    private ArrayList<Integer> trans;

    /**
     * Create a new account.
     *
     * @ensure getBalance == 0 && getTrans == []
     */
    public Account(String name) {
        accountName = name;
        balance = 0;
        trans = new ArrayList<Integer>();
    }

    /**
     * Deposit the specified amount to this Account.
     *
     * @require amount > 0
     * @ensure getBalance = old.getBalance + amount &&
     * getTrans = old.getTrans.add(amount)
     */
    public void deposit(int amount) {
        if (amount > 0) adjustBalance(amount);
    }

    /**
     * Withdraw the specified amount from this Account.
     *
     * @require amount > 0 && amount <= getBalance
     * @ensure getBalance = old.getBalance - amount &&
     * getTrans = old.getTrans.add(-amount)
     */
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) adjustBalance(-amount);
    }

    /**
     * Adjust the balance of this Account by amount.
     *
     * @ensure getBalance = old.getBalance + amount &&
     * getTrans = old.getTrans.add(amount)
     */
    protected void adjustBalance(int amount) {
        balance += amount;
        trans.add(new Integer(amount));
    }

    /**
     * The current balance of this Account.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * The transaction history of this Account (positive numbers
     * represent deposits, and negative numbers withdrawals).
     */
    public ArrayList<Integer> getTrans() {
        return trans;
    }

    public String toString() {
        return accountName + " : " + balance;
    }
}
