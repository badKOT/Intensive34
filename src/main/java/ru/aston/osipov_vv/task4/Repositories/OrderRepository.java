package ru.aston.osipov_vv.task4.Repositories;

import ru.aston.osipov_vv.task4.DAO.OrderDAO;
import ru.aston.osipov_vv.task4.Entities.Order;

import java.util.List;

public class OrderRepository {
    private final OrderDAO orderDAO;

    public OrderRepository(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    public Order findById(int id) {
        return orderDAO.findById(id);
    }

    public boolean save(Order order) {
        return orderDAO.save(order);
    }

    public Order update(Order order) {
        return orderDAO.update(order);
    }

    public boolean delete(int id) {
        return orderDAO.delete(id);
    }
}
