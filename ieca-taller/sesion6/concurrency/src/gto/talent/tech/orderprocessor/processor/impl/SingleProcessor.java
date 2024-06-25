package gto.talent.tech.orderprocessor.processor.impl;

import gto.talent.tech.orderprocessor.inventory.Inventory;
import gto.talent.tech.orderprocessor.order.Order;
import gto.talent.tech.orderprocessor.processor.Processor;

import java.util.ArrayList;
import java.util.List;

public class SingleProcessor implements Processor {
    private final Inventory inventory;
    private final List<Order> processedOrders = new ArrayList<>();

    public SingleProcessor(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
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
}
