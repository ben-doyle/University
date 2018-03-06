package CSSE2002.year2008;

import java.util.HashSet;
import java.util.Iterator;

/**
 * A bank.
 */
public class Bank {
    // the bank’s accounts
    HashSet<Account> accounts = new HashSet<Account>();
    // other methods

    /**
     * An iterator which returns (exactly once) all credit accounts
     * of this Bank with a limit greater than or equal to the
     * specified limit.
     */
    public Iterator<CreditAccount> bankIterator(int limit) {
        return new BankIterator(limit);
    }

    private class BankIterator implements Iterator<CreditAccount> {
        int limit;
        Iterator<Account> it;
        CreditAccount c;

        public BankIterator(int limit) {
            this.limit = limit;
            it = accounts.iterator();
            nextCreditAccount();
        }

        public boolean hasNext() {
            return (c != null);
        }

        public CreditAccount next() {
            CreditAccount next = c;
            nextCreditAccount();
            return next;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void nextCreditAccount() {
            c = null;
            while (it.hasNext() && c == null) {
                Account a = it.next();
                if (a instanceof CreditAccount &&
                        ((CreditAccount) a).getLimit() >= limit)
                    c = (CreditAccount) a;
            }
        }
    }

}