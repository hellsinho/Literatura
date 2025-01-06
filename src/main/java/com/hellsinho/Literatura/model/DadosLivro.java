package com.hellsinho.Literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro (@JsonAlias("title") String titulo, @JsonAlias("languages") List<String> idiomasList,
                          @JsonAlias("download_count") Integer numeroDownloads, @JsonAlias("authors") List<DadosAutor> autor){

    @Override
    public String toString() {
        String autores = autor.stream()
                .map(DadosAutor::name)
                .collect(Collectors.joining(", "));

        String idiomas = idiomasList.stream()
                .collect(Collectors.joining(", "));

        return "------ LIVRO ------" +
                "\n\nTítulo: " + titulo + '\'' +
                "\nIdiomas: " + idiomas +
                "\nNúmero Downloads= " + numeroDownloads +
                "\nAutor: " + autores;
    }
}
