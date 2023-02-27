package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseClass;

import java.util.Set;

public class AutomationExercise5 extends TestBaseClass {
    @Test
    public void test01(){
   // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
//2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(4);
//3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        String WHD = driver.getWindowHandle();
        Set<String>WHD3=driver.getWindowHandles();
        String WHD2="";
        for (String each:WHD3) {
            if(!each.equals(WHD)){
                WHD2=each;}}
//4.Diger window'a gecin
        driver.switchTo().window(WHD2);

// 5."username" ve "password" kutularina deger yazdirin.login butonuna basin
     WebElement username= driver.findElement(By.xpath("//*[@placeholder='Username']"));
     actions.click(username).sendKeys("Elif").sendKeys(Keys.TAB).sendKeys("ISCI").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
bekle(5);
//6.Popup'ta cikan yazinin "validation failed" oldugunu test edin
     String actualYazi=   driver.switchTo().alert().getText();
     String expectedYazi="validation failed";
        Assert.assertEquals(expectedYazi,actualYazi);
// 7.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
// 8.Ilk sayfaya geri donun
        driver.switchTo().window(WHD);
        bekle(4);
//9.Ilk sayfaya donuldugunu test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="http://webdriveruniversity.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
}}
