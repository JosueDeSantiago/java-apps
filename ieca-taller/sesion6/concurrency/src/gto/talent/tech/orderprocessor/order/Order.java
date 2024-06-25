package gto.talent.tech.orderprocessor.order;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Order {
    private final int orderId;
    private final String product;
    private final int quantity;
    private LocalDate orderDate;
    private LocalTime orderTime;

    public Order(int orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = LocalDate.now();
        this.orderTime = LocalTime.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                '}';
    }
}
