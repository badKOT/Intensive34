package ru.aston.osipov_vv.task1.orderTypes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;
import ru.aston.osipov_vv.task1.exceptions.NegativeTotalException;

import java.math.BigDecimal;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutsideRingRoadOrderTest {

    @Test
    void itShouldGrantDiscount() {
        User testUser = new User("John", "Cooper", 27, true);
        Order order = new OutsideRingRoadOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        Assertions.assertEquals(order.getCoefficient(), new BigDecimal("0.85"));
    }

    @Test
    void itShouldNotGrantDiscount() {
        User testUser = new User("John", "Cooper", 27, true);
        Order order = new OutsideRingRoadOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        Assertions.assertEquals(order.getCoefficient(), new BigDecimal("1.2"));
    }

    @Test
    void calculateTotal() throws NegativeTotalException {
        User testUser = new User("John", "Cooper", 27, true);
        Order order = new OutsideRingRoadOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        int subtotal = 2 * 12 + 70;
        Assertions.assertEquals(order.getTotal(),
                new BigDecimal(subtotal).multiply(new BigDecimal("0.85")));
    }

    @Test
    void calculateCoefficient() {
        User testUser = new User("John", "Cooper", 27, false);
        Order order = new OutsideRingRoadOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        Assertions.assertEquals(order.getCoefficient(), new BigDecimal("1.2"));
    }
}