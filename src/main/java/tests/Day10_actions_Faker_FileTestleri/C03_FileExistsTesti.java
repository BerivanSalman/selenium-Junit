package tests.Day10_actions_Faker_FileTestleri;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistsTesti extends TestBase {
    @Test
    public void Test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. flower.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='flower.png']"))
                .click();
        ReusableMethods.bekle(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

       String dosyaYolu = "/Users/berivansalman/Downloads";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        C:\Users\breyh\         Downloads\logo.png
        C:\\Users\\ADMİN\\      Downloads\\logo.png
        C:\\Users\\HUAWEI\\     Downloads\\logo.png
        /Users/ahmetbulutluoz/  Downloads/logo.png

         */


    }
}
