package com.example.spring_okkkk.Paiement;

import com.example.spring_okkkk.Consommation.Consommation;
import com.example.spring_okkkk.Consommation.ConsommationService;
import com.example.spring_okkkk.Facturation.Facturation;
import com.example.spring_okkkk.Facturation.FacturationService;
import com.example.spring_okkkk.Facturation.Facturationrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class PaiementController {
    @Autowired
    private PaiementService paieService;

    @Autowired
    private PaiementRepository repo_paie;

    @Autowired
    private Facturationrepository repo_fac;

    @Autowired
    private FacturationService facService;
    @GetMapping("/paiement")
    public String showallpaiement(Model model){
        List<Paiement> listpaiements = paieService.paiementsAll();
        model.addAttribute("listpaiements",listpaiements);

        return "paiements";
    }
    @GetMapping("/paiement/new")
    public String showPaiementForm(Model model){
        //List<Facturation> cs = facService.facturationsAll();
        List<Facturation> cs=repo_fac.listeFacNonfayer();

        model.addAttribute("paiement", new Paiement());
        model.addAttribute("pageTitle", "Add new Paiement");
        model.addAttribute("cs",cs);
       // model.addAttribute("cs",cs);

        return"paiement_form";
    }
//    @PostMapping("/paiement/save")
//    public String savePaiement(Paiement paiement, RedirectAttributes ra){
//        paieService.save(paiement);
//        ra.addFlashAttribute("message","Paiement add successfuly");
//        return "redirect:/paiement";
//    }
    @PostMapping("/paiement/save")
    public String save(@RequestParam("ref_facture") Integer ref_facture, @RequestParam("date_paie") String date_paie , @RequestParam("motif") String motif,@RequestParam("montant_a_payer") Float montant_a_payer,@RequestParam("montant_payer") Float montant_payer, RedirectAttributes ra){
        float montantAPayer= repo_paie.montantApayer(ref_facture);
        float resteFac = repo_paie.reste_fac(ref_facture);
        if(resteFac<montant_payer){
            ra.addFlashAttribute("error","le montant a payer pour cette facture est de "+montant_a_payer+" veillez donc entrer un montant inferieur ou egal a "+(montant_a_payer));
            return "redirect:/paiement/new";
        }else{
           // paieService.upfacreste(resteFac,montant_payer);
            Float px = montant_payer;
            Float new_r = resteFac-px;

            if(new_r==0){
                repo_paie.upreste(new_r,ref_facture);
                paieService.insererPaiement(date_paie,ref_facture,motif,montant_a_payer,montant_payer,resteFac);
                repo_paie.upfacetat(ref_facture);
            }else{
                repo_paie.upreste(new_r,ref_facture);
                paieService.insererPaiement(date_paie,ref_facture,motif,montant_a_payer,montant_payer,resteFac);
            }

            ra.addFlashAttribute("message","successfull order");
            return "redirect:/paiement";
        }

    }
}
