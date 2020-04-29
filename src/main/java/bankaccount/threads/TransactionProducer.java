package bankaccount.threads;

import bankaccount.domain.Transaction;
import bankaccount.util.Util;
import bankaccount.util.WaitingTransactions;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Logger;
public class TransactionProducer implements Runnable{
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TransactionProducer.class));
    private static AtomicInteger AT = new AtomicInteger();

    @Override
    public void run () {
        //pentru generarea tranzactiei se va folosi clasa Util si metoda generateTransaction
        //In cadrul metodei run, generam o noua tranzactie ce se va adauga in lista de waitingTransaction
        Transaction newTransaction = Util.generateTransaction();
        while(!WaitingTransactions.get().addNewTransaction(newTransaction)) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Folosind logger ul si AtomicInteger ul, afisati nr tranzactiei introduse
        //in coada si conturile.
        LOGGER.debug("In lista s-a adaugat o noua tranzactie(" + AT.incrementAndGet()+
                ") in valoare de " +
                newTransaction.getAmount()
                + " de la " +
                Util.getDebitedAccount(newTransaction) + " la " + Util.getCreditedAccount(newTransaction));

    }

}
