package techproed.tests.day27_SmokeTest_Excel;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class day27_HomeworkUS5 {
    @Test
    public void test01() {
        /*
        Name:
        US101201_Negative_Login
        Description:
        Geçerli giriş yapmadan rezervasyon yapamamalı
        Acceptance Criteria:
        Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
        Ve giris yapilmadiginda
        Hata mesaji almali : Please first login
        Giris yapildiginda hata mesaji alınmamalı
         */

        //BlueRental sayfasina git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //select car menusunden arac sec
        BlueRentalPage rentalPage = new BlueRentalPage();
        Select select = new Select(rentalPage.ddmCar);
        select.selectByIndex(5);

        //Tum bilgileri doldur
        rentalPage.ddmCar.sendKeys(Keys.TAB,"Besiktas", Keys.TAB,"Bebek", Keys.TAB,"07/21/2023",
                                              Keys.TAB,"11:22 AM", Keys.TAB,"09/21/2023", Keys.TAB,"11:22 AM",Keys.TAB,Keys.ENTER);

        //Login buttonuna tikla
        //BlueRentalPage rentalPage = new BlueRentalPage();
        //rentalPage.login.click();

        //Gecerli email ve password ile giris yap
       // rentalPage.email.sendKeys(ConfigReader.getProperty("bleuRentalemail"), Keys.TAB,
                                 // ConfigReader.getProperty("blueRentalpassword"),Keys.ENTER);

    }
}
