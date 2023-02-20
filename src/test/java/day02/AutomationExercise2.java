package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AutomationExercise2 {
    public static void main(String[] args) {



            //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
           // 3. Verify th4. Click on 'Signup / Login' button
        WebElement signUp = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        if(signUp.isEnabled()){
            System.out.println("Test PASSED");}else{
            System.out.println("Test FAILED");}
           //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
           // 5. Verify 'New User Signup!' is visibleat home page is visible successfully
        WebElement newUserSignup =driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if(newUserSignup.isDisplayed()){
               System.out.println("Test PASSED");}else{
               System.out.println("Test FAILED");}
           // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@*='signup-name']")).sendKeys("Elif");
        driver.findElement(By.xpath("//input[@*='signup-email']")).sendKeys("elifisci1103@gmail.com");
           // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@*='signup-button']")).click();
           // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInf = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        if(enterAccountInf.isDisplayed()){
            System.out.println("Test PASSED");}else{
            System.out.println("Test FAILED");}
           // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"days\"]/option[13]")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[3]")).click();
        driver.findElement(By.xpath("//option[@value=\"1995\"]")).click();
        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();
           // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();


}}
