package com.example.spring_okkkk.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientController {
    @Autowired private ClientService cltService;
    @GetMapping("/client")
    public String showallclient(Model model){
        List<Client> listclients = cltService.clientsAll();
        model.addAttribute("listclients",listclients);

        return "clients";
    }
}
