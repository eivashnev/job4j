public class User implements Comparable {
    String name = "user";
    int age = 0;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
