package bankaccount.util;

import bankaccount.domain.Transaction;

import java.util.concurrent.ConcurrentLinkedQueue;

public enum WaitingTransactions {
    INSTANCE;
    private static final int MAX = 1000;

    private ConcurrentLinkedQueue<Transaction> pool = new ConcurrentLinkedQueue<Transaction>();

    public static WaitingTransactions get() {
        return INSTANCE;
    }

    public boolean addNewTransaction(Transaction transaction) {
        boolean b = pool.size() < MAX;
        if (!b) {
            pool.notifyAll();
            return false;
        }
        return pool.add(transaction);
    }

    public void addFailedTransaction(Transaction transaction) {
        pool.add(transaction);
    }

    public Transaction next() {
        return pool.poll();
    }
}
