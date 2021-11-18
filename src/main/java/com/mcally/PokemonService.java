package com.mcally;

import java.util.Optional;

public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.put(pokemon.getId(), pokemon);
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        throw new UnsupportedOperationException();
    }

    public Optional<Pokemon> retrievePokemon(Integer id) {
        return pokemonRepository.get(id);
    }

    public Pokemon deletePokemon(Integer id) {
        throw new UnsupportedOperationException();
    }
}
