package com.example.autospringboot;

// Импорты и остальной код

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Замените import
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.autospringboot.AutoService;
import com.example.autospringboot.Auto;

import java.util.List;

@Controller // Замените @RestController
@RequestMapping("/auto-html")
public class AutoHtmlController {

    private final AutoService autoService;

    @Autowired
    public AutoHtmlController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public String getAutoHtml(Model model) {
        List<Auto> autos = autoService.getAllAuto();
        model.addAttribute("autos", autos);
        return "auto"; // Имя шаблона без расширения (.html)
    }
}
