package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TODO:
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  YENİ bir excel dosyasına
 *  1 den 10 kadar çarpımları YAN YANA yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */

public class _10_Soru {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Rupel1");

        int yeniAcilacakRowIndexi = 0;
        int yeniAcilacakCellIndexi = 0;

        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 10; i++) {
                    yeniAcilacakCellIndexi = (6*(k));
                    Row satir=sheet.createRow(yeniAcilacakRowIndexi++);

                    Cell hucre1 = sheet.getRow(i).createCell(yeniAcilacakCellIndexi++); hucre1.setCellValue(k + 1);
                    Cell hucre2 = sheet.getRow(i).createCell(yeniAcilacakCellIndexi++); hucre2.setCellValue("x");
                    Cell hucre3 = sheet.getRow(i).createCell(yeniAcilacakCellIndexi++); hucre3.setCellValue(i + 1);
                    Cell hucre4 = sheet.getRow(i).createCell(yeniAcilacakCellIndexi++); hucre4.setCellValue("=");
                    Cell hucre5 = sheet.getRow(i).createCell(yeniAcilacakCellIndexi++); hucre5.setCellValue((k + 1) * (i + 1));
            }
        }
        String path = "src/test/java/ApachePOI/resource/_10_Soru.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
