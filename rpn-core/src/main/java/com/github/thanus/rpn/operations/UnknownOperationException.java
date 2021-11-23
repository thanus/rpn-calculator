package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.CalculatorException;
import lombok.Getter;

@Getter
public class UnknownOperationException extends CalculatorException {
    private final String operation;

    public UnknownOperationException(String operation) {
        super("Unknown operation " + operation);
        this.operation = operation;
    }
}
