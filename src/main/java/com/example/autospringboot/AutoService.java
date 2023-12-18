package com.example.autospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AutoService {

    private final AutoRepository autoRepository;

    @Autowired
    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> getAllAuto() {
        return autoRepository.findAll();
    }

    public Optional<Auto> getAutoById(Long id) {
        return autoRepository.findById(id);
    }

    public void addAuto(Auto auto) {
        autoRepository.save(auto);
    }

    public void updateAuto(Auto auto) {
        autoRepository.save(auto);
    }

    public void deleteAuto(Long id) {
        autoRepository.deleteById(id);
    }

    public List<Auto> findAutoByModel(String model) {
        return autoRepository.findByModelIgnoreCase(model);
    }
}