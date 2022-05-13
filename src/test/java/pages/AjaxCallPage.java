package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AjaxCallPage extends CommonMethods {
    @FindBy(partialLinkText = "Ajax link")
    public static WebElement ajaxButton;

    @FindBy(xpath = "//p[contains(text(),'Selenium is a portable')]")
    public static WebElement ajaxButtonText;

    public AjaxCallPage() {
        PageFactory.initElements(driver,this);
    }

}
