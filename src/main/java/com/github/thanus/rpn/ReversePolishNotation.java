package com.github.thanus.rpn;

import com.github.thanus.rpn.operations.Clear;
import com.github.thanus.rpn.operations.math.Addition;
import com.github.thanus.rpn.operations.math.Division;
import com.github.thanus.rpn.operations.math.Multiplication;
import com.github.thanus.rpn.operations.math.SquareRoot;
import com.github.thanus.rpn.operations.math.Subtraction;

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

            switch (val) {
                case "+": {
                    new Addition().operate(stack);
                    break;
                }
                case "-": {
                    new Subtraction().operate(stack);
                    break;
                }
                case "*": {
                    new Multiplication().operate(stack);
                    break;
                }
                case "/": {
                    new Division().operate(stack);
                    break;
                }
                case "sqrt": {
                    new SquareRoot().operate(stack);
                    break;
                }
                case "clear": {
                    new Clear().operate(stack);
                    break;
                }
            }
        }
    }
}
