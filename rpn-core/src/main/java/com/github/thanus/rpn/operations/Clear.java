package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;

import java.util.Deque;

public class Clear extends Operation {
    @Override
    public void operate(CalculatorContext calculatorContext, Deque<CalculatorContextMemento> mementos) throws CalculatorException {
        calculatorContext.clear();
        mementos.clear();
    }
}
