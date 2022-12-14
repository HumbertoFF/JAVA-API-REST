package ufrn.br.ProjetoRestJustica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ufrn.br.ProjetoRestJustica.model.pojo.Usuario;
import ufrn.br.ProjetoRestJustica.repository.UsuarioRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetoRestJusticaApplication {

	@Autowired
	private UsuarioRepository repository;

	@PostConstruct
	public void initUsers() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		List<Usuario> users = Stream.of(
				new Usuario(1L, "Manoel","manoel@gmail.com", "admin", encoder.encode("admin"), "ROLE_ADMIN"),
				new Usuario(2L, "João","joao@gmail.com", "user1", encoder.encode("user1"), "ROLE_USER"),
				new Usuario(3L, "Maria","maria@gmail.com", "user2", encoder.encode("user2"), "ROLE_USER")
		).collect(Collectors.toList());

		repository.saveAll(users);

	}
	public static void main(String[] args) {
		SpringApplication.run(ProjetoRestJusticaApplication.class, args);
	}

}
