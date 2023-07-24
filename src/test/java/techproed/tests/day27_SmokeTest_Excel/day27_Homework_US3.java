package techproed.tests.day27_SmokeTest_Excel;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class day27_Homework_US3 {
    /*
    Name:
    US100402_Negative_Login
    Description:
    Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
    Acceptance Criteria:
    Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
    Hata Mesaji:
    Bad credentials
    Test Data:
    Customer email: jack@gmail.com
    Customer password: fakepass
     */

    @Test
    public void test01() {
        //BlueRental sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tikla ve dogru email ve yanlis sifre ile login ol
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(1);
        rentalPage.email.sendKeys(ConfigReader.getProperty("bleuRentalemail"), Keys.TAB,
                                             ConfigReader.getProperty("fakePassword"), Keys.ENTER);

        //Hata mesajinin gorunur oldugunu dogrula
        ReusableMethods.bekle(1);
        Assert.assertTrue(rentalPage.mesajVerify.isDisplayed());

        //Sayfayi kapat
        Driver.closeDriver();

    }
}
