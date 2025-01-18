package br.com.mello.Literalura;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner entrada = new Scanner(System.in);
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URI_API = "https://gutendex.com/books/";
    private final String paramPesquisaAutorTitulo = "?search=";

    public void iniciar() {
        String pesquisa = "dom Casmurro".replace(" ", "%20");
//        String pesquisaEncoded = URLEncoder.encode(pesquisa, StandardCharsets.UTF_8);
        String endereco = URI_API + paramPesquisaAutorTitulo + pesquisa;

        System.out.println("Olá Mundo!");
        System.out.println("Endereço gerado: " + endereco);
        String resposta = consumoAPI.realizarConsulta(endereco);
        System.out.println("resposta da API: " + resposta);

    }
}
