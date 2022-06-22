package com.example.spring_okkkk.Abonner;

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
public class AbonnerController {
    @Autowired
    private AbonnerService abnService;
    @GetMapping("/abonner")
    public String showallclient(Model model){
        List<Abonner> listabonners = abnService.abonnerssAll();
        model.addAttribute("listabonners",listabonners);

        return "abonners";
    }
    @GetMapping("/abonner/new")
    public String showAbonnerForm(Model model){
        model.addAttribute("abonner", new Abonner());
        model.addAttribute("pageTitle", "Add new abonner");

        return"abonner_html";
    }
    @PostMapping("/abonner/save")
    public String saveClient(Abonner abonner, RedirectAttributes ra){
        abnService.save(abonner);
        ra.addFlashAttribute("message","abonner add successfuly");
        return "redirect:/abonner";
    }
}
