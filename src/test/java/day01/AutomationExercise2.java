package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get(" https://testpages.herokuapp.com/styled/index.html");
        // Click on  Calculater under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
        // Type any number in the first input
        WebElement firstInput = driver.findElement(By.id("number1"));
        firstInput.sendKeys("16"+ Keys.ENTER);
        //Type any number in the second input
        WebElement secondInput = driver.findElement(By.id("number2"));
        secondInput.sendKeys("2"+ Keys.ENTER);
        //Click on Calculate
        driver.findElement(By.id("calculate")).click();
        // Get the result
        driver.findElement(By.id("answer")).getText();
        //Print the result
        System.out.println(driver.findElement(By.id("answer")).getText());
      Thread.sleep(3000);
      driver.close();
    }

}
