package tests.Day07_testBaseClass_DropDown;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_JsAlerts extends TestBase {
    /*
    1- HTML Alerts
Bir alert ciktiginda sag click ile inspect yapabiliyorsak html alert’dir ve extra bir
isleme gerek yoktur.
   2- Js Alerts
Js alerts inspect yapilamaz, ekstra isleme ihtiyac vardir
     */
    /*
    3 test method'u olusturup asagidaki gorevi tamamlayin
     */
    @Test
    public void jsBasicAlert(){
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText(); //driver alerte gecip ordan yaziyi alıp bize getirir
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        // - OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept(); //alert e gec ve kapat alerti
    }
    @Test
    public void jsConfirmAlert(){
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        // Cancel'a basip,
        driver.switchTo().alert().dismiss();
        //cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedYazi = "You clicked: Cancel";
        String actualYazi = resultYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
    @Test
    public void jsPromptTesti (){
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        // Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        // OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement yazi = driver.findElement(By.id("result"));
        String expectedYazı = "Abdullah";
        String actualYazi = yazi.getText();
        Assert.assertTrue(actualYazi.contains(expectedYazı));
    }
}
