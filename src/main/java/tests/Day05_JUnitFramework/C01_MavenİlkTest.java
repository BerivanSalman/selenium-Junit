package tests.Day05_JUnitFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenİlkTest {
    //Maven bir Build Tool dur. Proje olusturulurken arklı enstrumanları bir araya getirerek
    // ve gerektiginde update etmek icin kullanılır.
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(2000);
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.quit();
    }
}
