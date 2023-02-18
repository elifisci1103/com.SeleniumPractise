package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //fill the firstname
        WebElement isim= driver.findElement(By.xpath("//*[@name='firstname']"));
        isim.sendKeys("Sumeyye"+ Keys.ENTER);
        //fill the lastname
        WebElement soyisim=driver.findElement(By.xpath("//*[@name='lastname']"));
        soyisim.sendKeys("Alakabak"+Keys.ENTER);
        //check the gender
        driver.findElement(By.id("sex-1")).click();
        //check the experience
        driver.findElement(By.id("exp-4")).click();
       // fill the date
        WebElement gun=driver.findElement(By.id("datepicker"));
        gun.sendKeys("18.02.2023"+Keys.ENTER);
        // choose your profession -> Automation Tester
        driver.findElement(By.id("profession-1")).click();
        //   choose your tool -> Selenium Webdriver
        driver.findElement(By.id("tool-2")).click();
        //choose your continent -> Antartica
        driver.findElement(By.id("continents")).click();
        driver.findElement(By.xpath("//*[text()='Antartica']")).click();
        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("//*[text()=\"Browser Commands\"]")).click();
        //click submit button
        driver.findElement(By.xpath("//button[text()='Button']")).click();
       Thread.sleep(3000);
       driver.close();


    }
}
