package tests.Day05_JUnitFramework;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Friendsquestion extends TestBase {
    @Test
    public void FikretHoca(){
        // https://trytestingthis.netlify.app/ adresine gidin
        driver.get("https://trytestingthis.netlify.app/");
        // "Your Website to practice Automation Testing" gorundugunu dogrulayin
        WebElement websiteYazi =driver.findElement(By.xpath("//h1[@style='font-family:Arial;']"));
        Assert.assertTrue(websiteYazi.isDisplayed());
        // "This is your Sample login page" de bulunan "username" ve "password" de
        // aciklamaya uygun degerleri girerek login olun
        driver.findElement(By.id("uname")).sendKeys("test");
        driver.findElement(By.id("pwd")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // "Login Successful :)" yazisinin gorunurlugunu dogrulayin
        WebElement login = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(login.isDisplayed());
        // "Click here to go back to the home page" yazisinde bulunan
        //   "here" linkini kullanarak ana sayafaya donun
        driver.findElement(By.xpath("(//a[@href=\"/\"])[2]")).click();
        // Ana sayfaya dondugunuzu dogrulayin
        String expectedUrl = "https://trytestingthis.netlify.app/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Anasayfadayiz",expectedUrl,actualUrl);
    }
}
