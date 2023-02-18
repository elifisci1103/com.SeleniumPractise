package day01;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Under the ORIGINAL CONTENTS click on Alerts
        driver.findElement(By.xpath("//*[@id='alerts']")).click();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        //navigate back
        driver.navigate().back();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        // Click on Basic Ajax
        driver.findElement(By.id("basicajax")).click();
        // print the URL
        System.out.println(driver.getCurrentUrl());
        //enter value 20 and ENTER
        WebElement value =driver.findElement(By.id("lteq30"));
        value.sendKeys("20"+ Keys.ENTER);
        // and then verify Submitted Values is displayed open page
        WebElement submit=driver.findElement(By.xpath("//*[text()='Submitted Values']"));
        if (submit.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");}

        // close driver
        Thread.sleep(5000);
        driver.close();

    }
}
