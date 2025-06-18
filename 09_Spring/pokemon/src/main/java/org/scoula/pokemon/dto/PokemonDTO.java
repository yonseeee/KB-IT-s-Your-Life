package org.scoula.pokemon.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDTO {
    private List<TypesItem> types;
    private List<StatsItem> stats;
    private String name;
    private int weight;
    private int id;
    private Sprites sprites;
    private int height;
}
