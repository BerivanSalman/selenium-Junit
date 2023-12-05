package tests.Day07_testBaseClass_DropDown;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C04_DropdownMenu extends TestBase {

    @Test
    public void dropdownTesti(){
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
       // 4. Password kutusuna “password” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.navigate().back();
        //6. Online banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDdm = driver.findElement(By.id("pc_currency"));
        Select selectUlke = new Select(currencyDdm);
        selectUlke.selectByValue("EUR");
       // 9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("500");
        //10. “US Dollars” in secilmedigini test edin
        WebElement radioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(radioButton.isSelected());
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        driver.findElement(By.id("purchase_cash")).click();
       WebElement success = driver.findElement(By.id("alert_content"));
       Assert.assertTrue(success.isDisplayed());
    }
}
