package com.example.spring_okkkk.Consommation;

import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ConsommationController {
    @Autowired
    private ConsommationService cnsmmeService;
    @GetMapping("/consommation")
    public String showallconsommation(Model model){
        List<Consommation> listconsommations = cnsmmeService.consommationsAll();
        model.addAttribute("listconsommations",listconsommations);

        return "consommations";
    }
    @GetMapping("/consommation/new")
    public String showConsommationForm(Model model){
        model.addAttribute("consommation", new Consommation());
        model.addAttribute("pageTitle", "Add new Consommation");

        return"ex";
       //return"consommation_form";
    }
    @PostMapping("/consommation/save")
    public String saveConsommation(Consommation consommation, RedirectAttributes ra){
        cnsmmeService.save(consommation);
        ra.addFlashAttribute("message","client add successfuly");
        return "redirect:/consommation";
    }
}
