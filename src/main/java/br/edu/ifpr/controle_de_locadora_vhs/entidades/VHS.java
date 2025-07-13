package br.edu.ifpr.controle_de_locadora_vhs.entidades;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
public class VHS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres.")
    private String title;

    @NotBlank(message = "O nome do diretor não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O nome do diretor deve ter entre 3 e 100 caracteres.")
    private String director;

    private String imageUrl;

    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "A categoria é obrigatória.")
    private Category category;

    @Enumerated(EnumType.STRING)
    private TapeStatus status;
}
