package day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseClass;

public class AutomationExercise3 extends TestBase {
    @Test
    public void test01(){
     //..........Exercise1............
    //http://www.google.com adresine gidin
      driver.get("http://www.google.com");
    //arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
     driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("The Lord of the Rings"+ Keys.ENTER);
     String sonuc=driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
     String [] arr = sonuc.split(" ");
     String sonucSayisi=arr[1];
        System.out.println(sonucSayisi);
        String sonucSayisiSon=sonucSayisi.replaceAll("\\D","");
        System.out.println(sonucSayisiSon);}
     @Test
     public void test02(){
    //arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
         driver.get("http://www.google.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@title='Ara']"));
        aramaKutusu.sendKeys("Brave Heart"+Keys.ENTER);
        String  sonuc = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        String[] arr2=sonuc.split(" ");
        String  sonucSayisi = arr2[1];
        String sonucSayisiSon = sonucSayisi.replaceAll("\\D","");
        System.out.println(sonucSayisiSon);}


        @Test
        public void test03(){
            driver.get("http://www.google.com");
         //arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
            WebElement aramaKutusu=driver.findElement(By.xpath("//input[@title='Ara']"));
        aramaKutusu.sendKeys("Harry Potter"+Keys.ENTER);
        String sonuc = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        String[] arr3=sonuc.split(" ");
        String  sonucSayisi = arr3[1];
        String sonucSayisiSon = sonucSayisi.replaceAll("\\D","");
        System.out.println(sonucSayisiSon);

}}
