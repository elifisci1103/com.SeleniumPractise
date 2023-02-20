package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise3 {
    public static void main(String[] args) {
        //1 - Java class'imiza chromedriver.exe'yi tanitalim
        WebDriverManager.chromedriver().setup();



        //2 - Driver olusturalim
        WebDriver driver =new ChromeDriver();
        //3 - Driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        //4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklemesini
        //söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //5 - "https://www.otto.de"" adresine gidelim
        driver.get("https://www.otto.de");
        //6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
        String expectedTitle="OTTO";
        String actualTitle= driver.getTitle();
        String expectedUrl = "OTTO";
        String actualUrl =  driver.getCurrentUrl();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title testi PASSED");}else{
            System.out.println("Title testi FAILED");}
        if(actualUrl.contains(expectedUrl)){
            System.out.println("Url testi PASSED");}else{
            System.out.println("Url testi FAILED");}
        //8 - Ardindan """" adresine gidelim
        driver.get("https://wisequarter.com/");
        //9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
        //kontrol edelim
        String expectedTitle2 = "Quarter";
        String actualTitle2 =  driver.getCurrentUrl();
        if(actualTitle2.contains(expectedTitle2)){
            System.out.println("Title2 testi PASSED");}else{
            System.out.println("Title2 testi FAILED");}
        //10- Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        //11- Sayfayi yenileyelim
        driver.navigate().refresh();
        //12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().back();
        driver.close();
        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
