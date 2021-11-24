package com.github.thanus.rpn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReversePolishNotationTest {

    @Test
    void example1() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.evaluate("5 2");

        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("5 2");
    }

    @Test
    void example2() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.evaluate("2 sqrt");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("1.4142135623");

        reversePolishNotation.evaluate("clear 9 sqrt");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("3");
    }

    @Test
    void example3() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.evaluate("5 2 -");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("3");

        reversePolishNotation.evaluate("3 -");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("0");

        reversePolishNotation.evaluate("clear");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("");
    }

    @Test
    void example4() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.evaluate("5 4 3 2");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("5 4 3 2");

        reversePolishNotation.evaluate("undo undo *");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("20");

        reversePolishNotation.evaluate("5 *");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("100");

        reversePolishNotation.evaluate("undo");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("20 5");
    }

    @Test
    void example5() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.evaluate("7 12 2 /");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("7 6");

        reversePolishNotation.evaluate("*");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("42");

        reversePolishNotation.evaluate("4 /");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("10.5");
    }

    @Test
    void example6() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.evaluate("1 2 3 4 5");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("1 2 3 4 5");

        reversePolishNotation.evaluate("*");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("1 2 3 20");

        reversePolishNotation.evaluate("clear 3 4 -");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("-1");
    }

    @Test
    void example8() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.evaluate("1 2 3 * 5 + * * 6 5");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("11");
    }
}
