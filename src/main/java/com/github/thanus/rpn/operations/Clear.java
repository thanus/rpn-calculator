package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.CalculatorContext;

public class Clear extends Operation {
    @Override
    public void operate(CalculatorContext calculatorContext) {
        calculatorContext.clear();
    }
}
