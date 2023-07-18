package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class day24_homeWork_SoftAssert {


    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Sign in butonuna basin
        driver.findElement(By.className("icon-signin")).click();

        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password” yazin
        //5. Sign in tusuna basin
        WebElement login = driver.findElement(By.xpath("//*[@type='text']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.TAB,Keys.ENTER);
        driver.navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByIndex(6);

        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        List<String> actualList = new ArrayList<>();
        select.getOptions().forEach(w->actualList.add(w.getText()));
        String actual = actualList.get(6);
        String expected = "Eurozone (euro)";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);


        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //   edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //            (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //            (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //            (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //            (dollar)","Thailand (baht)"


        List<String> expectedList = List.of("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
                "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
                "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)");
        softAssert.assertEquals(expectedList, actualList);
        softAssert.assertAll();
    }
}
