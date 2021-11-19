package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.operations.Operation;

public class SquareRoot extends Operation {
    @Override
    public void operate(CalculatorContext calculatorContext) {
        final var firstOperand = calculatorContext.pop();

        calculatorContext.push(firstOperand.sqrt());
    }
}
