package ru.job4j.tracker.input;

import ru.job4j.tracker.exceptions.MenuOutException;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        int result = -1;
        while (result == -1) {
            try {
                result = this.input.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println("Please select menu option in range.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a number.");
            }
        }
        return result;
    }
}
