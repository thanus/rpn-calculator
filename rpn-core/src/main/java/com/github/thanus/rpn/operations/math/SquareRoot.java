package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.context.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.context.Context;
import com.github.thanus.rpn.Operand;
import com.github.thanus.rpn.operations.Operation;

import java.util.Deque;

public class SquareRoot extends Operation {
    @Override
    public void operate(Context<Operand> calculatorContext, Deque<CalculatorContextMemento<Operand>> mementos) throws CalculatorException {
        if (calculatorContext.hasNoOperands()) {
            throw new InsufficientParametersException();
        }

        final var firstOperand = calculatorContext.pop();

        calculatorContext.push(firstOperand.sqrt());
    }
}
