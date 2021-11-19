package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class SquareRootTest {

    @Test
    void shouldSquareRootNumber() {
        final var stack = new Stack<Operand>();
        stack.push(new Operand(new BigDecimal(2)));

        new SquareRoot().operate(stack);

        assertThat(stack).hasSize(1);
        assertThat(stack.peek().getValue().toString()).isEqualTo("1.414213562373095");
    }
}
