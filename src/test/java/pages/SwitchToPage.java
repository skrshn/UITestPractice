package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class SwitchToPage extends CommonMethods {
    @FindBy(css = "button#alert")
    public static WebElement alertButton;

    @FindBy(css = "button#confirm")
    public static WebElement confirmButton;

    @FindBy(css = "button#prompt")
    public static WebElement promptButton;

    @FindBy(css = "button[data-target='#myModal']")
    public static WebElement modalButton;

    @FindBy(css = "button[class='btn btn-primary']")
    public static WebElement clickOkModal;

    @FindBy(css = "input#name")
    public static WebElement frameFill;

    public SwitchToPage() {
        PageFactory.initElements(driver,this);
    }

}
