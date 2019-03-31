import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        User u1 = new User("Anton");
        bank.addUser(u1);
        bank.add(u1, new Account(213, "sadad"));

        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        System.out.println(bank);

    }
}
