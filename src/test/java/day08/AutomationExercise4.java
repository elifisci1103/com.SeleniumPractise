package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class AutomationExercise4 extends TestBase {
    @Test
    public void test01(){
     //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
     //2.“Our Products” butonuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("Our Products")).click();
    //3.“Cameras product”i tiklayin
        driver.findElement(By.id("camera-img")).click();
bekle(5);

    //4.Popup mesajini yazdirin
       String popUp= driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(popUp);
    //5.“close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();
    //6."WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();
       String WHD = driver.getWindowHandle();
   //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String WHD2="";
       Set<String> WHD3= driver.getWindowHandles();
        for (String each:WHD3) {
            if(!each.equals(WHD)){
                WHD2=each;
            }
        }
        driver.switchTo().window(WHD2);
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


}}
