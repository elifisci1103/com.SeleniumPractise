package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseClass;

import java.time.Duration;

public class AutomationExercise extends TestBaseClass {
    @Test
    public void test01(){
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait() iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    //4. Remove butonuna basin.

       driver.findElement(By.xpath("//button[text()='Remove']")).click();
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

    WebDriverWait wait = new WebDriverWait( driver,Duration.ofSeconds(40));
    WebElement itsGone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGone.isDisplayed());
    //6.Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

    //7.It’s back mesajinin gorundugunu test edin

       WebElement itsBack =driver.findElement(By.xpath("//p[@id='message']"));
       wait.until(ExpectedConditions.visibilityOf(itsBack));
      Assert.assertTrue(itsBack.isDisplayed());

}}
