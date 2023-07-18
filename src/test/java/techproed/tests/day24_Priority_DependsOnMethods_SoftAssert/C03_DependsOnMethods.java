package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMethods {
    /*
    Test methodlari birbirinden bagimsiz calisir. Methodlari birbirine bagimli calistirmak istersek
    @Test notasyonundan sonra DependsOnMethods parametresini, baglamak istedigimiz test methodunun adini yazarak  belirtiriz.
     */
    WebDriver driver;

    @Test
    public void test01() {
        //Bu method'da driver ayarlarini yapalim.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //amazon sayfasina gidelim.
        driver.get("https://amazon.com");
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        //amazon'da arama kutusunda iphone aratalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

    }
    /*
    Yukari daki testlerde driverimizi test1 de ayarladigimiz icin test2 ve test3'u bagimsiz olarak calistirdigimiz da
    NullpointerExepcition aliriz cunku driverimizi o testlerde tanitmadik.
    Biz bunu dependsonmethods ile astik fakat class seviyesinden calistirmak zorundayiz.
    Ayni sekilde priority ekleyebiliriz asagidaki gibi.
     */

    @Test
    public void test04() {
        //Bu method'da driver ayarlarini yapalim.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1,dependsOnMethods = "test01")
    public void test05() {
        //amazon sayfasina gidelim.
        driver.get("https://amazon.com");
    }

    @Test(priority = 2)
    public void test06() {
        //amazon'da arama kutusunda iphone aratalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

    }
}
