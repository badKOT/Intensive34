package ru.aston.osipov_vv.task1.orderTypes;

import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;

import java.math.BigDecimal;

public class OutsideRingRoadOrder extends Order {
    private final Rate rate;

    public OutsideRingRoadOrder(int id, User user, BigDecimal distance, Rate rate) {
        super(id, user, distance);
        this.rate = rate;
        setCoefficient(calculateCoefficient());
        setTotal(calculateTotal());
    }

    @Override
    public void getDiscount() {
        // Скидка в 5% постоянным пользователям вне пикового времени
        if (getUser().isConstantUser() && this.rate != Rate.RUSH_HOUR)
            setCoefficient(getCoefficient().subtract(new BigDecimal("0.05")));
    }

    @Override
    public BigDecimal calculateTotal() {
        getDiscount();
        final BigDecimal MIN_COST = new BigDecimal(70);
        final BigDecimal RATIO = new BigDecimal(12);
        BigDecimal res = getDistance().multiply(RATIO).add(MIN_COST);
        res = res.multiply(getCoefficient());
        return res;
    }

    @Override
    public BigDecimal calculateCoefficient() {
        // Coefficient for daytime orders
        if (this.rate == Rate.DAY)
            return new BigDecimal("0.8");

        // Coefficient for nighttime orders
        if (this.rate == Rate.NIGHT)
            return new BigDecimal("0.9");

        // Coefficient for rush hour orders
        return new BigDecimal("1.2");
    }
}
