package ru.aston.osipov_vv.task1.orderTypes;

import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;
import ru.aston.osipov_vv.task1.exceptions.NegativeCoefficientException;
import ru.aston.osipov_vv.task1.exceptions.NegativeTotalException;

import java.math.BigDecimal;

public class NearMetroOrder extends Order {
    private final Rate rate;

    public NearMetroOrder(int id, User user, BigDecimal distance, Rate rate) {
        super(id, user, distance);
        this.rate = rate;
        setCoefficient(calculateCoefficient());
        try {
            setTotal(calculateTotal());
            if (getTotal().signum() != 1) throw new NegativeTotalException("Negative total");
        } catch (NegativeTotalException e) {
            System.out.println(e.getMessage());
            System.out.println("New total = 1.");
            setTotal(BigDecimal.ONE);
        }
    }

    @Override
    public void getDiscount() {
        // Скидка в 5% постоянным пользователям вне пикового времени
        if (getUser().isConstantUser() && this.rate != Rate.RUSH_HOUR) {
            BigDecimal dec = getCoefficient();
            try {
                setCoefficient(dec.subtract(new BigDecimal("0.05")));
                if (getCoefficient().signum() != 1) throw new NegativeCoefficientException("Negative coefficient");
            } catch (NegativeCoefficientException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public BigDecimal calculateTotal() {
        getDiscount();
        final BigDecimal MIN_COST = new BigDecimal(80);
        final BigDecimal RATIO = new BigDecimal(20);
        BigDecimal res = getDistance().multiply(RATIO).add(MIN_COST);
        res = res.multiply(getCoefficient());
        return res;
    }

    @Override
    public BigDecimal calculateCoefficient() {
        // Coefficient for daytime orders
        if (this.rate == Rate.DAY)
            return new BigDecimal("0.85");

        // Coefficient for nighttime orders
        if (this.rate == Rate.NIGHT)
            return new BigDecimal("0.95");

        // Coefficient for rush hour orders
        return new BigDecimal("1.2");
    }
}
