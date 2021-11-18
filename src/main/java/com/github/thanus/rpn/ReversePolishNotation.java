package com.github.thanus.rpn;

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println("Enter");

        final var scanner = new Scanner(System.in);

        final var stack = new Stack<String>();

        while (scanner.hasNextLine()) {
            final var expression = scanner.nextLine();
            process(expression, stack);
            System.out.println("stack: " + String.join(" ", stack));
        }

    }

    private static void process(String expression, Stack<String> stack) {
        for (var value : expression.split(" ")) {
            if (value.chars().allMatch(Character::isDigit)) {
                stack.push(value);
                continue;
            }

            switch (value) {
                case "+": {
                    final var secondOperand = stack.pop();
                    final var firstOperand = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand)));
                    break;
                }
                case "-": {
                    final var secondOperand = stack.pop();
                    final var firstOperand = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand)));
                    break;
                }
                case "*": {
                    final var secondOperand = stack.pop();
                    final var firstOperand = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand)));
                    break;
                }
                case "/": {
                    final var secondOperand = stack.pop();
                    final var firstOperand = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(firstOperand) / Integer.parseInt(secondOperand)));
                    break;
                }
                case "sqrt": {
                    final var firstOperand = stack.pop();
                    stack.push(String.valueOf(Math.sqrt(Double.parseDouble(firstOperand))));
                    break;
                }
                case "clear": {
                    stack.clear();
                    break;
                }
            }
        }
    }
}
