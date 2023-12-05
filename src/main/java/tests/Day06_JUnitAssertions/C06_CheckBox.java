package tests.Day06_JUnitAssertions;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class C06_CheckBox {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void checkboxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement sirtAgrisiCheckBox = driver.findElement(By.xpath("//input[@id='gridCheck5']"));

        WebElement carpintiCheckBox = driver.findElement(By.id("gridCheck4"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carpintiCheckBox);
        jse.executeScript("arguments[0].click();",carpintiCheckBox);
        ReusableMethods.bekle(3);

        sirtAgrisiCheckBox.click();



        ReusableMethods.bekle(3);


       //sirtAgrisiCheckBox.click();


        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));


        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili
        //  	olduğunu test edin
        Assert.assertTrue(sirtAgrisiCheckBox.isSelected());
        Assert.assertTrue(carpintiCheckBox.isSelected());
//sayfayı asagı kaydırır bazen sayfanın asagisi gorunmeyince hata veriyor bunu kullanınca cozulur
        carpintiCheckBox.sendKeys(Keys.PAGE_DOWN);

        //	d. Seker ve Epilepsi checkbox’larininin seçili
        //  	olmadigini test edin
        WebElement sekerCheckBox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckBox = driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekerCheckBox.isSelected());
        Assert.assertFalse(epilepsiCheckBox.isSelected());

    }
}


