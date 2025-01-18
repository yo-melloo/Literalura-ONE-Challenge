package br.com.mello.Literalura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String realizarConsulta(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("Sucesso!");
//            System.out.println(response.statusCode());
//            System.out.println(response.headers());
        } catch (InterruptedException | IOException e) {
        System.out.println("Erro na requisição:");
//        e.printStackTrace();
        throw new RuntimeException("Falha na requisição à API", e);
    }


        return response.body();
    }
}

