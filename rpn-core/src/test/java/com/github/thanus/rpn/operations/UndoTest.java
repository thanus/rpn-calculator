package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.context.CalculatorContext;
import com.github.thanus.rpn.context.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

class UndoTest {

    @Test
    void shouldUndoLastOperation() throws CalculatorException {
        final var mementos = new ArrayDeque<CalculatorContextMemento<Operand>>();
        final var calculatorContext = new CalculatorContext();

        calculatorContext.push(new Operand(new BigDecimal(5)));
        mementos.push(calculatorContext.save());

        calculatorContext.push(new Operand(new BigDecimal(2)));
        mementos.push(calculatorContext.save());

        new Undo().operate(calculatorContext, mementos);

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(mementos.size()).isEqualTo(0);
        assertThat(calculatorContext.getDisplayValueContent()).isEqualTo("5");
    }

    @Test
    void shouldNotUndoWhenEmptyContext() throws CalculatorException {
        final var mementos = new ArrayDeque<CalculatorContextMemento<Operand>>();
        final var calculatorContext = new CalculatorContext();

        new Undo().operate(calculatorContext, mementos);

        assertThat(calculatorContext.size()).isEqualTo(0);
    }
}
