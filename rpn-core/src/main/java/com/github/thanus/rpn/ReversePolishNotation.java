package com.github.thanus.rpn;

import com.github.thanus.rpn.operations.OperationsParser;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * caretaker
 */
public class ReversePolishNotation {

    private final Deque<CalculatorContextMemento> mementos = new ArrayDeque<>();
    private final CalculatorContext calculatorContext = new CalculatorContext();

    public static void main(String[] args) {
        System.out.println("Enter");
        final var scanner = new Scanner(System.in);

        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process(scanner);
    }

    public void addMemento(CalculatorContextMemento calculatorContextMemento) {
        mementos.push(calculatorContextMemento);
    }

    private void process(Scanner scanner) {
        while (scanner.hasNextLine()) {
            final var expression = scanner.nextLine();

            var position = 1;

            for (var val : expression.split(" ")) {
                try {
                    final var operand = new Operand(val);
                    calculatorContext.push(operand);
                    addMemento(calculatorContext.save());
                    position += val.length() + 1;
                    continue;
                } catch (NumberFormatException ignored) {
                }

                final var operation = OperationsParser.parse(val);
                try {
                    operation.operate(calculatorContext, mementos);
                    addMemento(calculatorContext.save());
                    position += val.length() + 1;
                } catch (InsufficientParametersException e) {
                    System.out.println("operator " + val + " (position: " + position + "): insufficient parameters");
                    break;
                } catch (CalculatorException e) {
                    e.printStackTrace();
                    break;
                }
            }

            System.out.println("stack: " + calculatorContext.getDisplayValueContent());
        }
    }
}
