package tests.Day11_waits_cookies_webtables;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C03_cookies extends TestBase {
    @Test
    public void test01(){
            //1- amazon anasayfaya gidin
            driver.get("https://www.amazon.com");
            //2- tum cookie’leri listeleyin
            Set<Cookie> cookiesSeti = driver.manage().getCookies();
            int siraNo = 1 ;
            for (Cookie each : cookiesSeti //Each cookieleri cookiesSetinden getirecek
            ) {
                System.out.println(siraNo + "=====> " + each);
                siraNo++;
            }

            //3- Sayfadaki cookies sayisinin 0'dan buyuk oldugunu test edin
            int expectedMinCookieSayisi = 0;
            int actualCookiesayisi = cookiesSeti.size();
            Assert.assertTrue(actualCookiesayisi > expectedMinCookieSayisi);

        //4- ismi csm-sid olan cookie degerinin USD oldugunu test edin
        String expectedCookieValue = "USD";
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();//i18n-prefs isimli cookienin degerini getirir
        Assert.assertTrue(expectedCookieValue.equals(actualCookieValue));

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);   //2=====> en sevdigim cookie=cikolatali; path=/; domain=www.amazon.com;secure;; sameSite=Lax


        //eklendikten sonraki halini gormek icin cookie setini yeniden alıp yazdırıyoruz asagida;
        cookiesSeti = driver.manage().getCookies();
        siraNo = 1 ;
        for (Cookie each : cookiesSeti
        ) {
            System.out.println(siraNo + "=====> " + each);
            siraNo++;
        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        expectedCookieValue = "cikolatali";
        actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        // olmayan bir cookie'nin degerini yazdirsak;
        System.out.println(driver.manage().getCookieNamed("Boyle bir cookie yok")); // olmayan cookie null verir
        driver.manage().deleteCookieNamed("skin"); //ismi skin olani sil
        Assert.assertTrue(driver.manage().getCookieNamed("skin") == null);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//Tum cookie leri sileriz
        cookiesSeti = driver.manage().getCookies(); //Cookies i set olarak yazdırırız sildiğimiz icin size ı 0 dır. Asagıda da test ederiz
        Assert.assertTrue(cookiesSeti.size() == 0);

        ReusableMethods.bekle(2);
    }
}
