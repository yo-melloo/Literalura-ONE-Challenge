package br.com.mello.Literalura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PesquisaDTO {

    @JsonAlias("results")
    private List<LivroDTO> resultados;

    public List<LivroDTO> getResultados() {
        return resultados;
    }

    @Override
    public String toString() {
        return "PesquisaDTO{" +
                "resultados=" + resultados +
                '}';
    }
}