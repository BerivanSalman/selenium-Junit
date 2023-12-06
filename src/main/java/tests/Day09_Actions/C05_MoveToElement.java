package tests.Day09_Actions;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_MoveToElement extends TestBase {
    @Test
    public void Test01(){
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        ReusableMethods.bekle(1);
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        //3- “Boys” linkine basin buna basabilmek icin once Kids Wear ın ustunde mouse nin beklemesi lazım
        WebElement kidsWear = driver.findElement(By.xpath("(//*[text()='Kids Wear'])[3]"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);
        actions.moveToElement(kidsWear).perform();
        //3- “Boys” linkine basin
        WebElement boysLinki = driver.findElement(By.xpath("(//ul[@class='submenu-link'])[2]"));
        boysLinki.click();

    }
}
