package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_DataProviderTest {
    @DataProvider
    public static Object[][] blueRentalLogin() {
        return new Object[][]{{"sam.walker@bluerentalcars.com" , "c!fas_art"},
                              {"kate.brown@bluerentalcars.com" , "tad1$Fas"},
                              {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                              {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
    }

    @Test(dataProvider = "blueRentalLogin")
    public void test01(String mail, String password) {

        //Bluerentalcar sitesine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //DataProvider'daki mail ve password bilgileri ile login olalim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.bekle(1);
        blueRentalPage.email.sendKeys(mail, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.bekle(1);

        //Sayfayi kapatalim
        Driver.closeDriver();
        
    }
}
