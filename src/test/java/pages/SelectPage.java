package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class SelectPage extends CommonMethods {

    @FindBy(css = "select#countriesSingle")
    public static WebElement countriesSingle;

    @FindBy(css = "select#countriesMultiple")
    public static WebElement countriesMultiple;

    @FindBy(css = "button#dropdownMenu1")
    public static WebElement countryDropDownButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/a")
    public static List<WebElement> countryDropDownOptions;

    public SelectPage() {
        PageFactory.initElements(driver,this);
    }

}
