package com.mcally;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PokemonRepository {
    private Map<Integer, Pokemon> dataStoreMap;

    public PokemonRepository() {
        this.dataStoreMap = new HashMap<>();
    }

    public Pokemon put(Integer key, Pokemon value) {
        dataStoreMap.put(key, value);
        return value;
    }

    public void delete(Integer key) {
        dataStoreMap.remove(key);
    }

    public Optional<Pokemon> get(Integer key) {
        return dataStoreMap.containsKey(key)
                ? Optional.of(dataStoreMap.get(key))
                : Optional.empty();
    }
}

