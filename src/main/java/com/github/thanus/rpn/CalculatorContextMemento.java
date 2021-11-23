package com.github.thanus.rpn;

import lombok.Value;

import java.util.Stack;

@Value
public class CalculatorContextMemento {
    Stack<Operand> stack;
}
