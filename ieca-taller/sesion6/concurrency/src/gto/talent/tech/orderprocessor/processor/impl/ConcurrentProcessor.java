package gto.talent.tech.orderprocessor.processor.impl;

import gto.talent.tech.orderprocessor.inventory.Inventory;
import gto.talent.tech.orderprocessor.order.Order;
import gto.talent.tech.orderprocessor.processor.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentProcessor implements Processor {
    private final Inventory inventory;
    private final Lock lock = new ReentrantLock();
    private final List<Order> processedOrders = new CopyOnWriteArrayList<>();

    public ConcurrentProcessor(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public List<Order> processOrders(List<Order> orders) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Boolean>> futures = new ArrayList<>();

        for (Order order : orders) {
            Future<Boolean> future = executorService.submit(()->processOrder(order));
            futures.add(future);
        }

        for (Future<Boolean> future : futures) {
            try {
                if(future.get()){
                    System.out.println("Order processed " + future.get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return processedOrders;
    }

    private boolean processOrder(Order order) {
        lock.lock();
        try{
            if(inventory.removeProduct(order.getProduct(), order.getQuantity())) {
                processedOrders.add(order);
                System.out.println("Order " + order.getOrderId() + " processed successfully. Date: " + order.getOrderDate() + ", Time: " + order.getOrderTime());
                return true;
            } else {
                System.out.println("Order " + order.getOrderId() + " failed due to insufficient stock. Date: " + order.getOrderDate() + ", Time: " + order.getOrderTime());
                return false;
            }
        }finally {
            lock.unlock();
        }
    }
}
