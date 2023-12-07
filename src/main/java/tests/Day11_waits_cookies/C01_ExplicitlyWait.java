package tests.Day11_waits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {
    @Test
    public void implicitlyWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("(//*[text()='Remove'])")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement goneText= driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(goneText.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
        driver.quit();

    }

    @Test
    public void explicitlyWaitTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

            /*
            Eger kullanmak istedigimiz element locate edilebilir durumda ise
            once locate edip
            sonra istenen condition icin bekleyebiliriz
            Ama bu soruda oldugu gibi
            locate ve bekleme kisir dongu olusturuyorsa
            locate ve bekleme islemi birlikte yapilabilir
 // 1.adim : bir wait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            // 2.adim : bekleyecegimiz webelement'i locate edin
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
            // 3.adim : wait objesini kullanarak istediginiz webelement uzerinde islem yapin
        wait.until(ExpectedConditions.visibilityOf(itsGoneyaziElementi));
             */

        // 1.adim : bir wait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        // 2. adim : bekleme icin olusturdugumuz wait objesini kullanarak
        //           beklenecek webElementin locate'ini ve beklemeyi birlikte yapariz

        WebElement itsGoneyaziElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        driver.quit();
    }
    }
