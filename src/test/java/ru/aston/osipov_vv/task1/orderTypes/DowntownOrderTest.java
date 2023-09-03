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

class DowntownOrderTest {

    @Test
    void itShouldGrantDiscount() {
        User testUser = new User("Thomas", "Soyer", 24, true);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        Assertions.assertEquals(new BigDecimal("0.95"), order.getCoefficient());
    }

    @Test
    void isShouldNotGrantDiscount() {
        User testUser = new User("Thomas", "Soyer", 24, true);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        Assertions.assertEquals(new BigDecimal("1.3"), order.getCoefficient());
    }

    @Test
    void calculateTotal() {
        User testUser = new User("Thomas", "Soyer", 24, true);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        double subtotal = (2 * 30 + 100) * 0.95;
        Assertions.assertEquals(BigDecimal.valueOf(subtotal), order.getTotal());
    }

    @Test
    void calculateCoefficient() {
        User testUser = new User("Thomas", "Soyer", 24, false);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        Assertions.assertEquals(new BigDecimal("1.3"), order.getCoefficient());
    }

    @Test
    void itShouldCatchNegativeTotalException() {
        User testUser = new User("Thomas", "Soyer", 24, false);
        Order order = new DowntownOrder(1, testUser, new BigDecimal(-179), Rate.DAY);
        Assertions.assertEquals(BigDecimal.ONE, order.getTotal());
    }
}