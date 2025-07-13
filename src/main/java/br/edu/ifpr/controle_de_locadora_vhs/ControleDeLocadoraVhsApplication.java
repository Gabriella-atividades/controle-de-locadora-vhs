package br.edu.ifpr.controle_de_locadora_vhs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.ifpr.controle_de_locadora_vhs.entidades.Usuario;
import br.edu.ifpr.controle_de_locadora_vhs.repositorios.UsuarioRepository;

@EnableJpaRepositories(basePackages = "br.edu.ifpr.controle_de_locadora_vhs.repositorios")
@SpringBootApplication

public class ControleDeLocadoraVhsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeLocadoraVhsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (usuarioRepository.findByUsername("admin").isEmpty()) {
				Usuario admin = new Usuario();
				admin.setUsername("admin");

				admin.setPassword("password"); //texto puro

				usuarioRepository.save(admin);
				System.out.println("Usuário 'admin' criado com a senha de texto 'password'");
			}
		};
	}
}
