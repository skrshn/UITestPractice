package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class ActionsPage extends CommonMethods {

    @FindBy(xpath = "//button[@name='click']")
    public static WebElement singleClick;

    @FindBy(xpath = "//button[@name='dblClick']")
    public WebElement doubleClick;

    @FindBy(id = "div2")
    public static WebElement hoverColor;

    @FindBy(xpath = "//ol[@id='selectable']/li")
    public static List<WebElement> numbersTable;

    public ActionsPage() {
        PageFactory.initElements(driver,this);
    }

}
