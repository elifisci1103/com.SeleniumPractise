package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercise4 extends TestBase {
    @Test
    public void test01(){

    //2-https://html.com/tags/iframe/ sayfasina gidelim
     driver.get("https://html.com/tags/iframe/");
    //3-Video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

    //4-Videoyu izlemek icin Play tusuna basin
        WebElement iframe =driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframe);
        WebElement play =driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        actions.click(play).perform();

    //5-Videoyu calistirdiginizi test edin
      Assert.assertTrue(play.isEnabled());



}}
