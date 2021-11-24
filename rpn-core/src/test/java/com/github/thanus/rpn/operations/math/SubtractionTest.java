package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.context.CalculatorContext;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SubtractionTest {

    @Test
    void operate() throws CalculatorException {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(5)));
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new Subtraction().operate(calculatorContext, new ArrayDeque<>());

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.peek()).isEqualTo(new Operand(new BigDecimal(3)));
    }

    @Test
    void shouldFailWhenSubtractionWithoutOperands() {
        assertThatThrownBy(() ->
                new Subtraction().operate(new CalculatorContext(), new ArrayDeque<>())
        );
    }
}
