package com.github.thanus.rpn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReversePolishNotationTest {

    @Test
    void example1() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process("5 2");

        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("5 2");
    }

    @Test
    void example2() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process("2 sqrt");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("1.4142135623");

        reversePolishNotation.process("clear 9 sqrt");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("3");
    }

    @Test
    void example3() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process("5 2 -");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("3");

        reversePolishNotation.process("3 -");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("0");

        reversePolishNotation.process("clear");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("");
    }

    @Test
    void example4() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process("5 4 3 2");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("5 4 3 2");

        reversePolishNotation.process("undo undo *");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("20");

        reversePolishNotation.process("5 *");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("100");

        reversePolishNotation.process("undo");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("20 5");
    }

    @Test
    void example5() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process("7 12 2 /");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("7 6");

        reversePolishNotation.process("*");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("42");

        reversePolishNotation.process("4 /");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("10.5");
    }

    @Test
    void example6() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process("1 2 3 4 5");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("1 2 3 4 5");

        reversePolishNotation.process("*");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("1 2 3 20");

        reversePolishNotation.process("clear 3 4 -");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("-1");
    }

    @Test
    void example8() {
        final var reversePolishNotation = new ReversePolishNotation();
        reversePolishNotation.process("1 2 3 * 5 + * * 6 5");
        assertThat(reversePolishNotation.getDisplayValueContent()).isEqualTo("11");
    }
}
