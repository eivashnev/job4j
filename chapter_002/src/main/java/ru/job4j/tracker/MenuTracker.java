package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.input.Input;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(1, "Add item"));
        this.actions.add(new ShowItems(2, "Show all items"));
        this.actions.add(new EditItem(3, "Edit item"));
        this.actions.add(new DeleteItem(4, "Delete item"));
        this.actions.add(new FindItemById(5, "Find item by Id"));
        this.actions.add(new FindItemsByName(6, "Find items by name"));
        this.actions.add(new ExitProgram(0, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        for (UserAction action : actions) {
            if (action.key() == key) {
                action.execute(this.input, this.tracker);
                break;
            }
        }
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println();
        System.out.println("=================== Tracker Menu ===================");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.key() + ". " + action.info());
            }
        }
    }
}
