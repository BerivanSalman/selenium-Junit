package tests.PracticeJUnit;

import org.junit.Test;

public class C01 {
    //Artık main method kullanmıyoruz. Notasyonlarla yapıyoruz herseyi
      /*
   @BeforeClass---> Tüm Method'dan önce 1 kere çalışır
   @AfterClass---> Tüm Method'dan sonra 1 kere çalışır
   @Before---> Her Method'dan önce  1 kere çalışır
   @After---> Her Method'dan sonra  1 kere çalışır
   @Test---> Methodlarımızı çalıştırır
*/
    //asagidaki methodlari caliştirma sırası karısıktır. Sırasıyla calısmasını istersek test01, test02 gibi sayılar vermeliyiz.
    // Ya da before notasyonu eklemeliyiz
    @Test
    public void ayca01(){
        System.out.println("ayça");
    }

    @Test
    public void nevfel05(){
        System.out.println("nevfel");
    }

    @Test
    public void zeybek(){
        System.out.println("zeybek");
    }

    @Test
    public void samet(){
        System.out.println("samet");
    }

    @Test
    public void zehra(){
        System.out.println("zehra");
    }
}
