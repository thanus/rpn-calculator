package com.github.thanus.rpn;

import com.github.thanus.rpn.operations.math.SquareRoot;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorContextTest {
    final static Operand OPERAND = new Operand(BigDecimal.ONE);

    @Test
    void shouldPushOperand() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(OPERAND);

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(calculatorContext.peek()).isEqualTo(OPERAND);
    }

    @Test
    void shouldPop() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(OPERAND);

        final var pop = calculatorContext.pop();

        assertThat(calculatorContext.size()).isEqualTo(0);
        assertThat(pop).isEqualTo(OPERAND);
    }

    @Test
    void shouldPeek() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(OPERAND);

        final var pop = calculatorContext.peek();

        assertThat(calculatorContext.size()).isEqualTo(1);
        assertThat(pop).isEqualTo(OPERAND);
    }

    @Test
    void shouldClearContext() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(OPERAND);

        calculatorContext.clear();

        assertThat(calculatorContext.size()).isEqualTo(0);
    }

    @Test
    void shouldReturnSize() {
        final var calculatorContext = new CalculatorContext();

        assertThat(calculatorContext.size()).isEqualTo(0);

        calculatorContext.push(OPERAND);

        assertThat(calculatorContext.size()).isEqualTo(1);
    }

    @Test
    void shouldDisplayValueContent() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(1)));
        calculatorContext.push(new Operand(new BigDecimal(2)));
        calculatorContext.push(new Operand(new BigDecimal(3)));

        assertThat(calculatorContext.getDisplayValueContent()).isEqualTo("1 2 3");
    }

    @Test
    void shouldDisplayValueContentWithPrecision() {
        final var calculatorContext = new CalculatorContext();
        calculatorContext.push(new Operand(new BigDecimal(2)));

        new SquareRoot().operate(calculatorContext, new ArrayDeque<>());

        assertThat(calculatorContext.getDisplayValueContent()).isEqualTo("1.4142135623");
    }
}
