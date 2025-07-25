package com.project.pokedex.controller;

import com.project.pokedex.entities.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.pokedex.service.PokemonService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    // Endpoint POST
    //implementado exceção
    @PostMapping
    public ResponseEntity<String> adicionarPokemon(@RequestBody Pokemon pokemon) {
        try {
            pokemonService.adicionarPokemon(pokemon);
            return ResponseEntity.status(HttpStatus.CREATED).body("Pokemon registrado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint GET
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPokemon(@PathVariable Integer id) {
        Pokemon pokemon = pokemonService.buscarPokemon(id);
        if (pokemon != null) {
            return ResponseEntity.ok(pokemon);
        } else {
            return ResponseEntity.noContent().build(); // retorna 204 se não encontra o pokemon na base.
        }
    }

     // Endpoint PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPokemon(@PathVariable Integer id, @RequestBody Pokemon novoPokemon) {
        boolean atualizado = pokemonService.atualizarPokemon(id, novoPokemon);
        if (atualizado) {
            return ResponseEntity.ok("Pokemon atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não encontrado.");
        }
    }
    // Endpoint DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPokemon(@PathVariable Integer id) {
        boolean removido = pokemonService.deletarPokemon(id);
        if (removido) {
            return ResponseEntity.ok("Pokemon removido com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não encontrado.");
        }
    }
}

