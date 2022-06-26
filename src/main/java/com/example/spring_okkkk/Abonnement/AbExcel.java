package com.example.spring_okkkk.Abonnement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AbExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Iterable<Abonnement> listeab;
    public AbExcel(Iterable<Abonnement> listeab){
        this.listeab=listeab;
        workbook=new XSSFWorkbook();

    }
    private void writeHeaderLine(){
        sheet=workbook.createSheet("Abonnements");
        Row row=sheet.createRow(0);
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row,0,"Id",style);
        createCell(row,1,"type abonnement",style);
        createCell(row,2,"Description",style);
        createCell(row,3,"Montant",style);
    }
    private void createCell(Row row,int columnCount,Object value,CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell=row.createCell(columnCount);
        if(value instanceof Integer){
            cell.setCellValue((Integer) value);
        }
        else if(value instanceof Boolean){
            cell.setCellValue((String) value);
        }
        else if(value instanceof Long){
            cell.setCellValue((String) value);
        }
        else{
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    private void writeDataLines()
    {
        int rowCount=1;
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for(Abonnement salle: listeab){
            Row row=sheet.createRow(rowCount++);
            int columnCount=0;
            createCell(row,columnCount++,""+salle.getId(),style);
            createCell(row,columnCount++,""+salle.getType_abonnement(),style);
            createCell(row,columnCount++,""+salle.getDescription(),style);
            createCell(row,columnCount++,""+salle.getMontant(),style);
        }

    }
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
