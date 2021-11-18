package com.mcally;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonServiceTest {

    private PokemonRepository pokemonRepository;
    private PokemonService pokemonService;

    @BeforeEach
    void setup() {
        this.pokemonRepository = mock(PokemonRepository.class);
        this.pokemonService = new PokemonService(pokemonRepository);
    }

    @Test
    void createPokemon() {
        Pokemon request = new Pokemon(1, "Pokemon");
        Pokemon expected = new Pokemon();
        when(pokemonRepository.put(1, request)).thenReturn(expected);

        Pokemon actual = pokemonService.createPokemon(request);

        assertEquals(expected, actual);
    }

    @Test
    void updatePokemon() {
    }

    @Test
    void retrievePokemon() {
        Pokemon expected = new Pokemon();
        when(pokemonRepository.get(1)).thenReturn(Optional.of(expected));

        Optional<Pokemon> actual = pokemonService.retrievePokemon(1);

        assertEquals(expected, actual.get());
    }

    @Test
    void deletePokemon() {
    }
}