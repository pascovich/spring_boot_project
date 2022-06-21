package com.example.spring_okkkk.Paiement;

import com.example.spring_okkkk.Facturation.Facturation;
import com.example.spring_okkkk.Facturation.FacturationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class PaiementController {
    @Autowired
    private PaiementService paieService;
    @GetMapping("/paiement")
    public String showallpaiement(Model model){
        List<Paiement> listpaiements = paieService.paiementsAll();
        model.addAttribute("listpaiements",listpaiements);

        return "paiements";
    }
    @GetMapping("/paiement/new")
    public String showPaiementForm(Model model){
        model.addAttribute("paiement", new Paiement());
        model.addAttribute("pageTitle", "Add new Paiement");

        return"paiement_form";
    }
    @PostMapping("/paiement/save")
    public String savePaiement(Paiement paiement, RedirectAttributes ra){
        paieService.save(paiement);
        ra.addFlashAttribute("message","Paiement add successfuly");
        return "redirect:/paiement";
    }
}
