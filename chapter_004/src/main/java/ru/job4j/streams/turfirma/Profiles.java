package ru.job4j.streams.turfirma;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress())
                .distinct()
                .sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> profileList = Arrays.asList(
                new Profile(new Address("Nizhny Novgorod", "Pushkina", 3, 15)),
                new Profile(new Address("Moscow", "Arbat", 10, 18)),
                new Profile(new Address("Moscow", "Arbat", 10, 18)),
                new Profile(new Address("St. Peresburg", "Nevskaya", 13, 5)));
        List<Address> addresses = new Profiles().collect(profileList);
        addresses.forEach(System.out::println);
    }
}
