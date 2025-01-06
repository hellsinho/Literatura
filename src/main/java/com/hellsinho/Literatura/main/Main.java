package com.hellsinho.Literatura.main;

import com.hellsinho.Literatura.model.DadosLivro;
import com.hellsinho.Literatura.model.Livro;
import com.hellsinho.Literatura.model.Response;
import com.hellsinho.Literatura.service.ConsumoApi;
import com.hellsinho.Literatura.service.ConverterDados;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consome = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();
    public void menu(){
        System.out.println("""
                --------------------------------------------
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros em um determinado idioma
                0 - sair
                --------------------------------------------
                """);
    }

    public void obterMenu(){
        var opcao = -1;
        while (opcao != 0){
            menu();
            System.out.println("Digite a opção desejada: ");
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosNoAno();
                    break;
                case 5:
                    ListarLivroPorIdioma();
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private void buscarLivroPeloTitulo() {
        Response dadosLivro = getDadosLivro();

        Livro livro = new Livro(dadosLivro.results().get(0));
        System.out.println(livro);

//        System.out.println(dadosLivro.results().get(0));

    }

    private Response getDadosLivro(){
        System.out.println("Digite o nome do livro: ");
        var nomeLivro = leitura.nextLine();

        var json = consome.obterDados("http://gutendex.com/books/?search=" + nomeLivro.replace(" ", "+").toLowerCase());
        Response dados = conversor.obterDados(json, Response.class);
        return dados;
    }

    private void listarLivrosRegistrados() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarAutoresVivosNoAno() {
        
    }

    private void ListarLivroPorIdioma() {
    }
}
