package tests.Day05_JUnitFramework;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebAppTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //Signin butonuna tıklayın
        driver.findElement(By.id("signin_button")).click();
        //Login alanına "username" yazdirin
        driver.findElement(By.id("user_login")).sendKeys("username");
        //password alanina "password"yazdırın
        driver.findElement(By.id("user_password")).sendKeys("password");
        //signin butonuna tıklayın
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //Back tusu ile sayfaya donun
        driver.navigate().back();
        //Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        //Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();
        //amount kısmına yatırmak istediginiz herhangi bir miktarı yazın
        driver.findElement(By.id("sp_amount")).sendKeys("100");
        //tarih kısmına "2023-09-10" yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2023-09-10");
        //Pay butonuna tıklayın
        driver.findElement(By.id("pay_saved_payees")).click();
        //The payment was successfully submitted yazısının cıktıgını test edin
       WebElement text = driver.findElement(By.id("alert_content"));
       String actualText = text.getText();
        String expectedText ="The payment was successfully submitted.";
        if (expectedText.equals(actualText)){
            System.out.println("Payment Test Passed");
        }else {
            System.out.println("Payment Test Failed");
        }
        ReusableMethods.bekle(3);
        driver.quit();
    }
}
