package br.com.mello.Literalura.Menu;

import br.com.mello.Literalura.DTO.LivroDTO;
import br.com.mello.Literalura.DTO.PesquisaDTO;
import br.com.mello.Literalura.Model.Autor;
import br.com.mello.Literalura.Model.Livro;
import br.com.mello.Literalura.repository.AutorRepository;
import br.com.mello.Literalura.repository.LivroRepository;
import br.com.mello.Literalura.service.ConsumoAPI;
import br.com.mello.Literalura.service.ConversorDeDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner entrada = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConversorDeDados conversorDeDados = new ConversorDeDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private List<Autor> autoresList = new ArrayList<>();
    private List<Livro> livroList = new ArrayList<>();

    public MenuPrincipal(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    public void iniciar() {
        int escolha = -1;
        while (escolha != 0) {
            var menu = """
                    ***Opções para escolha***
                    1 - Buscar livros pelo título.
                    2 - Lista de Livros registrados.
                    3 - Lista de autores registrados.
                    4 - Lista de autores registrados vivos em determinado ano.
                    5 - Lista de livros por idioma.

                    0 - Sair.
                    """;

            System.out.println(menu);
            System.out.print("> ");
            escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1:
                    buscarLivrosPorTitulo();
                    break;
                case 2:
                    listaDeLivrosRegistrados();
                    break;
                case 3:
                    listaDeAutoresRegistrados();
                    break;
                case 4:
                    listaDeAutoresVivosEmDeterminadoAno();
                    break;
                case 5:
                    listaLivrosEmDeterminadoIdioma();
                    break;
                case 0:
                    System.out.println("Encerrando aplicação...");
                    System.out.println("Até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        entrada.close();
    }

    private void buscarLivrosPorTitulo() {
        PesquisaDTO pesquisaDTO = obterDadosDaPesquisa();

        // "Se pesquisaDTO não estiver nulo ou vazio":
        if (pesquisaDTO.getResultados() != null && !pesquisaDTO.getResultados().isEmpty()) {
            // Obtém o primeiro livro:
            LivroDTO livroBuscado = pesquisaDTO.getResultados().get(0);
            Livro livro = new Livro(livroBuscado);
            System.out.println(livro);
            livroRepository.save(livro);
        } else {
            System.out.println("Nenhum livro encontrado.");
        }
    }

    private void listaDeLivrosRegistrados() {
        livroList = livroRepository.findAll();

        if (livroList.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            livroList.forEach(System.out::println);
        }
    }

    private void listaDeAutoresRegistrados() {
        autoresList = autorRepository.findAll();

        if (autoresList.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            autoresList.forEach(System.out::println);
        }
    }

    private void listaDeAutoresVivosEmDeterminadoAno() {
        System.out.println("Insira o ano que deseja pesquisar:");
        Integer ano = entrada.nextInt();
        autoresList = autorRepository.findAllByAno(ano);

        if (autoresList.isEmpty()) {
            System.out.println("Nenhum autor registrado.");
        } else {
            autoresList.forEach(System.out::println);
        }
    }

    private void listaLivrosEmDeterminadoIdioma() {
        System.out.println("""
                Digite o idioma que deseja escolher:
                Pt - Português
                En - Inglês
                Es - Espanhol
                Fr - Francês
                """);

        String idiomaEscolhido = entrada.nextLine();
        livroList = livroRepository.findAllByIdioma(idiomaEscolhido);

        if (livroList.isEmpty()) {
            System.out.println("Idioma não encontrado.");
        } else {
            livroList.forEach(System.out::println);
        }
    }


    private PesquisaDTO obterDadosDaPesquisa() {
        System.out.println("Digite o nome do livro que deseja buscar: ");
        String nomeLivro = entrada.nextLine();
        String json = consumoApi.realizarConsulta(ENDERECO + nomeLivro.replace(" ", "%20"));
        return conversorDeDados.obterDados(json, PesquisaDTO.class);
    }

}
