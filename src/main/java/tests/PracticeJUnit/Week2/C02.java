package tests.PracticeJUnit.Week2;

import org.junit.*;

public class C02 {
    //@Test in yanina @Ignore koyarsak o testi ignore eder calıstırmaz
    @BeforeClass
    public  static void setUp(){ //static olmalı
        System.out.println("=================Test İşlmleri Başlatıldı===================");
        System.out.println(" ");
        System.out.println(" ");

    }

    @AfterClass
    public static void tearDown(){ //static olmalı
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=================Test İşlmleri Tamamlandı===================");
    }
    @Before
    public void before(){
        System.out.println("------------------Before-----------------------");
        System.out.println("         Yeni Bir Test Çalıştırılıyor          ");
        System.out.println(" ");
        //her bir testten once before calısır
    }
    @After
    public void after(){
        System.out.println(" ");
        System.out.println("------------------After-----------------------");
        System.out.println(" ");
        //her bir testten sonra after calısır
    }
    @Test
    public void test01(){
        System.out.println("1 Numaralı Test Çalıştırılıyor");
    }
    @Test
    public void test02(){
        System.out.println("2 Numaralı Test Çalıştırılıyor");
    }
    @Test
    public void test03(){
        System.out.println("3 Numaralı Test Çalıştırılıyor");
    }
    @Test
    public void test04(){
        System.out.println("4 Numaralı Test Çalıştırılıyor");
    }
    @Test
    public void test05(){
        System.out.println("5 Numaralı Test Çalıştırılıyor");
    }
}
