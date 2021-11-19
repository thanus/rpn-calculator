package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.Operand;
import com.github.thanus.rpn.operations.Operation;

import java.util.Stack;

public class Subtraction extends Operation {
    @Override
    public void operate(Stack<Operand> stack) {
        final var secondOperand = stack.pop();
        final var firstOperand = stack.pop();

        stack.push(firstOperand.subtract(secondOperand));
    }
}
