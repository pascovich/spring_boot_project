package com.example.spring_okkkk;


import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientRepository;
import com.example.spring_okkkk.Facturation.Facturation;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Component
public class PdfFacture {
    @Autowired
    PdfFactureRepository fac_repo;
    @Autowired
    ClientRepository clientRepository;

    private  void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.black);
        cell.setPhrase(new Phrase("ANNEE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("MOIS", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("DATE ET HEURE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("PUISSANCE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("PRIX/UNITE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("MONTANT", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ETAT FACTURE", font));
        table.addCell(cell);

    }
    private void writeTableData(PdfPTable table,int id){
        //Iterable<Facturation> liste=fac_repo.facturer(id);
        Iterable<VueFactute> liste=fac_repo.facturer(id);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);


        for(VueFactute salle : liste){
            //for(Facturation salle : liste){
            table.addCell(""+salle.getAnnee());
            table.addCell(""+salle.getMois());
            table.addCell(""+salle.getDate());
            table.addCell(""+salle.getPuissance());
            table.addCell(""+salle.getPu());
            table.addCell(""+salle.getMontant_facture()+"$");
            table.addCell(""+salle.getChek_fac_paie());

        }



    }
    public void export(HttpServletResponse response, int id) throws DocumentException, IOException, IOException {
     List<Client> nom=clientRepository.nom(id);

        Document document=new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        com.lowagie.text.Font font=FontFactory.getFont(FontFactory.TIMES_BOLD);
        font.setSize(18);
        font.setColor(Color.black);
        Font titre=FontFactory.getFont(FontFactory.TIMES_ROMAN);
        titre.setSize(12);
        titre.setColor(Color.black);
        Paragraph p=new Paragraph("FACTURE DE PAIEMENT",font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        for(Client client : nom) {
            Paragraph p1 = new Paragraph("NOM        : " +client.getNom() , titre);
            p1.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p1);
            Paragraph p2 = new Paragraph("POSTNOM : "+client.getPostnom(), titre);
            p2.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p2);
            Paragraph p3 = new Paragraph("PRENOM  : "+client.getPrenom(), titre);
            p3.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p3);
            Paragraph p4 = new Paragraph("SEXE    : "+client.getSexe(), titre);
            p4.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p4);
        }
        PdfPTable table=new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{2.3f,2.3f,2.3f,2.3f,2.3f,2.3f,2.3f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table,id);
        document.add(table);
        document.close();
        document.open();

    }
}
