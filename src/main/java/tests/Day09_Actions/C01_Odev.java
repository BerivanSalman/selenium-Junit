package tests.Day09_Actions;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_Odev extends TestBase {
    /*
        Kontrolsuz bir tab/window acildiginda
        eger yeni acilan tab/window'un title degeri biliniyorsa
        driver'i acilan sayfaya geciren bir method olusturun
        input : yeniTitle , Test Otomasyonu - Electronics
     */
    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkSayfaWindowHandle = driver.getWindowHandle();
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.tagName("h2"));
        String expectedText = "Add/Remove Elements";
        String actualText = text.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();
        //● Electronics sayfasinin acildigini test edin
        driver = ReusableMethods.titleIleSayfaDegistir(driver,"Test Otomasyonu - Electronics");
        System.out.println(driver.getTitle());

        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkSayfaWindowHandle);
        //● Url’in addremove icerdigini test edin
        String expectedUrl = "addremove";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        ReusableMethods.bekle(2);

    }


}
