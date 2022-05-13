package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ControlsPage extends CommonMethods {
    @FindBy(id = "draggable")
    public static WebElement draggable;

    @FindBy(id = "droppable")
    public static WebElement droppable;

    @FindBy(id = "name")
    public static WebElement inputField;

    @FindBy(xpath = "//button[@name='dblClick']")
    public static WebElement doubleClickButton;

    public ControlsPage() {
        PageFactory.initElements(driver,this);
    }
}
