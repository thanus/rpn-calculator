package com.github.thanus.rpn;

import com.github.thanus.rpn.operations.OperationsParser;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println("Enter");

        final var scanner = new Scanner(System.in);

        final var stack = new Stack<Operand>();

        while (scanner.hasNextLine()) {
            final var expression = scanner.nextLine();
            process(expression, stack);
            System.out.println("stack: " + stack.stream().map(Operand::getDisplayValue).collect(Collectors.joining(" ")));
        }

    }

    private static void process(String expression, Stack<Operand> stack) {
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
