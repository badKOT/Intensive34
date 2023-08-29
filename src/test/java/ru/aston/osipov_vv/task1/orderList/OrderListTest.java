package ru.aston.osipov_vv.task1.orderList;

import org.junit.jupiter.api.Test;
import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;
import ru.aston.osipov_vv.task1.orderTypes.DowntownOrder;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class OrderListTest {
    private OrderList orders;

    @Test
    void addOrder() {
        OrderList orderList = new OrderList(new ArrayList<>());
        User testUser = new User("Thomas", "Frank", 23, false);
        Order testOrder = new DowntownOrder(1, testUser, BigDecimal.TEN, Rate.NIGHT);
        orderList.addOrder(testOrder);
        assertThat(orderList.getOrders().size() == 1);
    }

    @Test
    void calculateTotalOrderValue() {
        OrderList orderList = new OrderList(new ArrayList<>());
        User testUser = new User("Thomas", "Frank", 23, false);
        Order testOrder = new DowntownOrder(1, testUser, BigDecimal.TEN, Rate.NIGHT);
        orderList.addOrder(testOrder);
        assertThat(Objects.equals(orderList.calculateTotalOrderValue(), testOrder.getTotal()));
    }

    @Test
    void sortedOrderList() {
        OrderList orderList = new OrderList(new ArrayList<>());
        User testUser = new User("Thomas", "Frank", 23, false);
        Order testOrder = new DowntownOrder(1, testUser, BigDecimal.TEN, Rate.NIGHT);
        orderList.addOrder(testOrder);
        testUser.setLastName("Crank");
        testOrder.setUser(testUser);
        orderList.addOrder(testOrder);
        assertThat(orderList.sortedOrderList().last().getId() == 1);
    }
}
/*
final int N = 8;
Random rand = new Random();
List<Order> list = new ArrayList<>();
User testUser = new User("Taylor", "Joy", 25, true);
for (int i = 0; i < N; i++) {
    double dist = (double) rand.nextInt(1000) /100;
    int ratePicker = rand.nextInt(100) % 3;
    Rate rate = (ratePicker == 0 ? Rate.DAY : (ratePicker == 1 ? Rate.NIGHT : Rate.RUSH_HOUR));
    Order testOrder = new DowntownOrder(i, testUser, BigDecimal.valueOf(dist), rate);
}
 */