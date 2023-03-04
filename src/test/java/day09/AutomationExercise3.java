package day09;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AutomationExercise3 {
    @Test
    public void test02() throws IOException {
    //3) Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu="src/test/java/day09/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

    //4) 6.hucreye yeni bir cell olusturalim.Olusturdugumuz hucreye “İsimler” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(6).setCellValue("İsimler");

        //5) 2.satir isimler kolonuna Ali yazdiralim
        workbook.getSheet("Sayfa1").getRow(3).createCell(6).setCellValue("Ali");

    //6) 10.satır  isimler kolonuna Ayse yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(6).setCellValue("Ayse");
    //7 15.satir isimler kolonuna Mahmut yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(6).setCellValue("Mahmut");
    //8) Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
    //9)Dosyayi kapatalim
        fos.close();
        fis.close();
        workbook.close();
}}

