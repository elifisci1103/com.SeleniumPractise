package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class AutomationExercise3  extends TestBase {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualYaziElementi=driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String expectedYaziElementi ="Opening a new window";
        Assert.assertTrue(expectedYaziElementi.equalsIgnoreCase(actualYaziElementi));
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String WHD = driver.getWindowHandle();
        System.out.println(WHD);
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> WHD3 = driver.getWindowHandles();
        String WHD2="";
        for (String each:WHD3) {
            if(!each.equals(WHD)){
               WHD2= each;
            }}

          driver.switchTo().window(WHD2);
        expectedTitle="New Window";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        /*
            Eger switchToNewWindow() method'u kullanilirsa
            driver yeni acilan sayfaya gecis yapar
            Ancak bu method kullanilmadan
            bir link tiklandiginda, yeni bir sayfa aciliyorsa
            driver yeni sayfaya gecis yapmaz
            bizim yeni acilan sayfanin
            windowHandle degerini bulup
            driver'i o sayfaya gecirmemiz GEREKLIDIR
            link'e click yaptigimizda acik 2 sayfamiz oluyor
            bunlardan bir tanesi windowHandle degerini kaydettigimiz ILK SAYFA
            digeri ise windowHandle degerini bilmedigimiz IKINCI SAYFA
            biz getWindowHandles() method'u ile
            bir SET olarak iki sayfanin windowHandle degerlerini alabiliyoruz
            O SET icerisinde
            ilkSayfaWHD'ine esit olmayan String'i
            ikinciSayfaWHD olarak atayabiliriz
         */


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
         actualYaziElementi=driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
         expectedYaziElementi="New Window";
         Assert.assertTrue(expectedYaziElementi.equals(actualYaziElementi));



        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(WHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }
}
