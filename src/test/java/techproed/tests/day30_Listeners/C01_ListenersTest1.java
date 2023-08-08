package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {
    /*
    Olusturdugumuz test class'inda listeners yapisini kullanabilmek icin class'dan once @Listeners notasyonu
    olustururuz. Ve bu notasyona parametre olarak olusturdugumuz listeners class'inin yolunu belirtiriz.Liseners'da
    yolumuzu / ile degilde . ile belirtiriz.
     */

    @Test(invocationCount = 10, successPercentage = 90)
    /*
    Test methodlarinizi birden fazla calistirmak isterseniz @Test notasyomnundan sonra invocationCount
    parametresi ile belirttigimiz sayi kadar testlerimiz tekrar calisir.
        Listeners ile onTestFailedButWithinSuccessPercentage() bu methodu kullanmak istersek @Test notasyonundan sonra
    invocationCount = 10 ile birlikte successPercentage parametresi kullanarak örneğin testlerim 10 kez çalışsın
    successPercentage parametresine belirttiğim %90 bize 10 kez çalışan testlerimizden 1 tanesi fail olsa bile
    bu testi passed olarak verecektir. Eğer iki test fail olursa onTestFailedButWithinSuccessPercentage() bu method
    devreye girecektir.      */
    public void test01() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }

    @Test
    public void test02() {
        System.out.println("FAIL");
        Assert.assertTrue(false);
    }

    @Test
    public void test03() {
        System.out.println("SKIP");
        throw new SkipException("Bumethod atlandi");
    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().findElement(By.id("jhggfgffhg")).click(); //hata almak icin sacma locate olusturduk
    }
}
