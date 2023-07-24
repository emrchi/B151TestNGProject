package techproed.tests.day27_SmokeTest_Excel;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class day27_Homework_US4 {
    /*
    Name:
    US101122_Negative_Login
    Description:
    Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
    Acceptance Criteria:
    Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
    Error Message: email must be a valid email
    Dogru email uzantisi girildiğinde hata mesajı alınmamalı
    https://email-verify.my-addr.com/list-of-most-popularemail-domains.php
     */

    @Test
    public void test01() {
        //BlueRental sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tikla ve email kutusuna gecersiz email uzantisi yazdir
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(1);
        rentalPage.email.sendKeys("emre@gmailcom");

        //Hata mesajinin gorunur oldugunu dogrula
        ReusableMethods.bekle(1);
        Assert.assertTrue(rentalPage.invalidEmail.isDisplayed());

        //email kutusuna gecersiz email uzantisi yazdir
        Driver.getDriver().navigate().refresh();
        rentalPage.email.sendKeys(ConfigReader.getProperty("bleuRentalemail"));

        //Hata mesajinin gorunur olmadigini dogrula
        ReusableMethods.bekle(1);
        Assert.assertFalse(rentalPage.invalidEmail.isDisplayed());

        //Sayfayi kapat
        Driver.closeDriver();



    }
}
