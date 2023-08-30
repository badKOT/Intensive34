package ru.aston.osipov_vv.task1.orderList;

import ru.aston.osipov_vv.task1.entities.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class OrderList {
    private ArrayList<Order> orders;

    public OrderList(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public BigDecimal calculateTotalOrderValue() {
        BigDecimal res = BigDecimal.ZERO;
        for (Order order : orders)
            res = res.add(order.getTotal());
        return res;
    }

    public SortedSet<Order> sortedOrderList() {
        return new TreeSet<Order>(orders);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
