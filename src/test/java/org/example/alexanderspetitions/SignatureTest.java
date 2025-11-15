package org.example.alexanderspetitions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SignatureTest {

    @BeforeEach
    void setup() {
        PetitionList.clearAll();
        PetitionList.addPetition(new Petition("Save the Forest", "We must protect the environment"));
    }

    @Test
    void testAddSignature() {
        String query = "forest";

        List<Petition> results = PetitionList.getPetitions().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(query))
                .collect(Collectors.toList());

        for (Petition p : results){

            Signature s = new Signature("Alex", "adad@gmail.com");
            p.addSignature(s);

            assertEquals(1, p.getSignatures().size());
        }

    }

}
