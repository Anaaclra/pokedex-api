package com.project.pokedex.service;

import com.project.pokedex.entities.Pokemon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final List<Pokemon> pokemons = new ArrayList<>();

    public void adicionarPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon); //Criei um objeto pra listar os pokemons
    }

    //mudar a repetição for para filter exemplos no site baeldung
   public Pokemon buscarPokemon(Integer numero) {
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon pokemon = pokemons.get(i);
            if (pokemon.getNumero().equals(numero)) {//puxei getNumero da classe de entities
                return pokemon;
            }
        }
        return null;
    }
}
