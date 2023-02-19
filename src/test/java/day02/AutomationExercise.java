package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise {


    public class soru1 {
        static WebDriver driver;
        //Bir class oluşturun: YoutubeAssertions
        @BeforeClass
        public static void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            // https://www.youtube.com adresine gidin
            driver.get("https://www.youtube.com");

        }
        @AfterClass
        public static void teardown(){
            driver.close();
        }

        @Test
        public void titleTest(){
            //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
            String expectedContent="YouTube";
            String actualTitle=driver.getTitle();
            Assert.assertEquals(expectedContent,actualTitle);
        }

        @Test
        public void imageTest(){
            //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
            WebElement image=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
            Assert.assertTrue(image.isDisplayed());

            //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
            WebElement searchBox=driver.findElement(By.name("search_query"));
            Assert.assertTrue(searchBox.isEnabled());

        }

        @Test
        public  void wrongTitleTest(){
            //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
            String actualTitle=driver.getTitle();
            String expectedTitle="youtube";
            Assert.assertFalse(actualTitle.equals(expectedTitle));

        }

    }
}
