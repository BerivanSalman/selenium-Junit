package tests.Day10_actions_Faker_FileTestleri;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_ProjeicindekiDosyaTesti extends TestBase {
    @Test
    public void fileExistTesti(){
        // projemiz icerisinde day10 package'i altinda
        // deneme.txt dosyasinin oldugunu test edin
        String dosyaYolu = "/Users/berivansalman/IdeaProjects/com.team127_JUnitt/src/main/java/tests/Day10_actions_Faker_FileTestleri/deneme.txt";
        // bu dosya yolunu kullanırsak sadece bizim bilgisayarda calısır.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //Herkeste farklı olan kisim ==> user.dir
        //        /Users/berivansalman/IdeaProjects/com.team127_JUnitt
        //Herkeste ayni olan kisim ==> projenin icindeki dosya yolu
        //       /src/main/java/tests/Day10_actions_Faker_FileTestleri/deneme.txt

        String dinamikDosyayolu = System.getProperty("user.dir")+
                "/src/main/java/tests/Day10_actions_Faker_FileTestleri/deneme.txt";
Assert.assertTrue(Files.exists(Paths.get(dinamikDosyayolu)));
//Bu dinamik herkeste calısır
    }
}
