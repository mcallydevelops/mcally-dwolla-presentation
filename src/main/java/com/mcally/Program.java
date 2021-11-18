package com.mcally;

import com.fasterxml.jackson.databind.ObjectMapper;

import static spark.Spark.*;

public class Program {

    public void run() {
        ObjectMapper objectMapper = objectMapper();
        PokemonRepository pokemonRepository = pokemonRepository();
        PokemonService pokemonService = pokemonService(pokemonRepository);
        PokemonController pokemonController = pokemonController(pokemonService);
        get("/pokemon/:id", (req, res) -> {
            Pokemon response =  pokemonController.retrievePokemon(Integer.valueOf(req.params(":id")));
            return objectMapper.writeValueAsString(response);
        });

        post("/pokemon", (req, res) -> {
            try {
                Pokemon request = objectMapper.readValue(req.body(), Pokemon.class);
                Pokemon response = pokemonController.createPokemon(request);
                return objectMapper.writeValueAsString(response);

            } catch (Exception exception) {
                return "Internal Server Error";
            }
        });
    }

    private ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    private PokemonRepository pokemonRepository() {
        return new PokemonRepository();
    }

    private PokemonService pokemonService(PokemonRepository pokemonRepository) {
        return new PokemonService(pokemonRepository);
    }

    private PokemonController pokemonController(PokemonService pokemonService) {
        return new PokemonController(pokemonService);
    }
}
