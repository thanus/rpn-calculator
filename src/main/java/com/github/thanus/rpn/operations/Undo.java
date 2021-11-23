package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.CalculatorContextMemento;

import java.util.Deque;

public class Undo extends Operation {

    @Override
    public void operate(CalculatorContext calculatorContext, Deque<CalculatorContextMemento> mementos) {
        mementos.pop();
        final var previousState = mementos.pop();
        calculatorContext.restore(previousState);
    }
}
