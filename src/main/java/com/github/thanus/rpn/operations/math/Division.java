package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.InsufficientParametersException;
import com.github.thanus.rpn.operations.Operation;

import java.util.Deque;

public class Division extends Operation {
    @Override
    public void operate(CalculatorContext calculatorContext, Deque<CalculatorContextMemento> mementos) throws CalculatorException {
        if (calculatorContext.hasLessThanTwoOperands()) {
            throw new InsufficientParametersException();
        }

        final var secondOperand = calculatorContext.pop();
        final var firstOperand = calculatorContext.pop();

        calculatorContext.push(firstOperand.divide(secondOperand));
    }
}
