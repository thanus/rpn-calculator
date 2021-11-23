package com.github.thanus.rpn.cli;

import com.github.thanus.rpn.ReversePolishNotation;

import java.util.Scanner;

public class ReversePolishNotationCLI {
    public static void main(String[] args) {
        final var cli = new ReversePolishNotationCLI();
        cli.run();
    }

    private void run() {
        System.out.println("Enter expression");

        final var scanner = new Scanner(System.in);
        final var reversePolishNotation = new ReversePolishNotation();

        while (scanner.hasNextLine()) {
            reversePolishNotation.process(scanner.nextLine());
            System.out.println("stack: " + reversePolishNotation.getDisplayValueContent());
        }
    }
}
