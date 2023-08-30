package ru.aston.osipov_vv.task1.discount;

import java.math.BigDecimal;

public interface CostCalculation {
    public BigDecimal calculateTotal();
    public BigDecimal calculateCoefficient();
}
