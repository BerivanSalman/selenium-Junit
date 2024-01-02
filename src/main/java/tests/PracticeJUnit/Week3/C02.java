package tests.PracticeJUnit.Week3;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02 extends TestBase {
    @Test
    public void test01(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe ");
       // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iframeText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeText.isEnabled());
        System.out.println(iframeText.getText());
        //- Text Box’a “Merhaba Dunya!” yazin. Text iframe icinde oldugu icin iframe e gecis yapmamız lazım
        WebElement iFarmeElementi = driver.findElement(By.id("mce_0_ifr")); //İframe i locate ettik
        driver.switchTo().frame(iFarmeElementi);
        //gecis yaptıktan sonra yazı yazacagımız textin oldugu yeri locate ederiz;
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya");




    }
}
