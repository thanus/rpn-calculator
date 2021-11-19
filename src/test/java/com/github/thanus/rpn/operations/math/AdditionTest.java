package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {

    @Test
    void shouldAddTwoNumbers() {
        final var stack = new Stack<Operand>();
        stack.push(new Operand(new BigDecimal(5)));
        stack.push(new Operand(new BigDecimal(2)));

        new Addition().operate(stack);

        assertThat(stack).hasSize(1);
        assertThat(stack.pop()).isEqualTo(new Operand(new BigDecimal(7)));
    }
}
