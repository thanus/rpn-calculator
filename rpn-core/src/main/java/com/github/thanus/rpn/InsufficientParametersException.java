package com.github.thanus.rpn;

public class InsufficientParametersException extends CalculatorException {
    public InsufficientParametersException() {
        super("Insufficient parameters in calculator context");
    }
}
