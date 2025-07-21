package com.project.pokedex.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/pokemon")
public class PokemonController {

    //Ajustar o post para que seja possível registrar novos pokemons
    // Exemplo Estrutura JSON: { "numero":1, "nome":"Bulbasauro", "tipos": ["grama","venenoso"]}
    @PostMapping
    public String adicionarPokemon() {
        return "Registra Pokemons";
    }

    @GetMapping("/{id")
    public String buscarPokemon(@PathVariable Integer id) {
        return "Meu Pokemon" + id;
        //"204"
    }

    //Incluir mais dois endpoints e realizar seus devidos testes através do postman
    // Endpoint PUT
    // Endpoint DELETE
}
