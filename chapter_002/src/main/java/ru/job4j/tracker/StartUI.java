package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;

/**
 * Tracker Program.
 *
 * @author - Evgeny Ivashnev (zheniog@yandex.ru)
 */
public class StartUI {
    private static final String EXIT = "0";
    private static final String ADD = "1";
    private static final String SHOW_ALL = "2";
    private static final String EDIT = "3";
    private static final String DELETE = "4";
    private static final String FIND_BY_ID = "5";
    private static final String FIND_BY_NAME = "6";

    Input input;
    Tracker tracker;

    boolean exit = false;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        while (!exit) {
            this.showMenu();
            String answer = input.ask("Select action: ");
            switch (answer) {
                case EXIT:
                    exit = true;
                    break;
                case ADD:
                    this.addItem();
                    break;
                case SHOW_ALL:
                    this.showAllItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FIND_BY_ID:
                    this.findItemById();
                    break;
                case FIND_BY_NAME:
                    this.findItemsByName();
                    break;
                default:
                    break;
            }
        }
        System.out.println("Good bye!");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * Shows main menu
     */
    private void showMenu() {
        System.out.println("\nTracker Menu: ");
        System.out.println("1. Add new Item");
        System.out.println("2. Show all items");
        System.out.println("3. Edit item");
        System.out.println("4. Delete item");
        System.out.println("5. Find item by Id");
        System.out.println("6. Find items by name");
        System.out.println("0. Exit Program");
    }

    /**
     * Method to add new item.
     */
    private void addItem() {
        String taskName = input.ask("Enter item name: ");
        String taskDesc = input.ask("Enter item description: ");
        Item item = new Item(taskName, taskDesc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("Added item: " + item.toString() + "\n");
    }

    /**
     * Method to show all items.
     */
    private void showAllItems() {
        System.out.println("All items: ");
        System.out.println("===========================================================================");
        for (Item item : tracker.findAll()) {
            System.out.println(item.toString());
        }
        System.out.println("\n");
    }

    /**
     * Method to edit item.
     */
    private void editItem() {
        String itemId = input.ask("Enter item ID to change: ");
        String itemName = input.ask("Enter new item name: ");
        String itemDesc = input.ask("Enter new item description: ");
        Item newItem = new Item(itemName, itemDesc, System.currentTimeMillis());

        if (tracker.replace(itemId, newItem)) {
            newItem.setId(itemId);
            System.out.println("Item edited! ID: " + itemId);
        } else {
            System.out.println("Item not found! Please check entered ID: " + itemId);
        }
    }

    /**
     * Method to delete item.
     */
    private void deleteItem() {
        String itemId = input.ask("Enter item ID to delete: ");
        if (tracker.delete(itemId)) {
            System.out.println("Item deleted! ID: " + itemId);
        } else {
            System.out.println("Item not found! Please check entered ID: " + itemId);
        }
    }

    /**
     * Method to find item by id.
     */
    private void findItemById() {
        String itemId = input.ask("Enter item ID to find: ");
        Item foundItem = tracker.findById(itemId);
        if (foundItem != null) {
            System.out.println("Item found: " + foundItem);
        } else {
            System.out.println("Item not found!");
        }

    }

    /**
     * Method to find items by name.
     */
    private void findItemsByName() {
        String itemName = input.ask("Enter item name to find: ");
        System.out.println(String.format("Items found by name [<%s>]: ", itemName));
        System.out.println("========================================================================================");
        for (Item item : tracker.findByName(itemName)) {
            System.out.println(item.toString());
        }
        System.out.println("\n");
    }

}
