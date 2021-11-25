package com.github.thanus.rpn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReversePolishNotationTest {

    @Test
    void example1() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("5 2")).isEqualTo("5 2");
    }

    @Test
    void example2() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("2 sqrt")).isEqualTo("1.4142135623");

        assertThat(reversePolishNotation.evaluate("clear 9 sqrt")).isEqualTo("3");
    }

    @Test
    void example3() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("5 2 -")).isEqualTo("3");

        assertThat(reversePolishNotation.evaluate("3 -")).isEqualTo("0");

        assertThat(reversePolishNotation.evaluate("clear")).isEqualTo("");
    }

    @Test
    void example4() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("5 4 3 2")).isEqualTo("5 4 3 2");

        assertThat(reversePolishNotation.evaluate("undo undo *")).isEqualTo("20");

        assertThat(reversePolishNotation.evaluate("5 *")).isEqualTo("100");

        assertThat(reversePolishNotation.evaluate("undo")).isEqualTo("20 5");
    }

    @Test
    void example5() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("7 12 2 /")).isEqualTo("7 6");

        assertThat(reversePolishNotation.evaluate("*")).isEqualTo("42");

        assertThat(reversePolishNotation.evaluate("4 /")).isEqualTo("10.5");
    }

    @Test
    void example6() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("1 2 3 4 5")).isEqualTo("1 2 3 4 5");

        assertThat(reversePolishNotation.evaluate("*")).isEqualTo("1 2 3 20");

        assertThat(reversePolishNotation.evaluate("clear 3 4 -")).isEqualTo("-1");
    }

    @Test
    void example7() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("1 2 3 4 5")).isEqualTo("1 2 3 4 5");

        assertThat(reversePolishNotation.evaluate("* * * *")).isEqualTo("120");
    }

    @Test
    void example8() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("1 2 3 * 5 + * * 6 5")).isEqualTo("11");
    }

    @Test
    void shouldNotFailOnUnknownOperation() {
        final var reversePolishNotation = new ReversePolishNotation();
        assertThat(reversePolishNotation.evaluate("1 2")).isEqualTo("1 2");
        assertThat(reversePolishNotation.evaluate("a +")).isEqualTo("1 2");
    }
}
