package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.context.CalculatorContext;
import com.github.thanus.rpn.context.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

class ClearTest {

    @Test
    void shouldClearCalculatorContext() throws CalculatorException {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(5)));
        calculatorContext.push(new Operand(new BigDecimal(2)));

        final var mementos = new ArrayDeque<CalculatorContextMemento<Operand>>();
        new Clear().operate(calculatorContext, mementos);

        assertThat(calculatorContext.size()).isEqualTo(0);
        assertThat(mementos.size()).isEqualTo(0);
    }
}
