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
public class C05_CheckBox {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void checkboxTesti(){
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        WebElement carpinti = driver.findElement(By.id("gridCheck4"));
        WebElement sirtAgrisi = driver.findElement(By.id("gridCheck5"));
        sirtAgrisi.sendKeys(Keys.PAGE_DOWN);

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

    }
}


