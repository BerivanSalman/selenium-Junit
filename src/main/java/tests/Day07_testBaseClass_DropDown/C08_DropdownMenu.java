package tests.Day07_testBaseClass_DropDown;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C08_DropdownMenu extends TestBase {
    @Test
    public void dropdownTesti(){
        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Option 1 i secin ve yazdırın
        WebElement dropdownMenu = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownMenu);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //value kullanarak Option 2 yi secin ve yazdirin
        Select select1 = new Select(dropdownMenu);
        select1.selectByValue("1");
        System.out.println(select1.getFirstSelectedOption().getText());
        //visible text kullanarak Option 1 i secin ve yazdirin
        Select select2 = new Select(dropdownMenu);
        select2.selectByVisibleText("Option 1");
        System.out.println(select2.getFirstSelectedOption().getText());
        //tum dropdown degerleri yazdirin (Bir list olusturulur)
        List<WebElement> optionsList = select.getOptions();
        //Webelementleri direkt yazdıramayız. For eachle yazdırırız
        for (WebElement each: optionsList) //each optionsListten Webelementleri getirir bize
        {
            System.out.println(each.getText()); //burda da her getirdiği Webelementin textini alırız
        }
        //dropdown un boyutunun 4 oldugunu test edin
        int expectedBoyut = 4;
        int actualBoyut = optionsList.size();
        Assert.assertEquals(expectedBoyut,actualBoyut);
        /*Failed oldu
        Expected :4
        Actual :3
         */

    }
}
