package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi){
        List<String> stringlerListesi = new ArrayList<>();
        for (WebElement each:elementlerListesi
             ) {
            stringlerListesi.add(each.getText());
        }return stringlerListesi;

    }
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void istenenelemanascrollyapma(WebDriver driver,WebElement scrollyapılacakelemet){
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",scrollyapılacakelemet);
    }
    public static WebDriver titleIleSayfaDegistir(WebDriver driver, String hedefSayfaTitle){

        Set<String> tumWindowHandleSeti = driver.getWindowHandles();
        for (String each:tumWindowHandleSeti
             ) {
            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(hedefSayfaTitle)){
                return driver;
            }
        }
        return driver;
        

    }
}
