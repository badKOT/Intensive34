package ru.aston.osipov_vv.task1.orderTypes;

import org.junit.jupiter.api.Test;
import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;

import java.math.BigDecimal;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class DowntownOrderTest {

    @Test
    void itShouldGrantDiscount() {
        User testUser = new User("Thomas", "Soyer", 24, true);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        assertThat(Objects.equals(order.getCoefficient(), BigDecimal.valueOf(0.95)));
    }

    @Test
    void isShouldNotGrantDiscount() {
        User testUser = new User("Thomas", "Soyer", 24, true);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        assertThat(Objects.equals(order.getCoefficient(), BigDecimal.valueOf(1.3)));
    }

    @Test
    void calculateTotal() {
        User testUser = new User("Thomas", "Soyer", 24, true);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        double subtotal = (2 * 30 + 100) * 0.95;
        assertThat(Objects.equals(order.getTotal(), BigDecimal.valueOf(subtotal)));
    }

    @Test
    void calculateCoefficient() {
        User testUser = new User("Thomas", "Soyer", 24, false);
        Order order = new DowntownOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        assertThat(Objects.equals(order.getCoefficient(), BigDecimal.valueOf(1.3)));
    }
}