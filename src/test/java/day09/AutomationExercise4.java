package day09;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class AutomationExercise4 extends TestBase {
    @Test
    public void test01() throws IOException {
    // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
// 2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
      WebElement anaSayfaLogo = driver.findElement(By.xpath("//a[@class='nav-logo-link nav-progressive-attribute']"));
        Assert.assertTrue(anaSayfaLogo.isDisplayed());
        TakesScreenshot ts= (TakesScreenshot) driver;
        File tümSayfaSs= new File("target/TümSs.jpg");
        File geçiciDosya=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geçiciDosya,tümSayfaSs);
//3- Iphone icin arama yapin.İlk ürünü tıklayın.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//img[@data-image-source-density='1'])[1]"));


//4- Sonucun yazısının ve ilk urunun goruntusunu alin.

        WebElement sonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File elementSs=new File("target/elementSs.png");
        File geciciDosya=ilkUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,elementSs);
        File elementSs2=new File("target/elementSs2.png");
        File geciciDosya2=sonucYazisi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya2,elementSs2);

}}
