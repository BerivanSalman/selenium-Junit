package tests.Day10_actions_Faker_FileTestleri;

import Utilities.TestBase;
import org.junit.Test;

public class C04_DosyaYolunuDinamikYapma extends TestBase {
    @Test
    public void test01(){
         /*
            Java dosya yolunu dinamik hale getirebilmemiz icin
            bize iki temel konuma ulasmak icin hazir method sunmus

            1-  calistigimiz projenin dosya yoluna ulasmak isterseniz
                System.getProperty("user.dir") projenin icinde var olup olmadıgını bulmak icin bunu kullanırız

            2- bilgisayarin ana dosyayoluna ulasmak isterseniz
               System.getProperty("user.home") bilgisayarda biyerde olup olmadıgını kontrol etmek icin bunu kullanırız

               Eger bir takim halinde calisiyorsak
               projemizdeki bir dosya
               veya downloads'a indirdigimiz bir dosyanin varligini test etmek istiyorsak
               dosya yolunu bu iki kodu kullanarak dinamik hale getirmeliyiz
         */

        System.out.println(System.getProperty("user.dir"));     ///Users/berivansalman/IdeaProjects/com.team127_JUnitt

        System.out.println(System.getProperty("user.home")); ///Users/berivansalman
    }
}
