package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class AutomationExercise4 extends TestBase {


    @Test

    public void test01(){

// amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
       driver.get("https://amazon.com.tr");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String WHD = driver.getWindowHandle();
// yeni bir tab olarak wisequarter.com'a gidin
        /* once yeni bir tab olusturup
           driver'i o sayfaya gecirmeliyiz (switch)

         */
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com.");
        String WHD2=driver.getWindowHandle();
        bekle(3);


// url'in wisequarter icerdigini test edin.

        String expectedIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

// amazon'un acik oldugu tab'a geri donup
        driver.switchTo().window(WHD);
        /*
            Daha once acilmis olan bir window'a gecis yapmak icin
            O sayfanin windowHandle degerine ihtiyacimiz var
            Testimiz boyle bir gorevi iceriyorsa
            o sayfada iken windowHandle degerini alip kayit yapmaliyiz*/

    // Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

    // Sonuclarin Nutella icerdigini test edin
        expectedIcerik="Nutella";
       String  actualIcerik=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
       Assert.assertTrue(actualIcerik.contains(expectedIcerik));

    // yeni bir window olarak youtube.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com.tr");

    // Url'in youtube icerdigini test edin
      actualUrl =  driver.getCurrentUrl();
      expectedIcerik ="youtube";
      Assert.assertTrue(actualUrl.contains(expectedIcerik));

    // wisequarter'in acik oldugu sayfaya donun . title'in Wise Quarter icerdigini test edin
        driver.switchTo().window(WHD2);
       String actualTitle=driver.getTitle();
       expectedIcerik= "Wise Quarter";
       Assert.assertTrue(actualTitle.contains(expectedIcerik));
}}
