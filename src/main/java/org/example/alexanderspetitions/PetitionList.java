package org.example.alexanderspetitions;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PetitionList {

    // Creates an array with the current petitions
    private static final List<Petition> petitions = new CopyOnWriteArrayList<>();


    //add any new petitions to the list
    public static void addPetition(Petition petition) {
        petitions.add(petition);
    }

    // return a copy of the list to avoid exposing internal state
    public static List<Petition> getPetitions() {
        return List.copyOf(petitions);
    }
}
