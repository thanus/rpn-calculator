package com.github.thanus.rpn.context;

import lombok.Value;

import java.util.Stack;

@Value
public class CalculatorContextMemento<NUMBER> {
    Stack<NUMBER> stack;
}
