package tests.Day07_testBaseClass_DropDown;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {
    //birden fazla kutu işaretleyemeyiz readio buttonda
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void radioButtonYaziTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Cinsiyet Radio button elementlerini locate edin ve
        //     radio buttonu isaretleyerek size uygun olani secin
      WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
      WebElement erkekRadioButton =driver.findElement(By.id("inlineRadio2"));
      WebElement digerRadioButton =driver.findElement(By.id("inlineRadio3"));
      erkekRadioButton.click();
        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
        ReusableMethods.bekle(3);
    }
    @Test
    public void RadioButtonYaziElementi(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Cinsiyet Radio button elementlerini locate edin ve
        //     yaziyi click ederek size uygun olani secin

        // secimi yazi ile yapabilirim
        // ama assertion'lar icin radio button'lara ihtiyacimiz var
        WebElement erkekRadioButtonYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioButtonYaziElementi.click();
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
        ReusableMethods.bekle(2);
    }


}
