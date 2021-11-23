package com.github.thanus.rpn.operations.math;

import com.github.thanus.rpn.CalculatorException;

public class InsufficientParametersException extends CalculatorException {
    public InsufficientParametersException() {
        super("Insufficient parameters in calculator context");
    }
}
