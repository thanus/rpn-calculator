package com.github.thanus.rpn;

import com.github.thanus.rpn.context.CalculatorContext;
import com.github.thanus.rpn.context.CalculatorContextMemento;
import com.github.thanus.rpn.context.Context;
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

    private final Deque<CalculatorContextMemento<Operand>> mementos = new ArrayDeque<>();
    private final Context<Operand> calculatorContext = new CalculatorContext();

    public String evaluate(String input) {
        var position = 1;

        for (var value : input.trim().split(" ")) {
            addMemento(calculatorContext.save());

            if (Operand.isNumber(value)) {
                final var operand = new Operand(value);
                calculatorContext.push(operand);

                position += value.length() + 1;

                continue;
            }

            try {
                final var operation = OperationsParser.parse(value);
                operation.operate(calculatorContext, mementos);

                position += value.length() + 1;
            } catch (InsufficientParametersException e) {
                log.warn("operator {} (position: {}): insufficient parameters", value, position);
                return calculatorContext.getDisplayValueContent();
            } catch (UnknownOperationException exception) {
                log.error("operator {} (position: {}): unknown operator", exception.getOperation(), position);
                return calculatorContext.getDisplayValueContent();
            } catch (CalculatorException ignored) {
                return calculatorContext.getDisplayValueContent();
            }
        }

        return calculatorContext.getDisplayValueContent();
    }

    private void addMemento(CalculatorContextMemento<Operand> calculatorContextMemento) {
        mementos.push(calculatorContextMemento);
    }

}
