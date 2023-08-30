package ru.aston.osipov_vv.task1.orderTypes;

import org.junit.jupiter.api.Test;
import ru.aston.osipov_vv.task1.entities.Order;
import ru.aston.osipov_vv.task1.entities.Rate;
import ru.aston.osipov_vv.task1.entities.User;

import java.math.BigDecimal;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NearMetroOrderTest {

    @Test
    void itShouldGrantDiscount() {
        User testUser = new User("Elizabeth", "Hudson", 22, true);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        assertThat(Objects.equals(order.getCoefficient(), BigDecimal.valueOf(0.9)));
    }

    @Test
    void itShouldNotGrantDiscount() {
        User testUser = new User("Elizabeth", "Hudson", 22, true);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        assertThat(Objects.equals(order.getCoefficient(), BigDecimal.valueOf(1.2)));
    }

    @Test
    void calculateTotal() {
        User testUser = new User("Elizabeth", "Hudson", 22, true);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.NIGHT);
        double subtotal = (2 * 20 + 80) * 0.9;
        assertThat(Objects.equals(order.getTotal(), BigDecimal.valueOf(subtotal)));
    }

    @Test
    void calculateCoefficient() {
        User testUser = new User("Elizabeth", "Hudson", 22, false);
        Order order = new NearMetroOrder(1, testUser, BigDecimal.TWO, Rate.RUSH_HOUR);
        assertThat(Objects.equals(order.getCoefficient(), BigDecimal.valueOf(1.2)));
    }
}