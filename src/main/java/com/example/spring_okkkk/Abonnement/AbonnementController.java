package com.example.spring_okkkk.Abonnement;

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
public class AbonnementController {
    @Autowired
    private AbonnementService abnmentService;
    @GetMapping("/abonnement")
    public String showallabonnement(Model model){
        List<Abonnement> listabonnements = abnmentService.abnnementAll();
        model.addAttribute("listabonnements",listabonnements);

        return "abonnements";
    }
    @GetMapping("/abonnement/new")
    public String showAbonnementForm(Model model){
        model.addAttribute("abonnement", new Abonnement());
        model.addAttribute("pageTitle", "Add new Abonnement");

        return"abonnement_form";
    }
    @PostMapping("/abonnement/save")
    public String saveAbonnement(Abonnement abonnement, RedirectAttributes ra){
        abnmentService.save(abonnement);
        ra.addFlashAttribute("message","abonnement add successfuly");
        return "redirect:/abonnement";
    }
}
