package br.com.mello.Literalura.Model;

import br.com.mello.Literalura.DTO.LivroDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Autor autor;
    private String idiomas;
    private Integer numero_downloads;


    public Livro() {
    }

    public Livro(LivroDTO livroDTO) {
        this.titulo = livroDTO.getTitulo();
        this.autor = new Autor(livroDTO.getAutores().get(0));
        this.idiomas = livroDTO.getIdiomas().get(0);
        this.numero_downloads = livroDTO.getNumeroDownloads();
    }

    public Livro(Long id, String titulo, Autor autor, String idiomas, Integer numero_downloads) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idiomas = idiomas;
        this.numero_downloads = numero_downloads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumero_downloads() {
        return numero_downloads;
    }

    public void setNumero_downloads(Integer numero_downloads) {
        this.numero_downloads = numero_downloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "---------------Livro---------------" +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor.getNome() +
                "\nIdioma: " + getIdiomas() +
                "\nNumero de Downloads: " + getNumero_downloads() +
                "\n-----------------------------------";
    }
}
