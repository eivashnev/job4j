package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", "0"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), containsString(
                new StringJoiner(System.lineSeparator(), "", "")
                        .add("------------ All items --------------")
                        .add("Item{id='" + item.getId() + "', name='" + item.getName() + "', desc='" + item.getDesc()
                                + "', created=" + item.getCreated() + ", comments=null}")
                        .add("")
                        .toString()
        ));
    }

    @Test
    public void whenItemFoundByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"6", "test name", "0"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), containsString(
                new StringJoiner(System.lineSeparator(), "", "")
                        .add("Items found by name [<test name>]: ")
                        .add("---------------------------------------------")
                        .add("Item{id='" + item.getId() + "', name='" + item.getName() + "', desc='" + item.getDesc()
                                + "', created=" + item.getCreated() + ", comments=null}").toString()
        ));
    }

    @Test
    public void whenItemFoundById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getId(), "0"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                containsString("Item found: Item{id='" + item.getId()
                                + "', name='" + item.getName() + "', desc='" + item.getDesc()
                                + "', created=" + item.getCreated() + ", comments=null}"));
    }

    @Test
    public void whenItemNotFoundById() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"5", "123", "0"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                containsString("Item not found!"));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "test name", "desc", "0"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "test replace", "заменили заявку", "0"});
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerDeletesItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим удаление заявки)
        Input input = new StubInput(new String[]{"4", item.getId(), "0"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что удаленный элемент отсутствует в трекере
        assertNull(tracker.findById(item.getId()));
    }

}