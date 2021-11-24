package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.context.CalculatorContext;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DivisionTest {

    @Test
    void shouldDivideTwoNumbers() throws CalculatorException {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(12)));
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new Division().operate(calculatorContext, new ArrayDeque<>());

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.peek()).isEqualTo(new Operand(new BigDecimal(6)));
    }

    @Test
    void shouldFailWhenDivisionWithoutOperands() {
        assertThatThrownBy(() ->
                new Division().operate(new CalculatorContext(), new ArrayDeque<>())
        );
    }
}
