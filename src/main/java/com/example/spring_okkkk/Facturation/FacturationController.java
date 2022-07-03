package com.example.spring_okkkk.Facturation;

import com.example.spring_okkkk.Abonner.Abonner;
import com.example.spring_okkkk.Client.Show_vue;
import com.example.spring_okkkk.Consommation.Consommation;
import com.example.spring_okkkk.Consommation.ConsommationRepository;
import com.example.spring_okkkk.Consommation.ConsommationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FacturationController {
    @Autowired
    private FacturationService factService;
    @Autowired
    private ConsommationService conService;

    @Autowired
    private Facturationrepository repo_fac;

    @Autowired
    private ConsommationRepository repo_con;
    @GetMapping("/facturation")
    public String showallfacturation(Model model){
        List<Facturation> listfacturations = factService.facturationsAll();
        model.addAttribute("listfacturations",listfacturations);

        return "facturations";
    }
    @GetMapping("/facturation/new")
    public String showFacturationForm(Model model, RedirectAttributes ra){
        //List<Consommation> fc = conService.consommationsAll();
        List<Consommation> fc=repo_con.listeConNonPacturer();
        model.addAttribute("facturation", new Facturation());
        model.addAttribute("pageTitle", "Add new facturation");
        model.addAttribute("fc",fc);

        return"facturation_form";
    }

//    @PostMapping("/facturation/save")
//    public String saveFacturation(Facturation facturation, RedirectAttributes ra){
//        factService.save(facturation);
//        ra.addFlashAttribute("message","facturation add successfuly");
//        return "redirect:/facturation";
//    }
    @PostMapping("/facturation/save")
    public String save(@RequestParam("numero_facture") String numero_facture,@RequestParam("ref_consommation") Integer ref_consommation ,@RequestParam("montant_facture") Float montant_facture,RedirectAttributes ra){
        float total= repo_fac.total(ref_consommation);
        if(montant_facture!=total){
            ra.addFlashAttribute("error","le montant a facturer pour cette conxommation est de "+total+" veillez donc entrer un montant ou egal a "+(total));
            return "redirect:/facturation/new";
        }else
        {
            factService.insererfacuration(numero_facture,ref_consommation,montant_facture);
            repo_fac.upConsetat(ref_consommation);
            ra.addFlashAttribute("message","successfull");
            return "redirect:/facturation";
        }

    }
}
