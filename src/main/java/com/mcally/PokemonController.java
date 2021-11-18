package com.mcally;

public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonService.createPokemon(pokemon);
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        throw new UnsupportedOperationException();
    }


    public Pokemon retrievePokemon(Integer id) {
        return pokemonService.retrievePokemon(1).get();
    }

    public Pokemon deletePokemon(Integer id) {
        throw new UnsupportedOperationException();
    }
}
