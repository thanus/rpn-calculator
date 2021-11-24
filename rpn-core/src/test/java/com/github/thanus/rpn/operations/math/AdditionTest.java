package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.context.CalculatorContext;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AdditionTest {

    @Test
    void shouldAddTwoNumbers() throws CalculatorException {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(5)));
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new Addition().operate(calculatorContext, new ArrayDeque<>());

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.pop()).isEqualTo(new Operand(new BigDecimal(7)));
    }

    @Test
    void shouldFailWhenAdditionWithoutOperands() {
        assertThatThrownBy(() ->
                new Addition().operate(new CalculatorContext(), new ArrayDeque<>())
        );
    }
}
