package bankaccount.domain;

import java.math.BigDecimal;

public class Transaction {
    //contul sursa
    private final Account from;
    private final Account to;
    private final TransactionType type;
    private final BigDecimal amount;

    public Transaction (Account from,Account to,TransactionType type,BigDecimal amount) {
        if (from.getIban() == null || to.getIban() == null) {
            throw new TransactionException("ibanul contului nu poate fi null");
        }
        if (from.getIban().equals(to.getIban())) {
            throw new TransactionException("Tranzactia nu poate fi executata");
        }
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public Account getFrom () {
        return from;
    }
    public Account getTo () {
        return to;
    }
    public TransactionType getType() {
        return type;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from +
                ", to=" + to +
                ", type=" + type +
                ", amount=" + amount +
                "}";
    }
}
