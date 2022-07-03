package com.example.spring_okkkk.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClientController {
    @Autowired private ClientService cltService;
    @Autowired private ClientRepository repo;
    @Autowired private ShowRepository repo_vue;
    @GetMapping("/client")
    public String showallclient(Model model){
        List<Client> listclients = cltService.clientsAll();
        model.addAttribute("listclients",listclients);

        return "clients";
    }
    @GetMapping("/client/new")
    public String showClientForm(Model model){
        model.addAttribute("client", new Client());
        model.addAttribute("pageTitle", "Add new client");

        return"client_form";
    }
    @PostMapping("/client/save")
//    public String saveClient(Client client, RedirectAttributes ra){
//        cltService.save(client);
//        ra.addFlashAttribute("message","client add successfuly");
//        return "redirect:/client";
    public String insertClient(@RequestParam("nom") String nom,@RequestParam("postnom") String postnom,@RequestParam("prenom") String prenom,@RequestParam("sexe") String sexe,@RequestParam("telephone") String telephone,@RequestParam("adresse") String adresse,@RequestParam("describe") String describe,@RequestParam("photo") MultipartFile photo){
        cltService.insert(nom,postnom,prenom,sexe,telephone,adresse,describe,photo);
        return "redirect:/client";
    }
    @GetMapping("/client/edit/{id}")
    public String ShowClientEdit(@PathVariable("id") Integer id,Model model, RedirectAttributes ra){
        try {
            Client client = cltService.get(id);
            model.addAttribute("client",client);
            model.addAttribute("pageTitle", "Edit client(ID:"+id+")");
            return "client_form";

        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/client";
        }
    }
    @GetMapping("/client/delete/{id}")
    public String deletelient(@PathVariable("id") Integer id,RedirectAttributes ra){
        try {
            cltService.delete(id);
            ra.addAttribute("message", "the client (ID:"+id+") is deleted");
        } catch (ClientNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/client";
    }
    @GetMapping("/client_facture_paie/{id}")
    public String details_client_fac_paie(@PathVariable("id") int id,Model model, RedirectAttributes ra){

            Iterable<Show_vue> ggg=repo_vue.liste(id);
            model.addAttribute("ggg",ggg);
            //model.addAttribute("ggg",new Show_vue());
            return "client_details";

    }
}
