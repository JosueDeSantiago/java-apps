package gto.talent.tech;

import gto.talent.tech.customer.Customer;
import gto.talent.tech.processor.TransactionProcessor;
import gto.talent.tech.transaction.Transaction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionProcessorApplication {
    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();

        Customer customer1 = new Customer(1, "Alice", "alice@example.com");
        Customer customer2 = new Customer(2, "Bob", "bob@example.com");

        processor.addCustomer(customer1);
        processor.addCustomer(customer2);

        List<Transaction> transactions = List.of(
                new Transaction(1, 1, 100.0),
                new Transaction(2, 2, 200.0),
                new Transaction(3, 1, 50.0),
                new Transaction(4, 2, 150.0),
                new Transaction(5, 1, 300.0)
        );

        // Add some transactions with older dates and times
        Transaction oldTransaction1 = new Transaction(6, 1, 75.0);
        oldTransaction1.setTransactionDate(LocalDate.of(2023, 1, 15));
        oldTransaction1.setTransactionTime(LocalTime.of(14, 30));

        Transaction oldTransaction2 = new Transaction(7, 2, 125.0);
        oldTransaction2.setTransactionDate(LocalDate.of(2023, 5, 20));
        oldTransaction2.setTransactionTime(LocalTime.of(9, 45));

        Transaction oldTransaction3 = new Transaction(8, 1, 200.0);
        oldTransaction3.setTransactionDate(LocalDate.of(2022, 11, 10));
        oldTransaction3.setTransactionTime(LocalTime.of(16, 15));

        List<Transaction> allTransactions = new ArrayList<>(transactions);
        allTransactions.add(oldTransaction1);
        allTransactions.add(oldTransaction2);
        allTransactions.add(oldTransaction3);

        processor.processTransactions(allTransactions).forEach(System.out::println);
    }
}
