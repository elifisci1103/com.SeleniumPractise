package day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

public class AutomationExercise2 extends TestBaseClass {
    @Test
            public void test01(){
    //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
    //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
    //3. Login alanine  “username” yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");
    //4. Password alanina “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
    //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
    // sayfa acilamazsa back tusuna basin
        driver.navigate().back();
    //6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

    // 7. “Purchase Foreign Currency” tusuna basin
     driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
    // 8. “Currency” drop down menusunden Eurozone’u secin
    WebElement aramaKutusuCurrency =driver.findElement(By.id("pc_currency"));
    Select select=new Select(aramaKutusuCurrency);
        select.selectByIndex(6);
        select.getFirstSelectedOption();
    // 9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("2");
    // 10. “US Dollars” in secilmedigini test edin
       WebElement dollar=driver.findElement(By.xpath("(//input[@*='radio'])[1]"));
       Assert.assertFalse(dollar.isSelected());
    // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
    //  12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.id("purchase_cash")).click();
    // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
    WebElement kontrolElementi=driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(kontrolElementi.isDisplayed());
}}
