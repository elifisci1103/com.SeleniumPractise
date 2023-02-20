package day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBaseClass;

import java.time.Duration;

public class AutomationExercise3 extends TestBaseClass {

    @Test
    public void test01(){

        //1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user"+ Keys.ENTER);
        //3. Password kutusuna “se"cret_sauce” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce"+Keys.ENTER);
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepetUrun = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertTrue(sepetUrun.isDisplayed());




}}
