package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class WidgetsPage extends CommonMethods {

    @FindBy(id = "image_file")
    public static WebElement chooseFile;

    @FindBy(xpath = "//input[@value='Upload']")
    public static WebElement uploadButton;

    @FindBy(xpath = "//p[contains(text(),'File Successfully Uploaded')]")
    public static WebElement uploadVerify;

    public WidgetsPage() {
        PageFactory.initElements(driver,this);
    }

}
