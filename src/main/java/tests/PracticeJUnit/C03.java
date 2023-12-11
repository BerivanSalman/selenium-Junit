package tests.PracticeJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    /*
BeforeClass ile driver'i oluşturun ve class icinde static yapin
Maximize edin ve 10 sn bekletin
http://www.babayigit.net/testdocs adresine gidin
1-arama kutusuna "12 Angry Men” yaz ip, cikan sonuc şayisini yazdinin
2-arama kutusuna "Vizontele” yaz ip, cikan sonuc şayisini yazdirin
3-arama kutusuna "Saving Private Ryan” yazip, cikan sonuc şayisini yazdirin
4-arama kutusuna "3 idiots” yazip, cikan sonuc şayisini yazdirin
AfterClass ile kapatin.
 */
    static WebDriver driver; //Webdriveri her bir test notasyonu icinde  kullanabilmemiz icin static olarak burda tanımlıyoruz
    WebElement searchbox;
    String filmName;
    //searcbox ve film name i tum test notasyonlarında kullanabillmek  icin burda tanımlama yaptık

    @BeforeClass
    public static void setUP(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit(); //tum testler bittikten sonra kapatacak
    }
    @Before
    public void before(){
        driver.get("http://www.babayigit.net/testdocs");
        searchbox=driver.findElement(By.xpath("//input[@id='search']"));
        //her bir testten once burda tanımlanan adrese gidecek ve searchbox diger test notasyonlarında sürekli kullanılacagı
        // icin burda tanımlama yaptık
    }

    @After
    public void after(){
        System.out.println(filmName+" Sonuç Sayısı: "+driver.findElement(By.xpath("//*[@id='result-stats']")).getText());
        System.out.println("Window Handler: "+driver.getWindowHandle());
        //her bir test notasyonundan sonra sonuc sayisi yazacagı icin locate i burda aldık

    }

    @Test
    public void test01(){
        filmName="12 Angry Men";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }
    @Test
    public void test02(){
        filmName="Vizontele";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }
    @Test
    public void test03(){
        filmName="Saving private er ryan";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

    @Test
    public void test04(){
        filmName="3 idiots";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
    }

}
