package br.com.mello.Literalura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroDTO {
    @JsonAlias("title")
    private String titulo;

    @JsonAlias("authors")
    private List<AutorDTO> autores;

    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("download_count")
    private Integer numeroDownloads;

    public String getTitulo() {
        return titulo;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    @Override
    public String toString() {
        return "LivroDto{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas=" + idiomas +
                ", numeroDownloads=" + numeroDownloads +
                '}';
    }
}