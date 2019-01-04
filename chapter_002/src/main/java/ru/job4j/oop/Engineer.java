package ru.job4j.oop;

public class Engineer extends Profession {
    private String profession = "Engineer";

    public Engineer(String name) {
        this.setProfession(profession);
        this.setName(name);
    }

    public House build(float area) {
        return null;
    }
}
