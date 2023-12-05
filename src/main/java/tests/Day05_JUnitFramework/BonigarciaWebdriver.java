package tests.Day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BonigarciaWebdriver {
    public static void main(String[] args) throws InterruptedException {
        //bir class'ta test işlemlerine başlamadan once ilk olarak Webdriver objemizi olusturup ayarlamaları yapmalıyız
       WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(1000);
        // arama kutusuna phone yazıp arama yapın
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='global-search']"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
       WebElement sonuc = driver.findElement(By.className("product-count-text"));
        System.out.println(sonuc.getText());
        String yeniSonuc =sonuc.getText().substring(0,1);
        int sayiliSonuc = Integer.parseInt(yeniSonuc);
        System.out.println(sayiliSonuc);
        //ilk urunu tıklayalım
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]")).click();
        //urun stokta ise var mı test et
        WebElement stokBilgisi = driver.findElement(By.xpath("//span[@class='heading-xs ']"));
        String expectedResult = "Availibility: In Stock";
        String actualResult =stokBilgisi.getText();
        if (expectedResult.equals(actualResult)){
            System.out.println("Urun stokta");
        }else {
            System.out.println("Urun stokta yok");
        }
        driver.quit();
    }
}
