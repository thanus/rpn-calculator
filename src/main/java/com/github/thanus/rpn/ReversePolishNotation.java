package com.github.thanus.rpn;

import com.github.thanus.rpn.operations.OperationsParser;

import java.util.Scanner;

public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println("Enter");

        final var scanner = new Scanner(System.in);

        final var calculatorContext = new CalculatorContext();

        while (scanner.hasNextLine()) {
            final var expression = scanner.nextLine();
            process(expression, calculatorContext);
            System.out.println("stack: " + calculatorContext.getDisplayValueContent());
        }

    }

    private static void process(String expression, CalculatorContext stack) {
        for (var val : expression.split(" ")) {
            try {
                final var operand = new Operand(val);
                stack.push(operand);
                continue;
            } catch (NumberFormatException ignored) {
            }

            final var operation = OperationsParser.parse(val);
            operation.operate(stack);
        }
    }
}
