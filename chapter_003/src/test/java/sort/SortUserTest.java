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
                new User("Olga",25)
        ));
        Set<User> result = sortUser.sort(userList);
        Set<User> expect = new TreeSet<>(
                Arrays.asList(
                        new User("Ivan", 21),
                        new User("Olga",25),
                        new User("Evgeny", 30),
                        new User("Anatoly", 65)
                )
        );
        assertThat(result,is(expect));
    }
}
