package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  yeni bir excel dosyasına
 *  1 den 10 kadar çarpımlar için yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */
public class _09_Soru {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Rupel1");

        String path = "src/test/java/ApachePOI/resource/_09_Soru.xlsx";

//        Row yeniSatir= sheet.createRow(0);
//        Cell hucre = yeniSatir.createCell(0);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int sonSatirIndex = sheet.getPhysicalNumberOfRows();
                Row yeniSatir = sheet.createRow(sonSatirIndex);

                Cell yeniHucre = yeniSatir.createCell(0);
                yeniHucre.setCellValue(i+1);

                Cell yeniHucre2 = yeniSatir.createCell(1);
                yeniHucre2.setCellValue("x");

                Cell yeniHucre3 = yeniSatir.createCell(2);
                yeniHucre3.setCellValue(j + 1);

                Cell yeniHucre4 = yeniSatir.createCell(3);
                yeniHucre4.setCellValue("=");

                Cell yeniHucre5 = yeniSatir.createCell(4);
                yeniHucre5.setCellValue((i+1)*(j + 1));
            }
            int sonSatirIndex2 = sheet.getPhysicalNumberOfRows();
            Row yeniSatirEkle = sheet.createRow(sonSatirIndex2);
        }




        //inputStream.close();

        //dosyay kaydetmeye geçiyorum
        // bunun için dosyayı yazma yönünde aç
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        //outputStream.close(); // yazma kanalını kapat

    }
}
