package techproed.tests.day26_PageKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_PozitifTest {
    @Test(groups = {"smoke"})
    public void test01() {
        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //https://www.bluerentalcars.com/
        //Admin email: jack@gmail.com
        //Admin password: 12345

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(ConfigReader.getProperty("bleuRentalemail"), Keys.TAB,
                                  ConfigReader.getProperty("blueRentalpassword"),Keys.ENTER);
        ReusableMethods.bekle(2);

        String loginVerify2 = rentalPage.loginVerify.getText();
        Assert.assertTrue(loginVerify2.contains("Jack"));

        Driver.closeDriver();
    }
}
