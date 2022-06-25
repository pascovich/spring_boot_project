package com.example.spring_okkkk.Consommation;

import com.example.spring_okkkk.Abonner.Abonner;
import com.example.spring_okkkk.Abonner.AbonnerService;
import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ConsommationController {
    @Autowired
    private ConsommationService cnsmmeService;
    @Autowired private AbonnerService abService;
    @GetMapping("/consommation")
    public String showallconsommation(Model model){
        List<Consommation> listconsommations = cnsmmeService.consommationsAll();
        model.addAttribute("listconsommations",listconsommations);

        return "consommations";
    }
    @GetMapping("/consommation/new")
    public String showConsommationForm(Model model){
        List<Abonner> abb = abService.abonnerssAll();
        model.addAttribute("consommationn",new Consommation());
        model.addAttribute("pageTitle", "Add new Consommation");
        model.addAttribute("abb",abb);
       // return"ex";
       return"consommation_form";
    }
//    @PostMapping("/consommation/save")
//    public String saveConsommation(Consommation consommation, RedirectAttributes ra){
//        cnsmmeService.save(consommation);
//        ra.addFlashAttribute("message","client add successfuly");
//        return "redirect:/consommation";
//    }
@PostMapping("/consommation/save")
public String save(@RequestParam("annee") Integer annee, @RequestParam("mois") String mois, @RequestParam("pu") Float pu, @RequestParam("puissance") Float puissance, @RequestParam("ref_abonner") Integer ref_abonner){
    cnsmmeService.insererconsommation(annee,mois,pu,puissance,ref_abonner);
    return "redirect:/consommation";
}
}
