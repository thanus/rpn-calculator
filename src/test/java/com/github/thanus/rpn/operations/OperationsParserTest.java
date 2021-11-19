package com.github.thanus.rpn.operations;

import com.github.thanus.rpn.operations.math.Addition;
import com.github.thanus.rpn.operations.math.Division;
import com.github.thanus.rpn.operations.math.Multiplication;
import com.github.thanus.rpn.operations.math.SquareRoot;
import com.github.thanus.rpn.operations.math.Subtraction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationsParserTest {

    @ParameterizedTest
    @MethodSource("operations")
    void shouldParseOperations(String input, Operation expected) {
        final var operation = OperationsParser.parse(input);
        assertThat(operation).hasSameClassAs(expected);
    }

    private static Stream<Arguments> operations() {
        return Stream.of(
                Arguments.of("+", new Addition()),
                Arguments.of("-", new Subtraction()),
                Arguments.of("*", new Multiplication()),
                Arguments.of("/", new Division()),
                Arguments.of("sqrt", new SquareRoot()),
                Arguments.of("clear", new Clear())
        );
    }
}
