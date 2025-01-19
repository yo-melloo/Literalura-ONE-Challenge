package br.com.mello.Literalura;

import br.com.mello.Literalura.Menu.MenuPrincipal;
import br.com.mello.Literalura.repository.AutorRepository;
import br.com.mello.Literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MenuPrincipal menu = new MenuPrincipal(autorRepository, livroRepository);

		menu.iniciar();
	}
}
