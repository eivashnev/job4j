package ru.job4j.oop;

public class Doctor extends Profession {
    private String profession = "Doctor";

    public Doctor(String name) {
        this.setProfession(profession);
        this.setName(name);
    }

    Diagnose heal(Pacient pacient) {
        return null;
    }

}
