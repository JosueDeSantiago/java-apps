package gto.talent.tech.orderprocessor;

import gto.talent.tech.orderprocessor.inventory.Inventory;
import gto.talent.tech.orderprocessor.inventory.impl.ConcurrentInventory;
import gto.talent.tech.orderprocessor.inventory.impl.SingleInventory;
import gto.talent.tech.orderprocessor.order.Order;
import gto.talent.tech.orderprocessor.processor.Processor;
import gto.talent.tech.orderprocessor.processor.impl.ConcurrentProcessor;
import gto.talent.tech.orderprocessor.processor.impl.SingleProcessor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static gto.talent.tech.orderprocessor.util.QueryOrders.*;

public class OrdersProcessorApplication {
    public static void main(String[] args) {
        System.out.println("processing orders");

        Inventory singleInventory = new SingleInventory();
        Processor singleProcessor = new SingleProcessor(singleInventory);

        Inventory concurrentInventory = new ConcurrentInventory();
        Processor concurrentProcessor = new ConcurrentProcessor(concurrentInventory);
        queryOrders(populateOrders(concurrentInventory,concurrentProcessor));

        //queryOrders(populateOrders(singleInventory, singleProcessor));
        System.out.println("final stock product 1 " + concurrentInventory.getStock("Product1"));
        System.out.println("final stock product 2 " + concurrentInventory.getStock("Product2"));
    }

    private static List<Order> populateOrders(Inventory inventory, Processor processor){
        inventory.addProduct("Product1", 1000);
        inventory.addProduct("Product2", 500);

        System.out.println("initial stock product 1: " + inventory.getStock("Product1"));
        System.out.println("initial stock product 2: " + inventory.getStock("Product2"));

        List<Order> orders = new ArrayList<>(List.of(
                new Order(1, "Product1", 30),
                new Order(2, "Product2", 20),
                new Order(3, "Product1", 50),
                new Order(4, "Product1", 30),
                new Order(5, "Product2", 10)
        ));

        // Add some orders with older dates and times
        Order oldOrder1 = new Order(6, "Product1", 20);
        oldOrder1.setOrderDate(LocalDate.of(2023, 1, 15));
        oldOrder1.setOrderTime(LocalTime.of(14, 30));

        Order oldOrder2 = new Order(7, "Product2", 15);
        oldOrder2.setOrderDate(LocalDate.of(2023, 5, 20));
        oldOrder2.setOrderTime(LocalTime.of(9, 45));

        Order oldOrder3 = new Order(8, "Product1", 10);
        oldOrder3.setOrderDate(LocalDate.of(2022, 11, 10));
        oldOrder3.setOrderTime(LocalTime.of(16, 15));

        orders.add(oldOrder1);
        orders.add(oldOrder2);
        orders.add(oldOrder3);

        return processor.processOrders(orders);
    }

    private static void queryOrders(List<Order> orders){
        LocalDate today = LocalDate.now();
        System.out.println("Orders today: " + queryOrdersByDay(orders, today));

        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        System.out.println("Orders this month: " + queryOrdersByMonth(orders, currentYear, currentMonth));

        System.out.println("Orders on 2023-01-15: " + queryOrdersByDay(orders, LocalDate.of(2023, 1, 15)));
        System.out.println("Orders in May 2023: " + queryOrdersByMonth(orders, 2023, 5));
        System.out.println("Orders in 2022: " + queryOrdersByYear(orders, 2022));
        System.out.println("Orders between 09:00 and 10:00: " + queryOrdersByHourRange(orders, LocalTime.of(9, 0), LocalTime.of(10, 0)));

        LocalTime start = LocalTime.of(0, 0);
        LocalTime end = LocalTime.of(23, 59);
    }
}
