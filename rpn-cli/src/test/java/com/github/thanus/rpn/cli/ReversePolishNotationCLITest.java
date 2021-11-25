package com.github.thanus.rpn.cli;

import com.github.thanus.rpn.ReversePolishNotation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReversePolishNotationCLITest {

    @Test
    void shouldRunCLI() {
        var rpn = Mockito.mock(ReversePolishNotation.class);

        final var reversePolishNotationCLI = new ReversePolishNotationCLI(new Scanner("1 2"), rpn);

        when(rpn.evaluate("1 2")).thenReturn("1 2");

        reversePolishNotationCLI.run();

        verify(rpn).evaluate("1 2");
    }
}
