package com.example.spring_okkkk.Abonnement;

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
public class AbPdf {
    @Autowired
    private AbonnementRepository repo_ab;
    private  void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Type", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Description", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);


    }
    private void writeTableData(PdfPTable table,int id){
        //Iterable<Abonnement> listeab= repo_ab.findAll();
        List<Abonnement> listeab= repo_ab.listeAb(id);

        for(Abonnement salle : listeab){
            table.addCell(""+salle.getId());
            table.addCell(""+salle.getType_abonnement());
            table.addCell(salle.getDescription());
            table.addCell(""+salle.getMontant());

        }



    }
    public void export(HttpServletResponse response,int id) throws DocumentException, IOException {
       // public void export(HttpServletResponse response)d throws DocumentException, IOException {
        Document document=new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);
        Paragraph p=new Paragraph("LISTE DES ABONNEMENT",font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        PdfPTable table=new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.0f,1.7f,6.0f,2.0f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        //writeTableData(table);
        writeTableData(table,id);
        document.add(table);
        document.close();
        document.open();

    }

}
