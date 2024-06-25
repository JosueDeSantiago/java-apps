package gto.talent.tech.orderprocessor.processor;

<<<<<<< HEAD
import gto.talent.tech.orderprocessor.order.Order;

import java.util.List;

public interface Processor {
    public List<Order> processOrders(List<Order> orders);
=======
import gto.talent.tech.orderprocessor.inventory.Inventory;
import gto.talent.tech.orderprocessor.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private final Inventory inventory;
    private final List<Order> processedOrders = new ArrayList<>();

    public Processor(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Order> processOrders(List<Order> orders) {
        for (Order order : orders) {
            processOrder(order);
        }
        return processedOrders;
    }

    private void processOrder(Order order) {
        if (inventory.removeProduct(order.getProduct(), order.getQuantity())) {
            processedOrders.add(order);
            System.out.println("Order " + order.getOrderId() + " processed successfully. Date: " + order.getOrderDate() + ", Time: " + order.getOrderTime());
        } else {
            System.out.println("Order " + order.getOrderId() + " failed due to insufficient stock. Date: " + order.getOrderDate() + ", Time: " + order.getOrderTime());
        }
    }
>>>>>>> 847b2127d600e79d0358dd47d3cccf355108ddb1
}
