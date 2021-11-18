package com.mcally;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PokemonRepositoryTest {

    private PokemonRepository dataStore;

    @BeforeEach
    void setup() {
        this.dataStore = new PokemonRepository();
    }
    @Test
    void put() {
        Pokemon expected = new Pokemon();

        dataStore.put(1, expected);

        Optional<Pokemon> actual = dataStore.get(1);

        assertTrue(actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    void delete() {
        Pokemon expected = new Pokemon();

        dataStore.put(1, expected);
        Optional<Pokemon> initialInsert = dataStore.get(1);
        assertTrue(initialInsert.isPresent());

        dataStore.delete(1);

        Optional<Pokemon> actual = dataStore.get(1);
        assertTrue(actual.isEmpty());
    }

}