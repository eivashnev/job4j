package ru.job4j.streams.turfirma;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> profileList = Arrays.asList(new Profile(new Address("NN", "Pushkina", 3, 15)),
                                           new Profile(new Address("Moscow", "Arbat", 10, 18)));
        List<Address> addresses = new Profiles().collect(profileList);
        addresses.forEach(System.out::println);
    }
}
