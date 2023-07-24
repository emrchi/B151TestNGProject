package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {
    @Test
    public void test01() {
        //Bluerentacar adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //mysmoketestdata ecxel dosyasindaki herhangi bir email ve passwordile login olalim
        ExcelReader reader = new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx","customer_info");
        String email = reader.getCellData(2,0);
        String password = reader.getCellData(2,1);
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(email, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.bekle(2);

        //login oldugumuzu dogrulayalim
        Assert.assertTrue(rentalPage.loginVerify.getText().contains("Kate"));

        //sayfayi kapatalim
        Driver.closeDriver();
    }


}
