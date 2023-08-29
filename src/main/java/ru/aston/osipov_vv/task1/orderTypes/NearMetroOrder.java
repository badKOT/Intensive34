package ru.aston.osipov_vv.task1.orderTypes;

import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;

import java.math.BigDecimal;

public class NearMetroOrder extends Order {
    private final Rate rate;

//    public NearMetroOrder(Rate rate) {
//        this.rate = rate;
//    }

    public NearMetroOrder(int id, User user, BigDecimal distance, Rate rate) {
        super(id, user, distance);
        this.rate = rate;
        setCoefficient(calculateCoefficient());
        setTotal(calculateTotal());
    }

    @Override
    public void getDiscount() {
        // Скидка в 5% постоянным пользователям вне пикового времени
        if (this.getUser().isConstantUser() && this.rate != Rate.RUSH_HOUR)
            setCoefficient(getCoefficient().subtract(BigDecimal.valueOf(0.05)));
    }

    @Override
    public BigDecimal calculateTotal() {
        getDiscount();
        final BigDecimal minCost = BigDecimal.valueOf(80);
        BigDecimal res = getDistance().multiply(BigDecimal.valueOf(3)).add(minCost);
        res = res.multiply(getCoefficient());
        return res;
    }

    @Override
    public BigDecimal calculateCoefficient() {
        // Coefficient for daytime orders
        if (this.rate == Rate.DAY)
            return BigDecimal.valueOf(0.85);

        // Coefficient for nighttime orders
        if (this.rate == Rate.NIGHT)
            return BigDecimal.valueOf(0.95);

        // Coefficient for rush hour orders
        return BigDecimal.valueOf(1.2);
    }
}
