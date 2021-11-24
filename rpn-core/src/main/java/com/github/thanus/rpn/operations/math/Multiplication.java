package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.context.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.context.Context;
import com.github.thanus.rpn.Operand;
import com.github.thanus.rpn.operations.Operation;

import java.util.Deque;

public class Multiplication extends Operation {
    @Override
    public void operate(Context<Operand> calculatorContext, Deque<CalculatorContextMemento<Operand>> mementos) throws CalculatorException {
        if (calculatorContext.hasLessThanTwoOperands()) {
            throw new InsufficientParametersException();
        }

        final var secondOperand = calculatorContext.pop();
        final var firstOperand = calculatorContext.pop();

        calculatorContext.push(firstOperand.multiply(secondOperand));
    }
}
