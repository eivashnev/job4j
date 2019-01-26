package ru.job4j.tracker.input;

import ru.job4j.tracker.exceptions.MenuOutException;

import java.util.Scanner;

/**
 * Console input implementation.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        System.out.print(question);
        int answer = Integer.valueOf(scanner.nextLine());
        int result = -1;
        for (int opt : range) {
            if (answer == opt) {
                result = answer;
                break;
            }
        }
        if (result == -1) {
            throw new MenuOutException("Invalid option.");
        }
        return result;
    }
}
