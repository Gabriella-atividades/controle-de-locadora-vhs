package br.edu.ifpr.controle_de_locadora_vhs.servicos;

import br.edu.ifpr.controle_de_locadora_vhs.entidades.Category;
import br.edu.ifpr.controle_de_locadora_vhs.repositorios.CategoryRepository;
import br.edu.ifpr.controle_de_locadora_vhs.repositorios.VHSRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VHSRepository vhsRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public boolean deleteById(Long id) {
        if (vhsRepository.countByCategoryId(id) > 0) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
