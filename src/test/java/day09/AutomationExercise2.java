package day09;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutomationExercise2 {
    @Test
    public void test01() throws IOException {

        String dosyaYolu="src/test/java/day09/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //2.sütunu yazdıralım.
        List<String> ikinciSütun = new ArrayList<>();
        int sonIndeks=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=sonIndeks ; i++) {

          ikinciSütun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());

        }
        System.out.println(ikinciSütun);
        //3.satirdaki 3.hucreyi bir string degiskene atayalim ve yazdiralim
        String data=workbook.getSheet("Sayfa1").getRow(2).getCell(2).toString();
        System.out.println("İstenen data :"+ data);
        // 4.satir 1.cell’in Albenia oldugunu test edelim
       String actualData= workbook.getSheet("Sayfa1").getRow(3).getCell(0).toString();
       String expectedData="Algeria";
        Assert.assertEquals(expectedData,actualData);

        //Satir sayisini bulalim
        int satirSayisi=(workbook.getSheet("Sayfa1").getLastRowNum())-1;
        System.out.println(satirSayisi);
}}
