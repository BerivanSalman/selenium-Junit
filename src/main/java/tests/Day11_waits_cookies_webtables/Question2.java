package tests.Day11_waits_cookies_webtables;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Question2 extends TestBase {
    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement dragElementi = driver.findElement(By.id("draggable2"));
        WebElement dropElementi =driver.findElement(By.id("droppable2"));
        Actions actions =new Actions(driver);
       ReusableMethods.bekle(2);
        actions.dragAndDrop(dragElementi,dropElementi).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYazisi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedText = "Dropped!";
        String actualText = droppedYazisi.getText();
        Assert.assertEquals(expectedText,actualText);
        // 4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(2);
        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptaptable = driver.findElement(By.id("draggable-nonvalid2"));
        dropElementi = driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(notAcceptaptable,dropElementi).perform();
        //6- “Drop Here” yazisinin degismedigini test edin
        WebElement dropYazisi = driver.findElement(By.xpath("//p[text()='Drop Here']"));
      String actualDrop = dropYazisi.getText();
      Assert.assertFalse(expectedText.equals(actualDrop));
    }
}
