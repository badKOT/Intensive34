package ru.aston.osipov_vv.task5.DAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aston.osipov_vv.task4.DAO.OrderDAO;
import ru.aston.osipov_vv.task4.Entities.Order;
import ru.aston.osipov_vv.task4.Repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class OrderDAOTest {
    @Mock
    OrderDAO orderDAO;

    @InjectMocks
    OrderRepository orderRepository;

    @Test
    void findAll() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1, "First order", 150));
        orderList.add(new Order(2, "Second order", 180));

        Mockito.when(orderDAO.findAll()).thenReturn(orderList);
        Assertions.assertEquals(2, orderRepository.findAll().size());
    }

    @Test
    void findById() {
        Order order = new Order(3, "Third order", 200);
        Mockito.when(orderDAO.findById(order.getId())).thenReturn(order);
        Assertions.assertEquals("Third order",
                orderRepository.findById(order.getId()).getDescription());
    }

    @Test
    void save() {
        Order order = new Order(8, "Shein order", 5600);
        Mockito.when(orderDAO.save(order)).thenReturn(true);
        Assertions.assertTrue(orderRepository.save(order));
    }

    @Test
    void update() {
        Order test = new Order(8, "Some stuff from target", 1700);
        Mockito.when(orderDAO.update(test)).thenReturn(test);
        test.setTotal(1732);
        Assertions.assertEquals(1732, orderRepository.update(test).getTotal());
    }

    @Test
    void delete() {
        int testId = 8;
        Mockito.when(orderDAO.delete(testId)).thenReturn(true);
        Assertions.assertTrue(orderRepository.delete(testId));
    }
}