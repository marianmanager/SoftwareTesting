package bankaccount.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    //ibanul contului
    private String iban;
    //suma contului
    private BigDecimal amount;

    public Account(String iban , BigDecimal amount) {
        this.amount = amount;
        this.iban = iban;
    }

    public String getIban () {
        return  iban;
    }
    public void setIban (String iban) {
        this.iban = iban;
    }
    public BigDecimal getAmount () {
        return  amount;
    }
    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return  false;
        Account account = (Account) o;
        return Objects.equals(iban,account.iban);

    }

    @Override
    public String toString() {
        return "Account{" +
                "iban=" + iban + '\'' +
                "amount=" + amount +
                '}';
    }
}
