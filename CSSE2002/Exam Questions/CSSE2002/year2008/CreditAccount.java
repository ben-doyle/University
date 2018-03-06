package CSSE2002.year2008;

import CSSE2002.year2008.Account;

/**
 * A bank account which may be overdrawn up to a given limit.
 */
public class CreditAccount extends Account {
    private final int limit; // the credit limit

    /**
     * Create a new credit account.
     *
     * @ensure getBalance == 0 && getTrans == []
     */
    public CreditAccount(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    /**
     * Repay the specified amount to this CreditAccount.
     *
     * @require amount > 0 && getBalance + amount <= 0
     * @ensure getBalance = old.getBalance + amount &&
     * getTrans = old.getTrans.add(amount)
     */
    public void deposit(int amount) {
        if (amount > 0 && getBalance() + amount <= 0)
            adjustBalance(amount);
    }

    /**
     * Withdraw the specified amount from this CreditAccount.
     *
     * @require amount > 0 && amount <= getBalance + limit
     * @ensure getBalance = old.getBalance - amount &&
     * getTrans = old.getTrans.add(-amount)
     */
    public void withdraw(int amount) {
        if (amount > 0 && amount <= getBalance() + limit)
            adjustBalance(amount);
    }

    /**
     * The limit of this CreditAccount.
     */
    public int getLimit() {
        return limit;
    }
}
