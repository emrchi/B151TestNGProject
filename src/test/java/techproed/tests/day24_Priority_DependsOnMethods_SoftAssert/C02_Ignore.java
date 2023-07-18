package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // Asagidaki test methodlari Priority kullanmadigimiz zaman amazon-facebook-yotube sirasi ile calisir.
    // Birden fazla test methodu calistirmak istedigimiz de ve o anlik gereksiz gordugumuz test methodunu
    // atlamak isteyebiliriz. Bu durumda @Test notasyonu ustune yada yanina @Ignore notasyonu ekleriz.

    //Eger bir methodu tamamen iptal etmek istersek @Test notasyonundan sonra parametre olarak (enable=false) kullaniriz.

    @Ignore
    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
    }
    @Test(enabled = false)
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }
    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
