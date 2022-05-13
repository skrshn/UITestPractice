package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class HomePage extends CommonMethods {
    @FindBy(xpath = "//ul/li[@style='font-size:20px']/a")
    public static List<WebElement> navBar;

    @FindBy(xpath = "//table[@class='table']/tbody/tr")
    public static List<WebElement> getRows;

    @FindBy(xpath = "//input[@value='Delete']")
    public static WebElement deleteButtonConfirmation;

    @FindBy(xpath = "//a[@rel='next']")
    public static WebElement nextButton;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

}
