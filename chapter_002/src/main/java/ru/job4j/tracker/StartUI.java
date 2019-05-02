package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Tracker Program.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class StartUI {

    Input input;
    Tracker tracker;

    public static boolean exit = false;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        while (!exit) {
            menu.show();
            menu.select(input.ask("Select: ", range));
        }
    }

    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(),
                System.out::println
        ).init();
    }

}
