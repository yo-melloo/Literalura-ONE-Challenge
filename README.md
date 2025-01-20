<div align="center">
  
# Literalura

![licensa do repositorio](https://img.shields.io/badge/LICENSA-MIT-blue)
![status do projeto](https://img.shields.io/badge/STATUS-FINALIZADO-GREEN)
![estrelas do projeto](https://img.shields.io/github/stars/yo-melloo?style=social)

</div>

Desenvolvido em Java e utilizando a API Gutendex, o Literalura é um gerenciador de registros de Livros e Autores. Podendo fazer cadastro, consulta e filtragem de dados, como listar livros registrados, buscar livros por título, listar autores e até filtrar autores vivos em um determinado ano. 



## 💻 Funcionalidades

- Buscar livros pelo título: Permite buscar livros através da API Gutendex. Exibe o primeiro resultado encontrado, e o registra no banco de dados.
- Lista de livros registrados: Exibe todos os livros registrados pelo sistema.
- Lista de autores registrados: Exibe todos os autores cadastrados pelo sistema.
- Filtrar autores vivos em determinado ano: Permite consultar quais autores registrados estavam vivos em um determinado ano.
- Listar livros por idioma: Filtra os livros registrados no sistema pelo idiomas disponíveis: Português, Inglês, Espanhol, Francês.


## 📦 Instalação

1. Clonar o repositório
Clone o repositório em sua máquina:

``` git
git clone https://github.com/yo-melloo/Literalura-ONE-Challenge.git
cd LitterAlura
```

2. Configurar o Banco de Dados
Para que persistência de dados funcione, configure um banco de dados (usando Spring Data JPA) para a aplicação, e ajuste as configurações no arquivo `application.properties`.

3. Executar o Programa
Para rodar a aplicação, basta compilar e executar a classe `Menu`:

``` cmd
javac com/abinadabedev/LitterAlura/menu/Menu.java
java com.abinadabedev.LitterAlura.menu.Menu
```

4. Interagir com o Sistema
O menu será exibido no terminal após a inicialzação com as seguintes opções:

```
***Opções para escolha***
1 - Buscar livros pelo título.
2 - Lista de Livros registrados.
3 - Lista de autores registrados.
4 - Lista de autores registrados vivos em determinado ano.
5 - Lista de livros por idioma.
0 - Sair.
```

Basta digitar o número correspondente à ação desejada e seguir as instruções.
    
## 🛠️ Tecnologias Utilizadas
* Java 22
* Spring Data JPA
* API Gutendex
* Padrão DTO (Data Transfer Object) para manipulação de dados
* Repository Pattern para abstração do acesso ao banco de dados
## ⚙️ Funcionamento
### Estrutura do Sistema
- **Menu**: Apresenta as opções de interação com a aplicação.
- **LivroRepository** e **AutorRepository**: Interfaces responsáveis pela interação com o banco de dados para salvar e consultar livros e autores.
- **ConsumoApi**: Realiza as requisições à API Gutendex para buscar os livros.
- **ConverteDados**: Converte os dados obtidos da API para objetos Java.

### Exemplos de Operações com a API
- **Buscar livro por título**: Ao escolher a opção de busca por título, o sistema solicita o nome do livro, realiza a busca via API e registra o primeiro livro encontrado no banco de dados.

- **Filtrar autores por ano**: Na opção de autores vivos em determinado ano, o usuário informa o ano desejado, e o sistema retorna a lista de autores registrados no banco, que estavam vivos nesse período.

- **Listar livros por idioma**: Permite ao usuário filtrar livros registrados no banco conforme o idioma.
## Autores

- [@yo-melloo](https://github.com/yo-melloo) - Autor
- README baseado no projeto de: [@AbinadabeDev](https://github.com/AbinadabeDev)

