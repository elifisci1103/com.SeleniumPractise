package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AutomationExercise  extends TestBase {
    @Test
    public void test01(){
             //2.https://the-internet.herokuapp.com/download adresine gidelim
             //3.logo.png dosyasını indirelim
            //4.Dosyanın başarıyla indirilip indirilmediğini test edelim

   driver.get("https://the-internet.herokuapp.com/download");
   driver.findElement(By.linkText("logo.png")).click();
   bekle(5);
   String dosyaYolu=System.getProperty("\"C:\\Users\\tahir\\Downloads\\logo.png\"");






}}
