package techproed.tests.day25_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_PropertiesKullanimi {
    @Test
    public void testamazon() {
        //amazon sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //basligin "Amazon.com. Spend less. Smile more." oldugunu  test edelim
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        String expectedTitle = ConfigReader.getProperty("expectedTitle");
        Assert.assertEquals(actualTitle, expectedTitle);

        //arama kutusunda iphone aratalim
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Sayfayi kapatalim
        Driver.closeDriver();

        //google sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //Sayfayi kapatalim
        Driver.closeDriver();

        //Facebook sayfasina gidelim
        Driver.getDriver().get("https://facebook.com");

        //Sayfayi kapatalim
        Driver.closeDriver();
    }
}
