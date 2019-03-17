package generics;

import org.junit.Test;
import ru.job4j.generics.User;
import ru.job4j.generics.UserConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void testConvertUserListToMap() {
        UserConvert converter = new UserConvert();
        User user1 = new User(0, "Evgeny", "NNovgorod");
        User user2 = new User(1, "Alex", "Moskva");
        User user3 = new User(2, "Tanya", "Piter");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(user1.getId(), user1);
        expect.put(user2.getId(), user2);
        expect.put(user3.getId(), user3);

        HashMap<Integer, User> result = converter.process(list);
        assertThat(result, is(expect));

    }
}
