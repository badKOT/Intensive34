package ru.aston.osipov_vv.task1.entities;

import ru.aston.osipov_vv.task1.discount.CostCalculation;
import ru.aston.osipov_vv.task1.discount.Discount;
import ru.aston.osipov_vv.task1.exceptions.NegativeTotalException;

import java.math.BigDecimal;

public abstract class Order implements Discount, Comparable<Order>, CostCalculation {
    private final int id;
    private final User user;
    private BigDecimal coefficient;
    private BigDecimal total;
    private BigDecimal distance;

    public Order(int id, User user, BigDecimal distance) {
        this.id = id;
        this.user = user;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getTotal() throws NegativeTotalException {
        if (this.total.signum() != 1)
            throw new NegativeTotalException(1, "Negative total");
        else
            return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", total=" + total +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return user.compareTo(o.getUser());
    }
}
