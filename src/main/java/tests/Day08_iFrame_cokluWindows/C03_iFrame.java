package tests.Day08_iFrame_cokluWindows;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_iFrame extends TestBase {
    @Test
    public void test01(){
         //1-http://demo.guru99.com/test/guru99home/ adresine gidin
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2-sayfadaki iframe sayisini bulunuz
        //Once list olustururuz birden fazla oldugu icin
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi: "+iframeList.size());
        //3-ilk iframedeki  (Youtube) play butonuna basiniz (Bu da iframe icindedir)
        //Once iframe i locate ediyoruz
        WebElement playIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(playIframe);
        driver.findElement(By.xpath("//button[@aria-label=\"Play\"]")).click();
        //4-ilk iframe den cıkıp ana sayfaya donunun
        driver.switchTo().defaultContent();
    }
}
