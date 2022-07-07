package com.example.spring_okkkk;

import com.example.spring_okkkk.Client.Client;
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
public class PdfFactureNotPayed {
    @Autowired
    PdfNotPayedRepository fac_not_repo;
    private  void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.black);
        cell.setPhrase(new Phrase("DATE FAC", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("NUM FACT", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("NOM", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("POSTNOM", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("MOIS", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("PUISSANCE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("PU", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("MONTANT", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("RESTE", font));
        table.addCell(cell);

    }
    private void writeTableData(PdfPTable table,int annee){
        //Iterable<Facturation> liste=fac_repo.facturer(id);
        Iterable<VueFactureNotPayed> liste=fac_not_repo.facturerNotPayed(annee);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);


        for(VueFactureNotPayed salle : liste){
            table.addCell(""+salle.getDate());
            table.addCell(""+salle.getNumerofacture());
            table.addCell(""+salle.getNom());
            table.addCell(""+salle.getPostnom());
            table.addCell(""+salle.getMois());
            table.addCell(""+salle.getPuissance());
            table.addCell(""+salle.getPu()+"$");
            table.addCell(""+salle.getMontant_facture()+"$");
            table.addCell(""+salle.getReste_fac()+"$");

        }



    }
    public void export(HttpServletResponse response, int annee) throws DocumentException, IOException, IOException {
        Iterable<VueFactureNotPayed> annees=fac_not_repo.facturerNotPayed(annee);

        Document document=new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        com.lowagie.text.Font font=FontFactory.getFont(FontFactory.TIMES_BOLD);
        font.setSize(18);
        font.setColor(Color.black);
        Font titre=FontFactory.getFont(FontFactory.TIMES_ROMAN);
        titre.setSize(12);
        titre.setColor(Color.black);
        Paragraph p=new Paragraph("FACTURE NON PAIER",font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        for(VueFactureNotPayed an : annees) {
            Paragraph p1 = new Paragraph("ANNEE : " +an.getAnnee() , titre);
            p1.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(p1);
        }
        PdfPTable table=new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{2.3f,2.3f,2.3f,2.3f,2.3f,2.3f,2.3f,2.3f,2.3f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table,annee);
        document.add(table);
        document.close();
        document.open();

    }
}
