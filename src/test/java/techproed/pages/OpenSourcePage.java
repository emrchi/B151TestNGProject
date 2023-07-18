package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
        /*
        TestNG de locate'lerimizi pages package'ı altında oluşturduğumuz class'lar içinde alırız.
    Bu class içinde driver'imizi tanimlamak ve webelementleri oluşturabilmek için constructor oluşturup
    bu cons. içinde PageFactory class'ından initelements methodunu kullanarak driver'imizi bu class'a tanımlarız
        */

    public OpenSourcePage() {
        PageFactory.initElements(Driver.getDriver(),this);
        /*
             WebElemetleri locate edebilmek icin findElement() methodunu kullaniyorduk.
        @FindBy notasyonu ile artik findElemnt() methodu kullanmayip @findBy notasyonu icinde driver'in yerini
        tarif etmemiz gerekiyor.
            Yukaridaki   (Driver.getDriver(),this) komutu burada ihtiyac duydugum driver, Driver class'indaki
        getdriver() methodundaki driver demek oluyor.
        */
    }
    @FindBy(xpath ="//input[@name='username']")
    public WebElement username;

    @FindBy(xpath ="//input[@name='password']")
    public WebElement password;

    @FindBy(xpath ="//*[@type='submit']")
    public WebElement submitbutton;

    @FindBy(xpath ="//h6")
    public WebElement verify;
}