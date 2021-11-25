package com.github.thanus.rpn.cli;

import com.github.thanus.rpn.ReversePolishNotation;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class ReversePolishNotationCLI {

    private final Scanner scanner;
    private final ReversePolishNotation reversePolishNotation;

    public ReversePolishNotationCLI(Scanner scanner, ReversePolishNotation reversePolishNotation) {
        this.scanner = scanner;
        this.reversePolishNotation = reversePolishNotation;
    }

    public static void main(String[] args) {
        final var cli = new ReversePolishNotationCLI(new Scanner(System.in), new ReversePolishNotation());
        cli.run();
    }

    public void run() {
        log.info("Enter expression");

        while (scanner.hasNextLine()) {
            log.info("stack: " + reversePolishNotation.evaluate(scanner.nextLine()));
        }
    }
}
