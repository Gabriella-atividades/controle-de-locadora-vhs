package br.edu.ifpr.controle_de_locadora_vhs.repositorios;

import org.springframework.stereotype.Repository;
import br.edu.ifpr.controle_de_locadora_vhs.entidades.Category;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
