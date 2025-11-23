package org.example.alexanderspetitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    @BeforeEach
    public void setup() {
        PetitionList.clearAll();
        PetitionList.addPetition(new Petition("Save the Forest", "We must protect the environment"));
        PetitionList.addPetition(new Petition("Clean Beaches", "Stop pollution"));
    }

    @Test
    public void testSearchFindsTitle() {
        String query = "forest";

        List<Petition> results = PetitionList.getPetitions().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(query))
                .collect(Collectors.toList());

        assertEquals(1, results.size());
    }

    @Test
    public void testSearchFindsDescription() {
        String query = "pollution";

        List<Petition> results = PetitionList.getPetitions().stream()
                .filter(p -> p.getDescription().toLowerCase().contains(query))
                .collect(Collectors.toList());

        assertEquals(1, results.size());
    }

    @Test
    public void testSearchReturnsEmpty() {
        String query = "nothing";

        List<Petition> results = PetitionList.getPetitions().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(query))
                .collect(Collectors.toList());

        assertTrue(results.isEmpty());
    }
}
