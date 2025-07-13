package br.edu.ifpr.controle_de_locadora_vhs.repositorios;

import br.edu.ifpr.controle_de_locadora_vhs.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
