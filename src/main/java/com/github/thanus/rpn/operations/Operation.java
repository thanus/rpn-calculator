package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.CalculatorContextMemento;

import java.util.Deque;

public abstract class Operation {
    public abstract void operate(final CalculatorContext calculatorContext, Deque<CalculatorContextMemento> mementos);
}
