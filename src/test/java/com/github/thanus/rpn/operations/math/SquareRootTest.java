package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SquareRootTest {

    @Test
    void shouldSquareRootNumber() throws CalculatorException {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new SquareRoot().operate(calculatorContext, new ArrayDeque<>());

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.peek().getValue().toString()).isEqualTo("1.414213562373095");
    }

    @Test
    void shouldFailWhenSquareRootWithoutOperands() {
        assertThatThrownBy(() ->
                new SquareRoot().operate(new CalculatorContext(), new ArrayDeque<>())
        );
    }
}
