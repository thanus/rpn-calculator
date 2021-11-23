package com.github.thanus.rpn;

import com.github.thanus.rpn.operations.OperationsParser;
import com.github.thanus.rpn.operations.UnknownOperationException;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * caretaker
 */
public class ReversePolishNotation {

    private final Deque<CalculatorContextMemento> mementos = new ArrayDeque<>();
    private final CalculatorContext calculatorContext = new CalculatorContext();

    public void process(String expression) {
        var position = 1;

        for (var val : expression.trim().split(" ")) {
            try {
                final var operand = new Operand(val);
                calculatorContext.push(operand);
                addMemento(calculatorContext.save());
                position += val.length() + 1;
                continue;
            } catch (NumberFormatException ignored) {
            }

            try {
                final var operation = OperationsParser.parse(val);
                operation.operate(calculatorContext, mementos);

                addMemento(calculatorContext.save());
                position += val.length() + 1;
            } catch (InsufficientParametersException e) {
                System.out.println("operator " + val + " (position: " + position + "): insufficient parameters");
                break;
            } catch (UnknownOperationException exception) {
                System.out.println("operator " + exception.getOperation() + " (position: " + position + "): unknown operator");
                break;
            } catch (CalculatorException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public String getDisplayValueContent() {
        return calculatorContext.getDisplayValueContent();
    }

    private void addMemento(CalculatorContextMemento calculatorContextMemento) {
        mementos.push(calculatorContextMemento);
    }

}
