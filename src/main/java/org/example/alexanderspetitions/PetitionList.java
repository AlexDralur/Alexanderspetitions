package org.example.alexanderspetitions;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PetitionList {

    // Creates an array with the current petitions
    private static final List<Petition> petitions = new CopyOnWriteArrayList<>();

    //Two default petitions are created to populate the list
    static {
        petitions.add(new Petition(
                "Extra hour for parking",
                "We urge Cork City Council to add an extra hour to the current parking ticket. An extra hour" +
                        " will make a single driver save over 5 euros per day."));

        petitions.add(new Petition(
                "Extra bins on the streets",
                "Although the addition of the 'smart' bins throughout Cork City are a delightful" +
                        " surprise, more need to be available to the public. There are streets without a " +
                        "single bin. Those areas are suffering with constant littering."));
    }

    //add any new petitions to the list
    public static void addPetition(Petition petition) {
        petitions.add(petition);
    }

    // return a copy of the list to avoid exposing internal state
    public static List<Petition> getPetitions() {
        return List.copyOf(petitions);
    }

    //Set only to allow the JUnit test to run
    public static void clearAll() {
        petitions.clear();
    }
}
