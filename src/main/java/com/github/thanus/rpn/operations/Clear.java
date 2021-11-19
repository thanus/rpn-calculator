package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.Operand;

import java.util.Stack;

public class Clear extends Operation {
    @Override
    public void operate(Stack<Operand> stack) {
        stack.clear();
    }
}
