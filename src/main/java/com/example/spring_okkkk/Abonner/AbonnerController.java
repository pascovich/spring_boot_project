package com.example.spring_okkkk.Abonner;

import com.example.spring_okkkk.Abonnement.Abonnement;
import com.example.spring_okkkk.Abonnement.AbonnementService;
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
public class AbonnerController {
    @Autowired
    private AbonnerService abnService;

    @Autowired private ClientService cltService;
    @Autowired private AbonnementService abnmService;
    @GetMapping("/abonner")
    public String showallclient(Model model){
        List<Abonner> listabonners = abnService.abonnerssAll();
        model.addAttribute("listabonners",listabonners);

        return "abonners";
    }
    @GetMapping("/abonner/new")
    public String showAbonnerForm(Model model){
        List<Client> cli = cltService.clientsAll();
        List<Abonnement> abnm = abnmService.abnnementAll();

        model.addAttribute("abonner", new Abonner());
        model.addAttribute("pageTitle", "Add new abonner");
        model.addAttribute("cli",cli);
        model.addAttribute("abnm",abnm);
        //return"abonner_html";
        return "ex";
    }
//    @PostMapping("/abonner/save")
//    public String saveClient(Abonner abonner, RedirectAttributes ra){
//        abnService.save(abonner);
//        ra.addFlashAttribute("message","abonner add successfuly");
//        return "redirect:/abonner";
//    }
    @PostMapping("/abonner/save")
    public String save(@RequestParam("date_abonnement") String date_abonnement,@RequestParam("ref_client") Integer ref_client,@RequestParam("ref_abonnement") Integer ref_abonnement,@RequestParam("montant") Float montant){
        abnService.insererabonner(date_abonnement,ref_client,ref_abonnement,montant);
        return "redirect:/abonner";
    }
}
