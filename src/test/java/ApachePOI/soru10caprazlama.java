package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class soru10caprazlama {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Rupel11");

        int yeniAcilacakRowIndexi = 0;
        int yeniAcilacakCellIndexi = 0;
        Row satir =null;

        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 10; i++) {
                yeniAcilacakCellIndexi = (6*(k));
                satir=sheet.createRow(yeniAcilacakRowIndexi++);
                Cell hucre1 = satir.createCell(yeniAcilacakCellIndexi++); hucre1.setCellValue(k + 1);
                Cell hucre2 = satir.createCell(yeniAcilacakCellIndexi++); hucre2.setCellValue("x");
                Cell hucre3 = satir.createCell(yeniAcilacakCellIndexi++); hucre3.setCellValue(i + 1);
                Cell hucre4 = satir.createCell(yeniAcilacakCellIndexi++); hucre4.setCellValue("=");
                Cell hucre5 = satir.createCell(yeniAcilacakCellIndexi++); hucre5.setCellValue((k + 1) * (i + 1));
            }

        }
        String path = "src/test/java/ApachePOI/resource/_10_Soru_caprazlama.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
