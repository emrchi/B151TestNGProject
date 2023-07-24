package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegativeTest {
    @Test(groups = {"smoke"})
    public void test01() {
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //https://www.bluerentalcars.com/
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found

        //BlueRental sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tikla
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"), Keys.TAB,
                                  ConfigReader.getProperty("fakePassword"), Keys.ENTER);

        //Hata mesajinin gorunur oldugunu dogrula
        ReusableMethods.bekle(2);
        Assert.assertTrue(rentalPage.mesajVerify.isDisplayed());

        //Sayfayi kapat
        Driver.closeDriver();




    }
}
