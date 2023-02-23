package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class AutomationExercise5 extends TestBase {
    @Test
    public void test01(){

        //1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String WHD=driver.getWindowHandle();

        //2- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement kutucuk =driver.findElement(By.id("hot-spot"));
        actions.contextClick(kutucuk).perform();

        //3- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualYazi= driver.switchTo().alert().getText();
        String expectedYazi="You selected a context menu";
        Assert.assertTrue(expectedYazi.equals(actualYazi));


        //4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //5- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //6- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String WHD2=" ";
      Set<String> WHD3 = driver.getWindowHandles();
        for (String each:WHD3) {
            if(!each.equals(WHD)){
                WHD2=each;
            }
        }
        driver.switchTo().window(WHD2);
       String actualh1= driver.findElement(By.tagName("h1")).getText();
       String expectedh1="Elemental Selenium";
       Assert.assertEquals(expectedh1,actualh1);

    }
}
