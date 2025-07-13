package br.edu.ifpr.controle_de_locadora_vhs.controladores;

import br.edu.ifpr.controle_de_locadora_vhs.entidades.Category;
import br.edu.ifpr.controle_de_locadora_vhs.servicos.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", new Category());
        return "category-list";
    }

    @GetMapping("/editar/{id}")
    public String showEditCategoryForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da Categoria inválido:" + id));
        model.addAttribute("category", category);
        return "category-edit-form";
    }

    @PostMapping("/salvar")
    public String saveCategory(@ModelAttribute("Category") Category category) {
        categoryService.save(category);
        return "redirect:/categorias";
    }

    @PostMapping("/excluir/{id}")
    public String deleteCategory(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        boolean isDeleted = categoryService.deleteById(id);

        if (!isDeleted) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Não é possível excluir a categoria, pois ela está associada a uma ou mais fitas.");
        }

        return "redirect:/categorias";
    }
}
