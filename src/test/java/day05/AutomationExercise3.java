package day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise3 extends TestBase {
    @Test
    public void test01(){
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
    // 2) sayfadaki iframe sayısını bulunuz.
      int iframeSayisi=9;

    // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframe = driver.findElement(By.xpath("//*[@height='315']"));
      driver.switchTo().frame(iframe);
      driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
    // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
    // 5) ikinci iframe'deki (Jmeter Made Easy) linke
    // (https://www.guru99.com/live-selenium-project.html) tıklayınız
}}
