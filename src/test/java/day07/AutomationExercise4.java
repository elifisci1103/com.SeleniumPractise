package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import utilities.TestBaseClass;

public class AutomationExercise4 extends TestBaseClass {
    @Test
    public void test01(){


        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //  3. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //  4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts= driver.findElement(By.xpath("//*[@class='features_items']"));
        String actualAllProducts=allProducts.getText();
        String expectedAllProducts="ALL PRODUCTS";
        Assert.assertTrue(actualAllProducts.contains(expectedAllProducts));

        //  5. Enter product name in search input and click search button
        WebElement searchInput=driver.findElement(By.xpath("//*[@id='search_product']"));
        searchInput.sendKeys("KIDS");
        driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();

        //  6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts=driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(searchedProducts.isDisplayed());

        //  7. Verify all the products related to search are visible
        WebElement searchedElements = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(searchedElements.isDisplayed());

        //  8. Add those products to cart
        WebElement addCart=driver.findElement(By.xpath("//div[@class='productinfo text-center']"));
        Actions actions =new Actions(driver);
        actions.moveToElement(addCart).perform();
        WebElement addcartweb=driver.findElement(By.xpath("//*[@class='btn btn-default add-to-cart']"));
        actions.click(addcartweb).perform();

        //  9. Click 'Cart' button and verify that products are visible in cart
        WebElement viewCard=driver.findElement(By.xpath("//*[text()='View Cart']"));
        viewCard.click();

        WebElement viewsepet=driver.findElement(By.xpath("//*[@id='product-13']"));
        Assert.assertTrue(viewsepet.isDisplayed());

        //  10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        driver.findElement(By.xpath("//*[@style='color: orange;']")).click();
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("aaaaaaaaaa@gmail.com");
        actions.sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        bekle(5);

        //  11. Again, go to Cart page

        WebElement cart=driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']"));
        cart.click();

        //  12. Verify that those products are visible in cart after login as well
        WebElement sepet=driver.findElement(By.xpath("//*[@class='table-responsive cart_info']"));
        Assert.assertTrue(sepet.isDisplayed());
}}
