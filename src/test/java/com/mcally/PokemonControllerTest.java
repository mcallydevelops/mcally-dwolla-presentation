package com.mcally;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PokemonControllerTest {

    private PokemonService pokemonService;
    private PokemonController pokemonController;

    @BeforeEach
    void setup() {
        this.pokemonService = mock(PokemonService.class);
        this.pokemonController = new PokemonController(pokemonService);
    }

    @Test
    void createPokemon() {
        Pokemon expected = new Pokemon();
        Pokemon request = new Pokemon();
        when(pokemonService.createPokemon(request)).thenReturn(expected);

        Pokemon actual = pokemonController.createPokemon(request);

        assertEquals(expected, actual);
    }

    @Test
    void updatePokemon() {
    }

    @Test
    void retrievePokemon() {
        Pokemon expected = new Pokemon();
        when(pokemonService.retrievePokemon(1)).thenReturn(Optional.of(expected));

        Pokemon actual = pokemonController.retrievePokemon(1);

        assertEquals(expected, actual);
    }

    @Test
    void testRetrievePokemon() {
    }

    @Test
    void deletePokemon() {
    }
}