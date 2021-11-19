package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.operations.math.Addition;
import com.github.thanus.rpn.operations.math.Division;
import com.github.thanus.rpn.operations.math.Multiplication;
import com.github.thanus.rpn.operations.math.SquareRoot;
import com.github.thanus.rpn.operations.math.Subtraction;

public class OperationsParser {

    public static Operation parse(String operation) {
        switch (operation) {
            case "+": {
                return new Addition();
            }
            case "-": {
                return new Subtraction();
            }
            case "*": {
                return new Multiplication();
            }
            case "/": {
                return new Division();
            }
            case "sqrt": {
                return new SquareRoot();
            }
            case "clear": {
                return new Clear();
            }
            default:
                throw new IllegalArgumentException("Unknown operation " + operation);
        }
    }
}
