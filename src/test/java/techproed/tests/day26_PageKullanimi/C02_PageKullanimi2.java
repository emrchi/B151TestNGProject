package techproed.tests.day26_PageKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage2;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PageKullanimi2 {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));
        //Username : Admin
        //Password : admin123

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        OpenSourcePage2.username().sendKeys(ConfigReader.getProperty("OpenSourceusername"));
        OpenSourcePage2.password().sendKeys(ConfigReader.getProperty("OpenSourcepassword"));
        OpenSourcePage2.submitButton().click();

        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(OpenSourcePage2.verify().isDisplayed());

        //Sayfayı kapatınız
        Driver.closeDriver();
    }
}
