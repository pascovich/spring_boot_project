package com.example.spring_okkkk.Facturation;

import com.example.spring_okkkk.Consommation.Consommation;
import com.example.spring_okkkk.Consommation.ConsommationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FacturationController {
    @Autowired
    private FacturationService factService;
    @GetMapping("/facturation")
    public String showallfacturation(Model model){
        List<Facturation> listfacturations = factService.facturationsAll();
        model.addAttribute("listfacturations",listfacturations);

        return "facturations";
    }
    @GetMapping("/facturation/new")
    public String showFacturationForm(Model model){
        model.addAttribute("Facturation", new Facturation());
        model.addAttribute("pageTitle", "Add new facturation");

        return"facturation_form";
    }
    @PostMapping("/facturation/save")
    public String saveFacturation(Facturation facturation, RedirectAttributes ra){
        factService.save(facturation);
        ra.addFlashAttribute("message","facturation add successfuly");
        return "redirect:/facturation";
    }
}
