package com.github.thanus.rpn;

import lombok.Value;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Value
public class Operand {

    private static final MathContext MATH_CONTEXT = MathContext.DECIMAL64;

    BigDecimal value;

    public Operand(String value) {
        this.value = new BigDecimal(value);
    }

    public Operand(BigDecimal value) {
        this.value = value;
    }

    public static boolean isNumber(String number) {
        try {
            new BigDecimal(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public BigDecimal getValue() {
        return value;
    }

    public Operand add(Operand operand) {
        return new Operand(value.add(operand.getValue()));
    }

    public Operand subtract(Operand operand) {
        return new Operand(value.subtract(operand.getValue()));
    }

    public Operand multiply(Operand operand) {
        return new Operand(value.multiply(operand.getValue()));
    }

    public Operand divide(Operand operand) {
        return new Operand(value.divide(operand.getValue(), MATH_CONTEXT));
    }

    public Operand sqrt() {
        return new Operand(value.sqrt(MATH_CONTEXT));
    }

    public String getDisplayValue() {
        return value.setScale(10, RoundingMode.FLOOR).stripTrailingZeros().toPlainString();
    }

}
