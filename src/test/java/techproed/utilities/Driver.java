package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

    /*
    POM(Page Object model)
        Test senaryolarunun daha az kod ile yazilmasina ve bakiminin daha kolay
        yapilmasina olanak saglayan yazilim test yontemidir. TestNG ve Cucumber
        frameworklerinde POM kalibi kullanilir.
     */

public class Driver {

    private Driver(){
        /*
    Driver class'indan obje olusturmanin onune gecebilmek icin default constructor'i
    private yaparak bunu engellemis oluruz .
    Bu kaliba da Singleton pattern denir.
     */
    }

    static WebDriver driver;
    public static WebDriver getDriver() {
        /*
        DRiver'i her cagirdigimiz da yeni bir pencere acilmasinin onune gecmek icin
        if blogu icinde eger driver'a deger atanmamissa deger ata, eger deger atanmis ise
        driver'i ayni sayfada return et.
         */

        /*
            .properties dosyasina key olara browser ve degerini assagida olusturdugumuz switch caselerden birini seceriz
        ve sectigimiz driver calisir.
         */
        if(driver==null) {                            //->Driver'a deger atanmamissa demek
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    public static void closeDriver() {
        if(driver!=null) {                   //->Driver'a deger atanmissa.
            driver.close();
            driver  = null;                  //->Driver'i kapattiktan sonra bosalt.
        }
    }

    public static void quitDriver() {
        if(driver!=null) {                   //->Driver'a deger atanmissa.
            driver.quit();
            driver  = null;                  //->Driver'i kapattiktan sonra bosalt.
        }
    }

}
