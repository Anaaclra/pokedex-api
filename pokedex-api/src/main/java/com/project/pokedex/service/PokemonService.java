package com.project.pokedex.service;

import com.project.pokedex.entities.Pokemon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PokemonService {

    private final List<Pokemon> pokemons = new ArrayList<>();

    //post
    public void adicionarPokemon(Pokemon pokemon) {
        Pokemon pokemonEncontrado = buscarPokemon(pokemon.getNumero());
        if(pokemonEncontrado != null) {
            throw new IllegalArgumentException("Não é possível adicionar um novo pokemon com um numero já existente.");
        }
        this.pokemons.add(pokemon);
    }

    //get
    //implementado stream filter no get e put
    public Pokemon buscarPokemon(Integer numero) {
        return pokemons.stream()
                .filter(pokemon -> pokemon.getNumero().equals(numero)) //
                .findFirst() //Pega o primeiro pokemon que passar no filtro
                .orElse(null); //Retorne nulo
    }

    //put
    public boolean atualizarPokemon(Integer numero, Pokemon novoPokemon) {
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon atual = pokemons.get(i);
            if (atual.getNumero().equals(numero)) {
                pokemons.set(i, novoPokemon); // Atualiza o Pokémon na posição i
                return true; // Atualização feita com sucesso
            }
        }
        return false; // Nenhum Pokémon com o número informado foi encontrado
    }

    //delete
    public boolean deletarPokemon(Integer numero) {
        return pokemons.removeIf(pokemon -> pokemon.getNumero().equals(numero));
    }
}

