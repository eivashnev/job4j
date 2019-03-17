package sort;

import org.junit.Test;
import ru.job4j.sort.SortUser;
import ru.job4j.sort.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void testSortUsersByAge() {
        SortUser sortUser = new SortUser();
        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("Anatoly", 65),
                new User("Ivan", 21),
                new User("Evgeny", 30),
                new User("Olga", 25)
        ));
        Set<User> result = sortUser.sort(userList);
        Set<User> expect = new TreeSet<>(
                Arrays.asList(
                        new User("Ivan", 21),
                        new User("Olga", 25),
                        new User("Evgeny", 30),
                        new User("Anatoly", 65)
                )
        );
        assertThat(result, is(expect));
    }

    @Test
    public void testUserSortByNameLenght() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Anatoly", 65);
        User user2 = new User("Ivan", 21);
        User user3 = new User("Evgeny", 30);
        List<User> userList = new ArrayList<>(Arrays.asList(
                user1,
                user2,
                user3
        ));
        List<User> result = sortUser.sortNameLength(userList);
        List<User> expect = new ArrayList<>(Arrays.asList(
                user2,
                user3,
                user1
        ));
        assertThat(result, is(expect));
    }

    @Test
    public void testUserSortByNameAndAge() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        User user4 = new User("Иван", 25);
        List<User> result = sortUser.sortByAllFields(Arrays.asList(
                user1,
                user2,
                user3,
                user4
        ));
        List<User> expect = new ArrayList<>(Arrays.asList(
                user4,
                user2,
                user3,
                user1
        ));
        assertThat(result, is(expect));
    }
}
