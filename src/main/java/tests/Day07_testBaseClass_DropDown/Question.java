package tests.Day07_testBaseClass_DropDown;

import Utilities.TestBase_BeforeClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Question extends TestBase_BeforeClass {
    @Test
    public void dropdownTest() {
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown ");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        // 1. Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        System.out.println("Secilen index = " + select.getFirstSelectedOption().getText());
        // 2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("Secilen value = " +select.getFirstSelectedOption().getText());
        // 3. Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("Secilen text = "+select.getFirstSelectedOption().getText());
        // 4. Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumDegerler = select.getOptions();
        List<String> elementList = new ArrayList<>();
        System.out.println("Tum degerler: ");
        for (WebElement deger:tumDegerler)
       {
         elementList.add(deger.getText());
           //System.out.println(deger.getText());
       }
        System.out.println(elementList);

        // 5. Dropdown’un boyutunun 4 olduğunu test edin
        Assert.assertEquals(4,tumDegerler.size());
    }


}
