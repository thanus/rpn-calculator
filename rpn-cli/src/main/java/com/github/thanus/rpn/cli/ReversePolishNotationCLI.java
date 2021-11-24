package com.github.thanus.rpn.cli;

import com.github.thanus.rpn.ReversePolishNotation;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ReversePolishNotationCLI {
    public static void main(String[] args) {
        final var cli = new ReversePolishNotationCLI();
        cli.run();
    }

    private void run() {
        log.info("Enter expression");

        final var scanner = new Scanner(System.in);
        final var reversePolishNotation = new ReversePolishNotation();

        while (scanner.hasNextLine()) {
            reversePolishNotation.evaluate(scanner.nextLine());
            log.info("stack: " + reversePolishNotation.getDisplayValueContent());
        }
    }
}
