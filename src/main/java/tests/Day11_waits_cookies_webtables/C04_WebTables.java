package tests.Day11_waits_cookies_webtables;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C04_WebTables extends TestBase {
    @Test
    public void Test01(){
         /*
            Klasik HTML kodlari kullanilarak olusturulan web tablolarinda
            istedigimiz cell(hucre) deki data'ya ulasmak icin
            sadece taglari kullanarak tablo/body/satir/data siralamasi kullaniriz

            1- Eger 1 of 1 bilgisine ulasabiliyorsak tum yolu yazmamiza gerek yok
            2- Eger sadece child HTML taglara bakmak isteniyorsa /
               child HTML taglarla birlikte grandChild taglara da bakmak istersek // kullaniriz
            3-
         */
        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement bodyElementi = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(bodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedIcerik = "Comfortable Gaming Chair";
        String actualBody = bodyElementi.getText();
        Assert.assertTrue(actualBody.contains(expectedIcerik));

        //4.Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriListesi = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirElementleriListesi.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5.Tum satirlari yazdirin
        System.out.println("====Tum satirlar===");

        // tum listeyi String'lerden olusan listeye cevirip yazdirabiliriz
        List<String> satirListesiStr = ReusableMethods.stringListeDonustur(satirElementleriListesi);
        System.out.println(satirListesiStr);

        // veya satir webelementlerini bir for loop ile yazdirip, basina aciklama da ekleyebiliriz

        for (int i = 0; i <satirElementleriListesi.size() ; i++) {

            System.out.println(i+1 + ". satir  : " + satirElementleriListesi.get(i).getText());
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        /*
            Web table'da sutun yapisi yoktur
            satirlar ve o ssatirlardaki datalar vardir

            sutun sayisini elde etmek icin
            herhangi bir satirdaki data sayisina bakabiliriz
         */
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//thead/tr/th"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = baslikElementleriList.size();

        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);


    }

}
