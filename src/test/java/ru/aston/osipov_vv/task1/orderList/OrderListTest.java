package ru.aston.osipov_vv.task1.orderList;

import org.junit.jupiter.api.*;
import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;
import ru.aston.osipov_vv.task1.exceptions.NegativeTotalException;
import ru.aston.osipov_vv.task1.orderTypes.DowntownOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

class OrderListTest {
    private OrderList orders;

    @Test
    void addOrder() {
        OrderList orderList = new OrderList(new ArrayList<>());
        User testUser = new User("Thomas", "Frank", 23, false);
        Order testOrder = new DowntownOrder(1, testUser, BigDecimal.TEN, Rate.NIGHT);
        orderList.addOrder(testOrder);
        Assertions.assertEquals(1, orderList.getOrders().size());
    }

    @Test
    void calculateTotalOrderValue() throws NegativeTotalException {
        OrderList orderList = new OrderList(new ArrayList<>());
        User testUser = new User("Thomas", "Frank", 23, false);
        Order testOrder = new DowntownOrder(1, testUser, BigDecimal.TEN, Rate.NIGHT);
        orderList.addOrder(testOrder);
        Assertions.assertEquals(orderList.calculateTotalOrderValue(), testOrder.getTotal());
    }

    @Test
    void sortedOrderList() {
        OrderList orderList = new OrderList(new ArrayList<>());
        User testUser = new User("Thomas", "Frank", 23, false);
        Order testOrder = new DowntownOrder(1, testUser, BigDecimal.TEN, Rate.NIGHT);
        orderList.addOrder(testOrder);
        testUser.setLastName("Crank");
        orderList.addOrder(testOrder);
        Assertions.assertEquals(1, orderList.sortedOrderList().last().getId());
    }
}