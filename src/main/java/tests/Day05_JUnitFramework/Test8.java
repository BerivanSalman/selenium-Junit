package tests.Day05_JUnitFramework;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class Test8 extends TestBase {
    @Test
    public void testProductDetailPage() {
        // 1. Launch browser and navigate to the URL
        driver.get("http://automationexercise.com");

        // 2. Verify that home page is visible successfully
        assertTrue(driver.findElement(By.id("home")).isDisplayed());

        // 3. Click on 'Products' button
        driver.findElement(By.id("productsButton")).click();

        // 4. Verify user is navigated to ALL PRODUCTS page successfully
        assertTrue(driver.findElement(By.id("allProductsPage")).isDisplayed());

        // 5. The products list is visible
        assertTrue(driver.findElement(By.id("productsList")).isDisplayed());

        // 6. Click on 'View Product' of first product
        WebElement firstProductViewButton = driver.findElement(By.xpath("//div[@id='productsList']/div[1]/button"));
        firstProductViewButton.click();

        // 7. User is landed to product detail page
        assertTrue(driver.findElement(By.id("productDetailPage")).isDisplayed());

        // 8. Verify that detail is visible: product name, category, price, availability, condition, brand
        assertTrue(driver.findElement(By.id("productName")).isDisplayed());
        assertTrue(driver.findElement(By.id("productCategory")).isDisplayed());
        assertTrue(driver.findElement(By.id("productPrice")).isDisplayed());
        assertTrue(driver.findElement(By.id("productAvailability")).isDisplayed());
        assertTrue(driver.findElement(By.id("productCondition")).isDisplayed());
        assertTrue(driver.findElement(By.id("productBrand")).isDisplayed());

    }
}
