package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseClass;

import java.util.Set;

public class AutomationExercise6 extends TestBaseClass {
    @Test
    public void test01(){

//1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
//2- Tum cookie’leri listeleyin
        int no=1;
      Set<Cookie> cookiesSeti= driver.manage().getCookies();
        for (Cookie eachcookie:cookiesSeti) {
            System.out.println(no+ "--"+eachcookie);
            no++;
        }
//3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSeti.size()>5);
//4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    String actualValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
    String expectedValue="USD";
    Assert.assertEquals(expectedValue,actualValue);
//5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie benimCookie=new Cookie("en sevdiğim cookie","cikolatalı");
        driver.manage().addCookie(benimCookie);
//6- eklediginiz cookie’nin sayfaya eklendigini test edin
         actualValue= driver.manage().getCookieNamed("en sevdiğim cookie").getValue();
         expectedValue="cikolatalı";
        Assert.assertEquals(expectedValue,actualValue);
//7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        System.out.println("=========");
        // olmayan bir elemani test edemem
        // bunun yerine for-each Loop ile ele aldigimiz her cookie'yi kontrol edelim
        // ismi skin olan varsa test failed olsun
        cookiesSeti= driver.manage().getCookies();
        for (Cookie eachCookie:cookiesSeti
        ) {
            Assert.assertFalse(eachCookie.getName().equals("skin"));
        }
        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
        cookiesSeti= driver.manage().getCookies();
        Assert.assertTrue(cookiesSeti.size()==0);
}}
