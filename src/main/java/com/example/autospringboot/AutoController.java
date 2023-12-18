package com.example.autospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {

        this.autoService = autoService;
    }

    @GetMapping
    public List<Auto> getAllAuto() {

        return autoService.getAllAuto();
    }

    @GetMapping("/{id}")
    public Auto getAutoById(@PathVariable Long id) {

        return autoService.getAutoById(id).orElse(null);
    }

    @GetMapping("/find")
    public List<Auto> findAutoByModel(@RequestParam(name="model") String model) {
        return autoService.findAutoByModel(model);
    }

    @PostMapping
    public void addAuto(@RequestBody Auto auto) {
        autoService.addAuto(auto);
    }

    @PutMapping("/{id}")
    public void updateAuto(@PathVariable Long id, @RequestBody Auto auto) {
        auto.setId(id);
        autoService.updateAuto(auto);
    }

    @DeleteMapping("/{id}")
    public void deleteAuto(
            @PathVariable Long id) {
        autoService.deleteAuto(id);
    }
}