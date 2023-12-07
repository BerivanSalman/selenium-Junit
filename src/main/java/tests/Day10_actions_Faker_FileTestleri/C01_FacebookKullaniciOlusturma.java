package tests.Day10_actions_Faker_FileTestleri;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_FacebookKullaniciOlusturma extends TestBase {
    @Test
    public void test01(){
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com ");
        ReusableMethods.bekle(1);
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create new account']")).sendKeys(Keys.ENTER);
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
       WebElement locator =  driver.findElement(By.xpath("//*[@*='firstname']"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        Faker faker = new Faker();
        String email =faker.internet().emailAddress();
        // rewrite email dedigi icin bunu kaydetmemiz gerek birden fazla kullanabilelim diye
        actions.click(locator).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("20").sendKeys(Keys.TAB)
                .sendKeys("Mar").sendKeys(Keys.TAB)
                .sendKeys("1990").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();

//4- Kaydol tusuna basalim
        driver.findElement(By.name("websubmit")).click();

        ReusableMethods.bekle(15);
    }

    }

