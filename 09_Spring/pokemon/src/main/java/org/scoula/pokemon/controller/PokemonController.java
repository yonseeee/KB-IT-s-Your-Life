package org.scoula.pokemon.controller;


import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.scoula.pokemon.dto.PokemonDTO;
import org.scoula.pokemon.dto.PokemonListWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.scanners.ApiListingScanner;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/pokemon")
@PropertySource({"classpath:/application.properties"})
@Api(tags = "포켓몬 도감 API")
public class PokemonController {
    private final ApiListingScanner apiListingScanner;
    @Value("${pokemon.url}")
    private String URL;

    public PokemonController(ApiListingScanner apiListingScanner) {
        this.apiListingScanner = apiListingScanner;
    }

    @ApiOperation(value = "포켓몬 목록 상세 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = PokemonListWrapper.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping("/list")
    public List<PokemonDTO> pokemon() {
        RestTemplate restTemplate = new RestTemplate();

        String listUrl = URL + "?limit=20";

        PokemonListWrapper listWrapper = restTemplate.getForObject(listUrl, PokemonListWrapper.class);

        List<PokemonDTO> detailedList = new ArrayList<>();

        for (PokemonListWrapper.SimplePokemon simple : listWrapper.getResults()) {
            PokemonDTO pokemon = restTemplate.getForObject(simple.getUrl(), PokemonDTO.class);
            detailedList.add(pokemon);
        }

        return detailedList;
    }

    @ApiOperation(value = "포켓몬 상세 정보 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = PokemonDTO.class),
            @ApiResponse(code = 404, message = "해당 이름의 포켓몬을 찾을 수 없습니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping("/{poke}")
    public ResponseEntity<?> getPokemon(
            @ApiParam(value = "", required = true, example = "pikachu")
            @PathVariable(value = "poke") String poke) {
        RestTemplate restTemplate = new RestTemplate();

        String listUrl = URL + "/" + poke;

        try {
            PokemonDTO dto = restTemplate.getForObject(listUrl, PokemonDTO.class);
            return ResponseEntity.ok(dto);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.
                    status(404)
                    .header("Content-Type", "text/plain;charset=utf-8")
                    .body("해당 이름의 포켓몬을 찾을 수 없습니다."+poke);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .header("Content-Type", "text/plain;charset=utf-8").body("서버 오류가 발생했습니다");
        }
    }
}
