package com.github.thanus.rpn.context;

public interface Context<NUMBER> {
    void push(NUMBER number);

    NUMBER pop();

    NUMBER peek();

    void clear();

    int size();

    boolean hasNoOperands();

    boolean hasLessThanTwoOperands();

    String getDisplayValueContent();

    CalculatorContextMemento<NUMBER> save();

    void restore(CalculatorContextMemento<NUMBER> previousState);

}
