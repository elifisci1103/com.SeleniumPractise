package day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseClass;

import java.time.Duration;

public class AutomationExercise3 extends TestBaseClass {

        @Test
        public void test01(){
            // amazon anasayfaya gidin
            driver.get("https://www.amazon.com.tr");
            // arama kutusu clickable oluncaya kadar bekleyin
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(40));
            WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
            wait.until(ExpectedConditions.elementToBeClickable(aramaKutusu));
            aramaKutusu.click();

            // Nutella icin arama yapin
            aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
}}
