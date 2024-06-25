package gto.talent.tech.orderprocessor.inventory.impl;

import gto.talent.tech.orderprocessor.inventory.Inventory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentInventory implements Inventory {
    private final ConcurrentHashMap<String, AtomicInteger> stock = new ConcurrentHashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        stock.putIfAbsent(product, new AtomicInteger(0));
        stock.get(product).addAndGet(quantity);
    }

    @Override
    public boolean removeProduct(String product, int quantity) {
        AtomicInteger currentStock = stock.get(product);
        if (currentStock != null && currentStock.get() >= quantity) {
            currentStock.addAndGet(-quantity);
            return true;
        }
        return false;
    }

    @Override
    public int getStock(String product) {
        return stock.getOrDefault(product, new AtomicInteger(0)).get();
    }
}
