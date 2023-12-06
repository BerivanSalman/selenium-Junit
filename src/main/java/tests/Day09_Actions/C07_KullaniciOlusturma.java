package tests.Day09_Actions;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C07_KullaniciOlusturma extends TestBase {
    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com ");
        //2- Account linkine tiklayin
        WebElement accountLink = driver.findElement(By.xpath("(//span[text()='Account'])[1]"));
        accountLink.click();
        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();
        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstName = driver.findElement(By.id("firstName"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstName).sendKeys("Berivan").sendKeys(Keys.TAB).sendKeys("Salman")
                .sendKeys(Keys.TAB).sendKeys("bberivansalman@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("Berivan.1993").sendKeys(Keys.TAB)
                .sendKeys("Berivan.1993").perform();
 driver.findElement(By.xpath("//*[@class='submitbtn btn-lg']")).sendKeys(Keys.ENTER);
        //5- Kaydin olusturuldugunu test edin
        //   Kayit olusturulunca bizi signIn sayfasina yonlendiriyor
        //   Kaydin olusturuldugunu test etmek icin
        //   girdigimiz bilgilerle login olabildigimizi test edelim
        WebElement emailKutusu= driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("bberivansalman@gmail.com");
        passwordKutusu.sendKeys("Berivan.1993");
        ReusableMethods.bekle(1);
        signInButonu.click();

        WebElement logoutLinki = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assert.assertTrue(logoutLinki.isDisplayed());

        ReusableMethods.bekle(2);
        logoutLinki.click();

        ReusableMethods.bekle(2);

    }
}
