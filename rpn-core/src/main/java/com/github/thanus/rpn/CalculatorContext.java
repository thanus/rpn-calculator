package com.github.thanus.rpn;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * originator
 */
public class CalculatorContext {
    private Stack<Operand> stack = new Stack<>();

    public void push(Operand operand) {
        stack.push(operand);
    }

    public Operand pop() {
        return stack.pop();
    }

    public Operand peek() {
        return stack.peek();
    }

    public void clear() {
        stack.clear();
    }

    public int size() {
        return stack.size();
    }

    public boolean hasNoOperands() {
        return stack.size() == 0;
    }

    public boolean hasLessThanTwoOperands() {
        return stack.size() < 2;
    }

    public String getDisplayValueContent() {
        return stack.stream()
                .map(Operand::getDisplayValue)
                .collect(Collectors.joining(" "));
    }

    @SuppressWarnings("unchecked")
    public CalculatorContextMemento save() {
        return new CalculatorContextMemento((Stack<Operand>) stack.clone());
    }

    public void restore(CalculatorContextMemento calculatorContextMemento) {
        stack = calculatorContextMemento.getStack();
    }

}
