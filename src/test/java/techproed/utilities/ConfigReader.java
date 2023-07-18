package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
        /*
            .properties uzantili dosyaya erisebilmek icin Properties class'indan obje olusturmamiz gerekir.
            Bu olusturdugumuz obje ile akisa aldigimiz dosya yolunu properties.load(fis) methodu ile properties
            dosyasindaki bilgileri objenize yukler ve properties dosyasindaki getProperty() methodu ile aldigimiz
            key degerini(value)  return ederiz.
            Bunu yapmak icin parametreli bir method olusturur girdigimiz key'in degerini bize dondururuz.
         */
    static Properties properties;
        /*
        Bellek de cok fazla yer kaplamasin diye methodun icindeki try catch li code blogumuzu class seviyede static blok icine aldik.
        Methodumuzu cagirdigimiz da her zaman static blok ilk calisacagi icin method badimiz bos kalsada olur.
         */
    static {
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);                                   //--. fis'in okudugu bigileri properties'e yukler.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) {

        String value = properties.getProperty(key);                 //--> String olarak girdigim key'in degerini return eder
        return value;
    }

}
