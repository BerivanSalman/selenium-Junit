package tests.Day10_actions_Faker_FileTestleri;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_BilgisayardakiDosyayiTestEtme extends TestBase {
    @Test
    public void test01(){
        //indirdigim sarkının bilgisayarda olup olmadıgına bi bak
        String dosyaYolu = "/Users/berivansalman/Downloads";
        Assert.assertTrue(Files.exists(Paths.get("/Users/berivansalman/Downloads")));
        // Herkeste farkli olan ==> user.home
        //          /Users/berivansalman
        // Herkeste ayni olan
        //          /Downloads/
        //Asagıdaki kod dinamiktir herkeste calısır
        String dinamikDosyaYolu = System.getProperty("user.home") +
                "/Downloads/";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

    }
}
