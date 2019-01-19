package ru.job4j.tracker.input;

import ru.job4j.tracker.exceptions.MenuOutException;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        int result = -1;
        while (result == -1) {
            try {
                result = super.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println("Please select menu option in range.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a number.");
            }
        }
        return result;
    }
}
