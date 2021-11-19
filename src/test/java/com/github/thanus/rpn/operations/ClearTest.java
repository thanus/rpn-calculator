package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class ClearTest {

    @Test
    void shouldClearStack() {
        final var stack = new Stack<Operand>();
        stack.push(new Operand(new BigDecimal(5)));
        stack.push(new Operand(new BigDecimal(2)));

        new Clear().operate(stack);

        assertThat(stack).hasSize(0);
    }
}
