package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercise4 extends TestBase {
    @Test
    public void test01() {

       // 1 - https://www.amazon.com/ adresine gidin
        driver.get(" https://www.amazon.com/");
       // 2 - Sag ust bolumde bulunan “Account & Lists”menusunun acilmasi icin
       // mouse’u bu menunun ustune getirin
        WebElement accountList = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();

       // 4 - Acilan sayfada “Your Lists”yazisi oldugunu test edin
        WebElement yazi=driver.findElement(By.id("nav-al-title"));
       Assert.assertTrue(yazi.isDisplayed());
    }}