package gto.talent.tech.processor;

import gto.talent.tech.customer.Customer;
import gto.talent.tech.transaction.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class TransactionProcessor {
    private final List<Transaction> processedTransactions = new CopyOnWriteArrayList<>();
    private final Map<Integer, Customer> customerMap = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public List<Transaction> processTransactions(List<Transaction> transactions) {
        List<Future<Boolean>> futures = new ArrayList<>();
        for (Transaction transaction : transactions) {
            futures.add(executorService.submit(() -> processTransaction(transaction)));
        }

        for (Future<Boolean> future : futures) {
            try {
                if (future.get()) {
                    System.out.println("Processed transaction successfully");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return processedTransactions;
    }

    private boolean processTransaction(Transaction transaction) {
        if (customerMap.containsKey(transaction.getCustomerId())) {
            processedTransactions.add(transaction);
            System.out.println("Transaction " + transaction.getTransactionId() + " processed successfully. Date: " + transaction.getTransactionDate() + ", Time: " + transaction.getTransactionTime());
            return true;
        } else {
            System.out.println("Transaction " + transaction.getTransactionId() + " failed due to invalid customer ID. Date: " + transaction.getTransactionDate() + ", Time: " + transaction.getTransactionTime());
            return false;
        }
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
    }
}
