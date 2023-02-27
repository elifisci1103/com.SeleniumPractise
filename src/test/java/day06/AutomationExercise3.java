package day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercise3 extends TestBase {
    @Test
    public void test01(){

    //1-"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
    //2-Hover over Me First" kutusunun ustune gelin
        Actions actions =new Actions(driver);
        WebElement yaziElementi=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(yaziElementi).perform();
        bekle(3);
    // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
    //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
    //6- “Click and hold" kutusuna basili tutun
        WebElement clickHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();
        bekle(3);

    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHold.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleClick).perform();
}}
