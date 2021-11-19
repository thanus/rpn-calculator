package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.Operand;

import java.util.Stack;

public abstract class Operation {
    public abstract void operate(final Stack<Operand> stack);
}
