package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercise2 extends TestBase {
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(20);
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //  Html komutu : https://username:password@URL
        //  Username     : admin
        //  password      : admin
        //

        //4- Basarili sekilde sayfaya girildigini dogrulayin
        String actualGirisYazisi= driver.findElement(By.tagName("p")).getText();
        String expectedIcerik = "Congratulations";
        Assert.assertTrue(actualGirisYazisi.contains(expectedIcerik));

    }
}
