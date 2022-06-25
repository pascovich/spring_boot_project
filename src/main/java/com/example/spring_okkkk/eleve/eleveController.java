package com.example.spring_okkkk.eleve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class eleveController {
    @Autowired EleveService eleveS;
    @Autowired EleveR eleveR;
    @GetMapping("/eleve/call")
    public String call(Model model){
        Iterable<Eleve> liste=eleveR.findAll();
        model.addAttribute("liste",liste);
        return "eleve";
    }
    @PostMapping("/save/eleve")
    public String save(@RequestParam("nom") String nom_eleve){
        eleveS.inserereleve(nom_eleve);
        return "redirect:/eleve/call";
    }
}
