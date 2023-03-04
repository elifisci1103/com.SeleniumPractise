package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class AutomationExercise extends TestBase{

    @Test
    public void test01(){
    //1-Trendyol.com a gidiniz.
        driver.get("https://www.trendyol.com");
        driver.findElement(By.id("Combined-Shape")).click();

        //2.Ev&Mobilya sekmesinin uzerine geliniz.

        Actions actions = new Actions(driver);
        WebElement ev=driver.findElement(By.xpath("//a[text()='Ev & Mobilya']"));
        actions.moveToElement(ev).perform();
        String WHD = driver.getWindowHandle();

    //3.Ev tekstili kategorisinden  yatak odası seceneğine basınız.
        WebElement yatakOdası= driver.findElement(By.xpath("(//a[text()='Yatak Odası'])[1]"));
        yatakOdası.click();
    //4.2.Ürüne tıklayın ve 200*200 ebatını seçiniz.
     WebElement ikinciUrun =driver.findElement(By.xpath("(//div[@class='image-container'])[2]"));
     ikinciUrun.click();
     String WHD2="";
     Set<String> WHD3=driver.getWindowHandles();
        for (String each :WHD3) {
            if(!each.equals(WHD)){
                WHD2=each;
            }}
        driver.switchTo().window(WHD2);
        driver.findElement(By.xpath("(//div[@class='sp-itm'])[2]")).click();

    //5.Fiyatını yazdırıp sepete atın.
    String fiyat =driver.findElement(By.xpath("//*[text()='329,99 TL']")).getText();
       System.out.println("Ürünün fiyatı :" + fiyat);
       driver.findElement(By.xpath("//button[@class='add-to-basket']")).click();



}}
