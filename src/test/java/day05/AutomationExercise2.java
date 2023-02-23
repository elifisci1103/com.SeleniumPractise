package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise2 extends TestBase {


        @Test
        public void iframeTesti(){
            // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin
            driver.get(" https://the-internet.herokuapp.com/iframe");
            //2 ) Bir metod olusturun: iframeTest
            // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin
         WebElement yaziElementi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
            Assert.assertTrue(yaziElementi.isDisplayed());
            System.out.println(yaziElementi);
            // - Text Box’a “Merhaba Dunya!” yazin.
            WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("//p[text()='Your content goes here.']")).sendKeys("Merhaba Dünya!");
            bekle(3);
            //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
            driver.switchTo().parentFrame();
           WebElement yaziElementi2 = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
           Assert.assertTrue(yaziElementi2.isDisplayed());
}}
