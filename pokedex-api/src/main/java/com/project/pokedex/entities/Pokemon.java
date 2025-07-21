package com.project.pokedex.entities;


import java.util.List;


public class Pokemon {

    private Integer numero; //ID
    private String nome;
    private List<String> tipos;

    //Construtores
    public Pokemon(Integer numero, String nome, List<String> tipos) {
        this.numero = numero;
        this.nome = nome;
        this.tipos = tipos;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

}

