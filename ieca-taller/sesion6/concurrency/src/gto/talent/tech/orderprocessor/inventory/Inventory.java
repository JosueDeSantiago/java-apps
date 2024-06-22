package gto.talent.tech.orderprocessor.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> stock = new HashMap<>();

    public void addProduct(String product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    public boolean removeProduct(String product, int quantity) {
        Integer currentStock = stock.get(product);
        if (currentStock != null && currentStock >= quantity) {
            stock.put(product, currentStock - quantity);
            return true;
        }
        return false;
    }

    public int getStock(String product) {
        return stock.getOrDefault(product, 0);
    }
}
