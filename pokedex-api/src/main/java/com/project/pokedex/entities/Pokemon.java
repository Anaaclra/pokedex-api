package com.project.pokedex.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {

    private Integer numero; //ID
    private String nome;
    private List<String> tipos;


}

