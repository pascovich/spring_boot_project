package com.example.spring_okkkk;

import com.example.spring_okkkk.Abonnement.AbExcel;
import com.example.spring_okkkk.Abonnement.AbPdf;
import com.example.spring_okkkk.Abonnement.Abonnement;
import com.example.spring_okkkk.Abonnement.AbonnementRepository;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
    @GetMapping("")
    public String homepage(){
        return "index";
    }

    @Autowired
    AbonnementRepository rep_ab;

    @Autowired
    AbPdf abpdf;

    @GetMapping("/sale/excel")
    public void excelSalle(HttpServletResponse response)throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentateTime=dateFormatter.format(new Date(0));
        String headerkey="Content-Disposition";
        String headerValue="attachment;filename=LISTE DE SALLE"+currentateTime+".xlsx";
        response.setHeader(headerkey,headerValue);
        Iterable<Abonnement> listeab=rep_ab.findAll();
        AbExcel excelExporter=new AbExcel(listeab);
        excelExporter.export(response);

    }
    @GetMapping("/sale/pdf")
    public void exporttoPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentateTime=dateFormatter.format(new Date(0));
        String headerkey="Content-Disposition";
        String headerValue="attachment;filename=LISTE DE SALLE"+currentateTime+".pdf";
        response.setHeader(headerkey,headerValue);
        //abpdf.export(response);
        abpdf.export(response,1);
    }
}
