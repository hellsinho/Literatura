package com.hellsinho.Literatura.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Livro {
    private String titulo;
    private String idioma;
    private Integer numeroDownloads;
    private String nomeAutor;
    private DadosAutor autor;

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.idioma = dadosLivro.idiomasList().stream().collect(Collectors.joining(", "));
        this.numeroDownloads = dadosLivro.numeroDownloads();
        this.autor = dadosLivro.autor().get(0);
        this.nomeAutor = autor.name();
    }

    @Override
    public String toString() {

        return "------ LIVRO ------" +
                "\n\nTítulo: " + titulo + '\'' +
                "\nIdiomas: " + idioma +
                "\nNúmero Downloads= " + numeroDownloads +
                "\nAutor: " + nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

}
