package com.github.thanus.rpn;

import java.util.Stack;
import java.util.stream.Collectors;

public class CalculatorContext {
    final Stack<Operand> stack = new Stack<>();

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

    public String getDisplayValueContent() {
        return stack.stream()
                .map(Operand::getDisplayValue)
                .collect(Collectors.joining(" "));
    }

}
