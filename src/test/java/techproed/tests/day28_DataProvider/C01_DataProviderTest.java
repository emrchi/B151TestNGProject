package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {

        /*
    DataProvider, bircok veriyi testcaselerde loop kullanmadan aktarmak icin kullanilir.
    TestNG'den gelen bir özelliktir. 2 boyutlu Object Array return eder. Kullanimi icin @Test notasyonundan sonra#
    parametre olarak (DataProvider = "method ismi") yazilir.Kac tane veri ile caalisacaksak test methoduna
    o kadar parametre eklenir.
    Data drive testing de datalarimizi uc fakli sekilde kullanabiliriz.
        1-.properties dosyasindan datalari alabiliriz.--> ConfigReader.getProperty()
        2-excel dosyasindan datalari alabiliriz --> ExcelReader class'i ile
        3-dataProvider kullanarak datalari alabiliriz. --> DataProvider methodu ile.
     */
    @DataProvider(name = "test02")       //--> Bu dataProvider'i test02 icin kullan anlamina gelir. artik test01 icin kullanilamaz.
    public static Object[][] isimler() {
        return new Object[][]{
                {"esen"},
                {"mehmet"},
                {"ali"},
                {"mert"},
                {"burcu"},
                {"emre"},
                {"yunus"}};
    }
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{
                {"honda"},
                {"mercedes"},
                {"volvo"},
                {"fiat"},
                {"bmw"},
                {"cherry"},
                {"ford"}};
    }

    /*
    Olusturdugumuz dataprovider metodunu baska bir test methodunda da kullanabiliriz
    Bunun icin @DataProvider notasyonuna (name = "test02") parametresini eklemeliyiz.
     */
    @Test(dataProvider = "isimler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "test02")
    public void test02(String isim) {
        System.out.println(isim);
    }

    @Test(dataProvider = "arabalar")
    public void test03(String arabalar) {
        System.out.println(arabalar);

    }
}
