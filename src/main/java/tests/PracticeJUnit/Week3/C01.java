package tests.PracticeJUnit.Week3;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class C01 extends TestBase {
    @Test
    public void Test01(){
        // 1-https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        // 2-Sign-up  butonuna basınız
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        // 3-Üye Kayıt sayfasında "New User Signup!" yazısının göründüğünü doğrulayın
        WebElement signUpText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        String expectedText = "New User Signup!";
        String actualText = signUpText.getText();
        Assert.assertEquals(expectedText,actualText);
        // 4-üye kaydı işlemini başlatın
        WebElement locator = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        actions.click(locator).sendKeys(firstname)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethods.bekle(2);
        // 5-Üye kayit formunu doldurun
        driver.findElement(By.id("id_gender2")).click();
        WebElement form = driver.findElement(By.xpath("//input[@data-qa='name']"));
        actions.click(form).sendKeys(firstname).sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.TAB).perform();
        WebElement days = driver.findElement(By.id("days"));
        Select selectGun = new Select(days);
        selectGun.selectByVisibleText("3");
        WebElement months = driver.findElement(By.id("months"));
        Select selectAy= new Select(months);
        selectAy.selectByVisibleText("January");
        WebElement year = driver.findElement(By.id("years"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("2021");
        driver.findElement(By.id("newsletter")).click();
        WebElement asagiForm = driver.findElement(By.id("first_name"));
        actions.click(asagiForm).sendKeys(firstname).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().country()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }

}
