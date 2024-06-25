package gto.talent.tech.transaction;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private final int transactionId;
    private final int customerId;
    private final double amount;
    private LocalDate transactionDate;
    private LocalTime transactionTime;

    public Transaction(int transactionId, int customerId, double amount) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalTime.now();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", customerId=" + customerId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", transactionTime=" + transactionTime +
                '}';
    }
}
