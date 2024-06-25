package gto.talent.tech.orderprocessor.processor;

import gto.talent.tech.orderprocessor.order.Order;

import java.util.List;

public interface Processor {
    public List<Order> processOrders(List<Order> orders);
}
