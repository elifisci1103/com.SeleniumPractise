package day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseClass;

public class AutomationExercise extends TestBaseClass {
           // 1) Bir class oluşturun: BestBuyAssertions

    @Test
    public void urlTest(){

        //2) https://www.bestbuy.com/ Adresine gidin
        driver.get("https://www.bestbuy.com/");
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/ ";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.equals(expectedUrl));
    }
    @Test
    public void titletest(){
        //  ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
       String expectedTitle ="Rest";
       String actualTitle=driver.getTitle();
       Assert.assertFalse(actualTitle.contains(expectedTitle));}
    @Test
    public void logoTest(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin.
        WebElement logo =driver.findElement(By.xpath("(//img[@width='80'])[1]"));
        Assert.assertTrue(logo.isDisplayed());}
    @Test
    public void francaisLinkTest(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisLinkTest = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francaisLinkTest.isDisplayed());

    }




}
