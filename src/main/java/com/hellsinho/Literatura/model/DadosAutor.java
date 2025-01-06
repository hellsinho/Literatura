package com.hellsinho.Literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor (@JsonAlias("name") String name, @JsonAlias("death_year") Integer anoMorte) {
}
