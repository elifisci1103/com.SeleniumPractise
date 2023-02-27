package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AutomationExercise2 extends TestBase {
    @Test
    public void test01() {

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim.
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String dosyaYolu = "C:\\Users\\tahir\\OneDrive\\Masaüstü\\ISTQB\\Complete_with_DocuSign_Yazılım_Test_ve_Kalit.pdf";
        chooseFile.sendKeys(dosyaYolu);

        //3.Yuklemek istediginiz dosyayi secelim.
        //4. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        bekle(5);
        //5.“File Uploaded!” textinin goruntulendigini test edelim
        WebElement yazi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yazi.isDisplayed());
        //Local bilgisayardaki bir dosyayi bir web uygulamasina yuklemek icin, bilgisayarda
        // dosyalar arasinda gezinmek ve dosyayi tiklayarak secmek gerekebilir.
        // Ancak selenium ile local dosyalara ulasilamayacagi icin yine java’daki dosya
        // kullanma yontemleri kullanilabilir. Dosyayi yuklemek icin
        // 1- Dosya yolunu olusturup kaydedin
        // 2- Choose file butonunu locate edip dosya yolunu bu element’e gonderin
        // 3- Upload butonunu locate edip tiklayin
    }

        @Test
        public void test02(){
            // Calistigimiz package icerisinde
            // text.txt isimli bir file oldugunu test edin
            String dinamikDosyaYolu = System.getProperty("user.dir")
                    +"/src/test/java/day07_actionsClass_fileTestleri/text.txt";
            Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));



}}
