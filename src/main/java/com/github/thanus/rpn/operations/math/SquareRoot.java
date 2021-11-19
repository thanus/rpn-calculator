package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.Operand;
import com.github.thanus.rpn.operations.Operation;

import java.util.Stack;

public class SquareRoot extends Operation {
    @Override
    public void operate(Stack<Operand> stack) {
        final var firstOperand = stack.pop();

        stack.push(firstOperand.sqrt());
    }
}
