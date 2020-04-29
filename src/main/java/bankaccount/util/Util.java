package bankaccount.util;

import bankaccount.domain.Account;
import bankaccount.domain.FailedTransactionException;
import bankaccount.domain.Transaction;
import bankaccount.domain.TransactionType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Util {
    private static final int AMMOUNT_INTERVAL = 1000;
    private static final int ACCOUNT_NO = 10;
    private static Map<Integer, Account> accountMap = new HashMap<>();

    public static void debit (Account account, BigDecimal amount) {
        BigDecimal add = account.getAmount().add(amount.negate());
        if (add.compareTo(BigDecimal.ZERO) >= 0) {
            account.setAmount(add);
        } else {
            throw new FailedTransactionException("Fonduri insuficiente pentru " + account);
        }
    }
    public static void credit (Account account,BigDecimal amount) {
        account.setAmount(account.getAmount().add(amount));
    }
    public static Account getDebitedAccount(Transaction transaction) {
        return transaction.getType() == TransactionType.DEBIT ? transaction.getFrom() : transaction.getTo();
    }
    public static Account getCreditedAccount(Transaction transaction) {
        return transaction.getType() == TransactionType.CREDIT ? transaction.getFrom() : transaction.getTo();
    }

    public static Account getOrCreateAccount(Integer id, Integer amount) {
        Account ret;
        if (accountMap.containsKey(id)) {
            ret = accountMap.get(id);
        } else {
            ret = new Account(
                    "ro" + id, BigDecimal.valueOf(amount)
            );
            accountMap.put(id,ret);
        }
        return ret;
    }

    public static Transaction generateTransaction () {
        Random random = new Random();

        int fromAccount = random.nextInt(ACCOUNT_NO);
        int toAccount = random.nextInt(ACCOUNT_NO);
        int transactionAmmount = random.nextInt(AMMOUNT_INTERVAL) + AMMOUNT_INTERVAL / 2;
        int transactionAccountFrom = random.nextInt(AMMOUNT_INTERVAL) + AMMOUNT_INTERVAL;
        int transactionAccountTo = random.nextInt(AMMOUNT_INTERVAL) + AMMOUNT_INTERVAL;
        while (fromAccount == toAccount) {
            toAccount = random.nextInt(ACCOUNT_NO);
        }

        Account account1 = getCreditedAccount(fromAccount, transactionAccountFrom);
        Account account2 = getCreditedAccount(toAccount, transactionAccountTo);

        return new Transaction(
                account1, account2, TransactionType.DEBIT, BigDecimal.valueOf(transactionAmmount)
                );
    }

    private static Account getCreditedAccount(int fromAccount, int transactionAccountFrom) {
        return null;
    }

}
