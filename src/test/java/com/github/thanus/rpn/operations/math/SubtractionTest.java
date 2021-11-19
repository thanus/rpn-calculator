package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.Operand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    @Test
    void operate() {
        final var stack = new Stack<Operand>();
        stack.push(new Operand(new BigDecimal(5)));
        stack.push(new Operand(new BigDecimal(2)));

        new Subtraction().operate(stack);

        assertThat(stack).hasSize(1);
        assertThat(stack.peek()).isEqualTo(new Operand(new BigDecimal(3)));
    }
}
