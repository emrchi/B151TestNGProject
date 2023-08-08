package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C03_ListenersTest3 {
    /*
    Eger fail olan testlerimizi otomatik olarak belirttigimiz sayi kadar calistirmak istersek
    listeners class'indaki retry ve transform methodlari sayesinde calistirabiliriz. Bunun icin
    calistirmak istedigimiz test methodunun notasyonundan sonra parametre olarak;
    retryAnalyzer = techproed.utilities.Listeners.class  parametresini kullanarak listener class'inin yolunu belirtiriz.
    listener class'inda maxRetryCount = 1 olarak belirttigimiz icin 1 kere tekrar calisir.
     */
    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void googletest() {
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().findElement(By.id("fsgdhsjsj")).click();
    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void techprotest() {
        Driver.getDriver().get("https://techproeducation.com");
        Driver.getDriver().findElement(By.id("fsgdhsjsj")).click();
    }
}
