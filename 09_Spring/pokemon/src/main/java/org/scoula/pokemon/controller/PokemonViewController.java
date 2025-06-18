package org.scoula.pokemon.controller;


import lombok.extern.log4j.Log4j2;
import org.scoula.pokemon.dto.PokemonDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Controller
@Log4j2
@PropertySource({"classpath:/application.properties"})
public class PokemonViewController {

    @Value("${pokemon.url}")
    private String URL;

    @GetMapping("/random")
    public String random(Model model) {
        int randomId = new Random().nextInt(1010) + 1;
        String url = URL + "/" + randomId;

        RestTemplate restTemplate = new RestTemplate();
        PokemonDTO randomPokemon = restTemplate.getForObject(url, PokemonDTO.class);

        model.addAttribute("pokemon", randomPokemon);
        return "random";
    }
}
