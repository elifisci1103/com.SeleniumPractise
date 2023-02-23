package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class AutomationExercise extends  TestBase {

    @Test
        public void test01(){
            // ● Amazon anasayfa adresine gidin.
            driver.get("https://www.amazon.com");

            //  ● Sayfa’nin window handle degerini String bir degiskene atayin
            String amazonWHD=driver.getWindowHandle();

            //  ● Sayfa title’nin “Amazon” icerdigini test edin
            String actualTitle=driver.getTitle();
            String expectedIcerik="Amazon";
            Assert.assertTrue(actualTitle.contains(expectedIcerik));

            //  ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://www.wisequarter.com");

            //  ● Sayfa title’nin “wisequarter” icerdigini test edin
            actualTitle=driver.getTitle();
            expectedIcerik="Wise Quarter";
            Assert.assertTrue(actualTitle.contains(expectedIcerik));

            //  ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get("https://www.walmart.com");

            //  ● Sayfa title’nin “Walmart” icerdigini test edin
            actualTitle=driver.getTitle();
            expectedIcerik="Walmart";
            Assert.assertTrue(actualTitle.contains(expectedIcerik));

            //  ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
            driver.switchTo().window(amazonWHD);
            String actualUrl=driver.getCurrentUrl();
            expectedIcerik="amazon";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));

        }
    }


