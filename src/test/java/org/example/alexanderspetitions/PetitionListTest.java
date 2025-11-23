package org.example.alexanderspetitions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PetitionListTest {

    @Test
    void testAddPetition() {
        Petition p = new Petition("Test Petition", "Test Description");
        PetitionList.addPetition(p);

        assertTrue(PetitionList.getPetitions().contains(p));
    }

    @Test
    void testUnmodifiableList() {
        Petition p = new Petition("Another", "Desc");
        PetitionList.addPetition(p);

        List<Petition> petitions = PetitionList.getPetitions();

        assertThrows(UnsupportedOperationException.class, () -> {
            petitions.add(new Petition("X", "Y"));
        });
    }
}
