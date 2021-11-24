package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.context.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;
import com.github.thanus.rpn.context.Context;
import com.github.thanus.rpn.Operand;

import java.util.Deque;

public class Clear extends Operation {
    @Override
    public void operate(Context<Operand> calculatorContext, Deque<CalculatorContextMemento<Operand>> mementos) throws CalculatorException {
        calculatorContext.clear();
        mementos.clear();
    }
}
