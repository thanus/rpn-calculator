package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.CalculatorContext;
import com.github.thanus.rpn.CalculatorContextMemento;
import com.github.thanus.rpn.CalculatorException;

import java.util.Deque;

public abstract class Operation {
    public abstract void operate(CalculatorContext calculatorContext, Deque<CalculatorContextMemento> mementos) throws CalculatorException;
}
