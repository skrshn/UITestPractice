package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class FormPage extends CommonMethods {
    @FindBy(css = "input#firstname")
    public static WebElement firstName;

    @FindBy(css = "input#lastname")
    public static WebElement lastName;

    @FindBy(xpath = "//input[@name='optradio']/parent::label")
    public static List<WebElement> maritalStatusRadioButtonsLabels;

    @FindBy(xpath = "//input[@name='optradio']")
    public static List<WebElement> maritalStatusRadioButtons;

    @FindBy(xpath = "//input[@type='checkbox']/parent::label")
    public static List<WebElement> hobbyCheckboxesLabels;

    @FindBy(xpath = "//input[@type='checkbox']")
    public static List<WebElement> hobbyCheckboxes;

    @FindBy(id = "sel1")
    public static WebElement countriesDD;

    @FindBy(xpath = "//input[@id='datepicker']")
    public static WebElement calendarField;

    @FindBy(className = "ui-datepicker-month")
    public static WebElement monthDD;

    @FindBy(className = "ui-datepicker-year")
    public static WebElement yearDD;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public static List<WebElement> daysDD;

    @FindBy(css = "input#phonenumber")
    public static WebElement phoneNumber;

    @FindBy(css = "input#username")
    public static WebElement username;

    @FindBy(css = "input#email")
    public static WebElement email;

    @FindBy(css = "textarea#comment")
    public static WebElement comment;

    @FindBy(css = "input#pwd")
    public static WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement submitButton;

    public FormPage() {
        PageFactory.initElements(driver,this);
    }

}
