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

class NearMetroOrderTest {

    @Test
    void itShouldGrantDiscount() {
        User testUser = new User("Elizabeth", "Hudson", 22, true);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        Assertions.assertEquals(order.getCoefficient(), new BigDecimal("0.9"));
    }

    @Test
    void itShouldNotGrantDiscount() {
        User testUser = new User("Elizabeth", "Hudson", 22, true);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        Assertions.assertEquals(order.getCoefficient(), new BigDecimal("1.2"));
    }

    @Test
    void calculateTotal() throws NegativeTotalException {
        User testUser = new User("Elizabeth", "Hudson", 22, true);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        int testSubtotal = 2 * 20 + 80;
        Assertions.assertEquals(order.getTotal(),
                new BigDecimal(testSubtotal).multiply(new BigDecimal("0.9")));
    }

    @Test
    void calculateCoefficient() {
        User testUser = new User("Elizabeth", "Hudson", 22, false);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        Assertions.assertEquals(order.getCoefficient(), new BigDecimal("1.2"));
    }
}