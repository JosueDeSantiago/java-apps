package gto.talent.tech.orderprocessor.util;

import gto.talent.tech.orderprocessor.order.Order;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class QueryOrders {
    public static List<Order> queryOrdersByDay(List<Order> processedOrders, LocalDate date) {
        return processedOrders.stream()
                .filter(order -> order.getOrderDate().isEqual(date))
                .collect(Collectors.toList());
    }

    public static List<Order> queryOrdersByMonth(List<Order> processedOrders, int year, int month) {
        return processedOrders.stream()
                .filter(order -> order.getOrderDate().getYear() == year && order.getOrderDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }

    public static List<Order> queryOrdersByYear(List<Order> processedOrders, int year) {
        return processedOrders.stream()
                .filter(order -> order.getOrderDate().getYear() == year)
                .collect(Collectors.toList());
    }

    public static List<Order> queryOrdersByHourRange(List<Order> processedOrders, LocalTime start, LocalTime end) {
        return processedOrders.stream()
                .filter(order -> !order.getOrderTime().isBefore(start) && !order.getOrderTime().isAfter(end))
                .collect(Collectors.toList());
    }
}
