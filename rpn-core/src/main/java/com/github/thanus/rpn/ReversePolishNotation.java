package com.github.thanus.rpn;

import com.github.thanus.rpn.operations.OperationsParser;
import com.github.thanus.rpn.operations.UnknownOperationException;
import com.github.thanus.rpn.operations.math.InsufficientParametersException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * caretaker
 */
@Slf4j
public class ReversePolishNotation {

    private final Deque<CalculatorContextMemento> mementos = new ArrayDeque<>();
    private final CalculatorContext calculatorContext = new CalculatorContext();

    public ReversePolishNotation() {
        addMemento(calculatorContext.save());
    }

    public void evaluate(String input) {
        var position = 1;

        for (var value : input.trim().split(" ")) {
            if (Operand.isNumber(value)) {
                final var operand = new Operand(value);
                calculatorContext.push(operand);

                addMemento(calculatorContext.save());
                position += value.length() + 1;

                continue;
            }

            try {
                final var operation = OperationsParser.parse(value);
                operation.operate(calculatorContext, mementos);

                addMemento(calculatorContext.save());
                position += value.length() + 1;
            } catch (InsufficientParametersException e) {
                log.warn("operator {} (position: {}): insufficient parameters", value, position);
                break;
            } catch (UnknownOperationException exception) {
                log.error("operator {} (position: {}): unknown operator", exception.getOperation(), position);
                break;
            } catch (CalculatorException ignored) {
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
