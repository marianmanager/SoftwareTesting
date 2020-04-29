package bankaccount.domain;

public class FailedTransactionException extends TransactionException {
    public FailedTransactionException(String message) {
        super(message);
    }
}
