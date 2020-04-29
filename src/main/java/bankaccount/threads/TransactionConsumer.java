package bankaccount.threads;

import bankaccount.domain.FailedTransactionException;
import bankaccount.domain.Transaction;
import bankaccount.util.Util;
import bankaccount.util.WaitingTransactions;
import org.apache.log4j.*;

import java.math.BigDecimal;

public class TransactionConsumer implements  Runnable {
    private static final Logger LOOGER = Logger.getLogger(TransactionConsumer.class);

    @Override
    public void run() {
        Transaction transaction = WaitingTransactions.get().next();
        if (transaction == null) {
            return;
        }
        try {
            BigDecimal amount = transaction.getAmount();
            Util.debit(transaction.getFrom(),amount);
            Util.credit(transaction.getTo(),amount);
            LOOGER.debug("S-a finalizat cu succes" + transaction);
        } catch (FailedTransactionException e) {
            WaitingTransactions.get().addFailedTransaction(transaction);
            LOOGER.debug("A cazut tranzactia" + transaction);
        }
    }
}
