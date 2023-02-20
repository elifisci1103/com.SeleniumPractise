package day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

public class AutomationExercise2 extends TestBaseClass {
    @Test
    public void test01(){
       //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
       // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
       // 3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username"+ Keys.ENTER);
       // 4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password"+Keys.ENTER);
       // 5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();
        driver.navigate().back();
        // 6. Önce online Banking sonra Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
       // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
       // 8. “Currency” drop down menusunden Eurozone’u secin
         WebElement ddm=driver.findElement(By.id("pc_currency"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");
        select.getFirstSelectedOption();
       // 9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("100"+Keys.ENTER);
       // 10. “US Dollars” in secilmedigini test edin
       WebElement dolar = driver.findElement(By.xpath("//input[@value='true']"));
        Assert.assertFalse(dolar.isSelected());
       // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
       // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();
       // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement yazi = driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']"));
      Assert.assertTrue(yazi.isDisplayed());
}}