package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseClass;

import java.time.Duration;
import java.util.EventObject;

public class AutomationExercise2 extends TestBaseClass {
    @Test
    public void test01(){

    //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls ");
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
    //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
    //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement enabled =driver.findElement(By.id("message"));
        Assert.assertTrue(enabled.isDisplayed());
    //5.Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());
}}
