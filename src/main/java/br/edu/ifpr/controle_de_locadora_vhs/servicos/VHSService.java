package br.edu.ifpr.controle_de_locadora_vhs.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpr.controle_de_locadora_vhs.entidades.VHS;
import br.edu.ifpr.controle_de_locadora_vhs.repositorios.VHSRepository;

@Service
public class VHSService {

    @Autowired
    VHSRepository vhsRepository;

    public List<VHS> findAll() {
        return vhsRepository.findAll();
    }

    public void save(VHS vhs) {
        vhsRepository.save(vhs);
    }

    public void deleteById(Long id) {
        vhsRepository.deleteById(id);
    }

    public Optional<VHS> findById(Long id) {
        return vhsRepository.findById(id);
    }
}