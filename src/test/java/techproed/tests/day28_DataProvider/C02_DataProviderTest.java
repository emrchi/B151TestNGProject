package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {


         /*
        google sayfasina gidip dataProvider ile belirtilan arac isimlerini aratalim
         */
    @DataProvider
    public static Object[][] araclar() {
        return new Object[][]{{"volvo"},{"ford"},{"mercedes"}, {"audi"}};
    }
    @Test(dataProvider = "araclar")
    public void test01(String araclar, ITestResult result) {

        // google sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //Dataprovider'daki verilerle arama yapalim
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        ReusableMethods.bekle(2);

        //Her arama icin sayfa resmi alalim


        ReusableMethods.tumSayfaResmi(result.getName());

        //sayfayi kapatalim
        Driver.closeDriver();


    }
}
