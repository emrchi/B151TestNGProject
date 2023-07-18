package techproed.tests.day23_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Her seyden once bir kez BeforeSuit calisir.");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Butun testler'den once bir kez beforeTest calisir.");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Her class'dan once bir kez beforeClass calisir.");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Junit'deki @Before notasyonu gibi her mettoddan once calisir.");
    }

    @Test
    public void test01() {
        System.out.println("Test01 calisti.");
    }@Test
    public void test02() {
        System.out.println("Test02 calisti.");
    }@Test
    public void test03() {
        System.out.println("Test03 calisti.");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Her seyden sonra bir kez afterSuite calisir.");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Butun testler'den sonra bir kez afterTest calisir.");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Her class'dan sonra bir kez afterClass calisir.");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Junit'teki @After notasyonu gibi her method'dan sonra çalışır");
    }
}
