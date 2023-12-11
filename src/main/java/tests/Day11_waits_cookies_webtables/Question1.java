package tests.Day11_waits_cookies_webtables;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Question1 extends TestBase {
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualContext = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualContext);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // 6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
     driver = ReusableMethods.titleIleSayfaDegistir(driver,"Elemental Selenium | Elemental Selenium");
     WebElement yaziElementi = driver.findElement(By.tagName("h1"));
     String expectedYazi = "Make sure your code lands";
     String actualYazi = yaziElementi.getText();
     Assert.assertEquals(expectedYazi,actualYazi);

    }






}
