package day06;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercise extends TestBase {
    @Test
    public void test01(){
        //input[@placeholder='Adın']     //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Cookies'i kabul edip Yeni hesap olustur butonuna basalim
        Actions actions=new Actions(driver);
        Faker faker = new Faker();
        driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']")).click();
        bekle(3);
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim.Kaydol tusuna basalim.
        WebElement isim=driver.findElement(By.xpath("//input[@placeholder='Adın']"));
        actions.click(isim).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys("5446789898").
        sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("24").sendKeys(Keys.TAB)
               .sendKeys("Mart").sendKeys(Keys.TAB).sendKeys("2000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
       bekle(3);

}}
