package org.scoula.pokemon.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonListWrapper {
    private int count;
    private String next;
    private String previous;
    private List<SimplePokemon> results;

    @Data
    public static class SimplePokemon {
        private String name;
        private String url;
    }
}