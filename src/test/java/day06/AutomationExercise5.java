package day06;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class AutomationExercise5 extends TestBase {
    @Test
    public void test01() {
        // 1-Amazona gidin
        driver.get("https://www.amazon.com.tr");
        // 2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(aramaKutusu);
        aramaKutusu.click();
        List<WebElement> dropDownList = select.getOptions();
        int sayı=1;
        for (WebElement each:dropDownList) {
            System.out.println(sayı+ "-----"+each.getText());
            sayı++;

        }
        bekle(3);
        // 3-Dropdown menude 40 eleman olduğunu doğrulayın
        int expectedSayi=40;
        int actualsayi=dropDownList.size();
        Assert.assertEquals(expectedSayi,actualsayi);
    }
    @Test
    public void test02() {

        //1- dropdown menuden elektronik bölümü seçin
        driver.get("https://www.amazon.com.");
        WebElement aramaKutusu=driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(aramaKutusu);
        aramaKutusu.click();
        select.selectByVisibleText("Electronics");
        select.getFirstSelectedOption();
        bekle(3);
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
      String aramaSonuclari=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedIcerik="iphone";
        String actualIcerik=aramaSonuclari;
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun=driver.findElement(By.xpath("//img[@data-image-source-density='1']"));
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(ilkUrun));
        ikinciUrun.click();

        //5-ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String title=driver.getTitle();
        System.out.println(title);
        WebElement addCart=driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]"));
        addCart.click();
    }
    @Test
    public void test03() {
        //1-yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.");
        //2-dropdown’dan bebek bölümüne secin
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        dropDown.click();
        select.selectByIndex(2);
        select.getFirstSelectedOption();
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puseti"+Keys.ENTER);
        WebElement aramaKutusu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String yaziElementi=aramaKutusu.getText();
        String[]arr=yaziElementi.split(" ");
        String sonucSayisi=arr[2];
        int sonucSayisi2=Integer.parseInt(sonucSayisi);
        System.out.println("Sonuç sayısı =" + sonucSayisi2);
        // 4-sonuç yazsının puset içerdiğini test edin
        String expectedYazi ="puset";
        String actualYazi=yaziElementi;
        Assert.assertTrue(actualYazi.contains(expectedYazi));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(4);
        WebElement ikinciUrun=driver.findElement(By.xpath("//img[@data-image-index='2']"));
        WebElement ucuncuUrun=driver.findElement(RelativeLocator.with(By.tagName("img")).below(ikinciUrun));
        ucuncuUrun.click();
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String pusetTitle=driver.getTitle();

    }

    }
