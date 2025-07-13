package br.edu.ifpr.controle_de_locadora_vhs.controladores;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.ifpr.controle_de_locadora_vhs.entidades.VHS;
import br.edu.ifpr.controle_de_locadora_vhs.servicos.VHSService;
import jakarta.validation.Valid;
import br.edu.ifpr.controle_de_locadora_vhs.repositorios.CategoryRepository;
import java.time.LocalDate;
import br.edu.ifpr.controle_de_locadora_vhs.entidades.TapeStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/vhs")
public class VHSController {


    @Autowired
    VHSService vhsService;


    @GetMapping
    public String findAll(Model model) {
        List<VHS> vhsList = vhsService.findAll();
        model.addAttribute("vhsList", vhsList);
        return "vhs-list";
    }


    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("/novo")
    public String showForm(Model model) {
        model.addAttribute("vhs", new VHS());


        model.addAttribute("allCategories", categoryRepository.findAll());


        return "vhs-form";
    }


@PostMapping
public String saveVHS(@Valid @ModelAttribute("vhs") VHS vhs, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("allCategories", categoryRepository.findAll());
        return "vhs-form";
    }

    if (vhs.getId() != null) {
        LocalDate registrationDate = vhsService.findById(vhs.getId())
                .map(VHS::getRegistrationDate)
                .orElse(LocalDate.now());
        vhs.setRegistrationDate(registrationDate);
    } else {
        vhs.setRegistrationDate(LocalDate.now());
        vhs.setStatus(TapeStatus.DISPONIVEL);
    }

    vhsService.save(vhs);
    return "redirect:/vhs";
}


    @PostMapping("/excluir/{id}")
    public String deleteVHS(@PathVariable("id") Long id) {
        vhsService.deleteById(id);
        return "redirect:/vhs";
    }


    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        VHS vhs = vhsService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID da Fita inválido:" + id));


        model.addAttribute("vhs", vhs);
        model.addAttribute("allCategories", categoryRepository.findAll());


        return "vhs-form";
    }


    @GetMapping("/status/{id}")
public String showStatusForm(@PathVariable("id") Long id, Model model) {
    VHS vhs = vhsService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID da Fita inválido:" + id));
    model.addAttribute("vhs", vhs);
    return "status-form";
}


@PostMapping("/status")
public String updateStatus(@ModelAttribute("vhs") VHS vhs) {
    vhsService.save(vhs);
    return "redirect:/vhs";
}
}
