package br.edu.ifpr.controle_de_locadora_vhs.repositorios;

import org.springframework.stereotype.Repository;
import br.edu.ifpr.controle_de_locadora_vhs.entidades.VHS;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VHSRepository extends JpaRepository<VHS, Long> {
    long countByCategoryId(Long categoryId);
}
