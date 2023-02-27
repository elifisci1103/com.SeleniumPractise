package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class AutomationExercise7 extends TestBase {
    @Test
    public void test01(){
    //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
//2.Sayfanin en altina inin
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END).perform();
        bekle(5);
//3.Web table tum body’sini yazdirin
     String body =   driver.findElement(By.xpath("//tbody")).getText();
     System.out.println(body);

//4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satırList =driver.findElements(By.xpath("//tbody/tr"));
      int actualSayi=  satırList.size();
      int expectedSayi=9;
        Assert.assertEquals(expectedSayi,actualSayi);
//5.Tum satirlari yazdirin
        System.out.println("-----------------------");
        int no=1;
        for (WebElement eachSatir:satırList) {
            System.out.println(no+"--"+eachSatir.getText());
                      no++;}


//6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sütun =driver.findElements(By.xpath("//tbody/tr[1]/td"));
        actualSayi=sütun.size();
        expectedSayi=13;
        Assert.assertEquals(expectedSayi,actualSayi);
//7. 5.sutunu yazdirin
        List<WebElement> besinciSütun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        int num=1;
        for (WebElement eachSütun:besinciSütun) {
            System.out.println(num+"--"+eachSütun.getText());
            num++;
        }}}

