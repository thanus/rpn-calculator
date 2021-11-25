package com.github.thanus.rpn.context;

import com.github.thanus.rpn.Operand;

import java.util.Stack;
import java.util.stream.Collectors;

public class CalculatorContext implements Context<Operand> {
    private Stack<Operand> stack = new Stack<>();

    @Override
    public void push(Operand operand) {
        stack.push(operand);
    }

    @Override
    public Operand pop() {
        return stack.pop();
    }

    @Override
    public Operand peek() {
        return stack.peek();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public boolean hasNoOperands() {
        return stack.size() == 0;
    }

    @Override
    public boolean hasLessThanTwoOperands() {
        return stack.size() < 2;
    }

    @Override
    public String getDisplayValueContent() {
        return stack.stream()
                .map(Operand::getDisplayValue)
                .collect(Collectors.joining(" "));
    }

    @Override
    @SuppressWarnings("unchecked")
    public CalculatorContextMemento<Operand> save() {
        return new CalculatorContextMemento<>((Stack<Operand>) stack.clone());
    }

    @Override
    public void restore(CalculatorContextMemento<Operand> calculatorContextMemento) {
        stack = calculatorContextMemento.getStack();
    }

}
