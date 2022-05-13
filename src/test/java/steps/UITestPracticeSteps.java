package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

public class UITestPracticeSteps extends CommonMethods {
    @Given("user is navigated to uitestpractice website")
    public void userIsNavigatedToUitestpracticeWebsite() {
        openBrowserAndLaunchApplication();
    }

    @When("user clicks on Controls page")
    public void userClicksOnControlsPage() {
        navBarTabs("Controls");
    }

    @And("user drags and drops the target")
    public void userDragsAndDropsTheTarget() {
        dragAndDrop();
    }

    @When("user double clicks on Double Click Me button")
    public void userDoubleClicksOnDoubleClickMeButton() {
        doubleClick();
    }

    @And("user accepts the pop up alert")
    public void userAcceptsThePopUpAlert() {
        alertAccept();
    }

    @When("user switches to iframe")
    public void userSwitchesToIframe() {
        switchToFrame(0);
    }

    @And("user enters name in the empty field")
    public void userEntersNameInTheEmptyField() {
        sendText(ControlsPage.inputField, ConfigReader.getPropertyValue("name"));
    }

    @Then("user successfully completed the Controls page actions")
    public void userSuccessfullyCompletedTheControlsPageActions() {
        System.out.println("Controls page actions has been successfully completed");
    }

    @Given("user is clicked on the Home page")
    public void userIsClickedOnTheHomePage() {
        navBarTabs("Home");
    }

    @When("user finds student name Igor")
    public void userFindsStudentNameIgor() {
        deleteUserFromTable("Igor");
    }

    @And("user clicks the delete button")
    public void userClicksTheDeleteButton() {
    }

    @Then("user is able to delete the student")
    public void userIsAbleToDeleteTheStudent() {
        System.out.println("Student name of Igor has been successfully deleted");
    }

    @Given("user is clicked on the AjaxCall page")
    public void userIsClickedOnTheAjaxCallPage() {
        navBarTabs("AjaxCall");
    }

    @When("user clicks on the This is a Ajax link link")
    public void userClicksOnTheThisIsAAjaxLinkLink() {
        click(AjaxCallPage.ajaxButton);
    }

    @Then("user is able to see the text")
    public void userIsAbleToSeeTheText() {
        verifyAjaxButtonText();
    }

    @Given("user is clicked on the Form page")
    public void userIsClickedOnTheFormPage() {
        navBarTabs("Form");
    }

    @When("user fills out the form")
    public void userFillsOutTheForm() {
        FormPage.firstName.sendKeys("John");
        FormPage.lastName.sendKeys("Doe");

        CommonMethods.selectMaritalStatusRadioButtons("Single");
        CommonMethods.selectHobbyCheckboxes("Reading", "Cricket");

        CommonMethods.selectCountriesDD("Denmark");

        FormPage.calendarField.click();

        CommonMethods.calendarFieldSelect(10, 29, 1990);

        FormPage.phoneNumber.sendKeys("+12134567889");
        FormPage.username.sendKeys("johndoe");
        FormPage.email.sendKeys("johndoe@gmail.com");
        FormPage.comment.sendKeys("Everything is going to be alright");
        FormPage.password.sendKeys("johndoe123");
    }

    @And("user clicks the submit button")
    public void userClicksTheSubmitButton() {
        FormPage.submitButton.click();
    }

    @Then("user is able to finish the application form")
    public void userIsAbleToFinishTheApplicationForm() {
        System.out.println("Form Page has been successfully submitted");
    }

    @Given("user is clicked on the Widgets page")
    public void userIsClickedOnTheWidgetsPage() {
        navBarTabs("Widgets");
    }

    @When("user chooses a file to upload")
    public void userChoosesAFileToUpload() {
        WidgetsPage.chooseFile.sendKeys(Constants.UPLOAD_FILEPATH);
    }

    @And("user clicks the upload button")
    public void userClicksTheUploadButton() {
        WidgetsPage.uploadButton.click();
    }

    @Then("user is able to upload the file successfully")
    public void userIsAbleToUploadTheFileSuccessfully() {
        verifyUploadText();
    }

    @Given("user is clicked on the Actions page")
    public void userIsClickedOnTheActionsPage() {
        navBarTabs("Actions");
    }

    @When("user clicks on Click Me button")
    public void userClicksOnClickMeButton() {
        ActionsPage.singleClick.click();
    }

    @And("user hovers the mouse on the blue square to turn it to green")
    public void userHoversTheMouseOnTheBlueSquareToTurnItToGreen() {
        new Actions(driver).moveToElement(ActionsPage.hoverColor).perform();
    }

    @When("user selects a number on table")
    public void userSelectsANumberOnTable() {
        selectAndClickANumberOnTable(Constants.NUMBER_CLICK_ON_TABLE);
    }

    @Then("user successfully completed the Actions page actions")
    public void userSuccessfullyCompletedTheActionsPageActions() {
        System.out.println("Actions page actions has been successfully completed");
    }

    @Given("user is clicked on the SwitchTo page")
    public void userIsClickedOnTheSwitchToPage() {
        navBarTabs("Switch to");
    }

    @When("user click on Alert button")
    public void userClickOnAlertButton() {
        SwitchToPage.alertButton.click();
    }

    @When("user click on Confirm button")
    public void userClickOnConfirmButton() {
        SwitchToPage.confirmButton.click();
    }

    @When("user clicks on Prompt button")
    public void userClicksOnPromptButton() {
        SwitchToPage.promptButton.click();
    }

    @And("user enters the name in the empty field on alert")
    public void userEntersTheNameInTheEmptyFieldOnAlert() {
        driver.switchTo().alert().sendKeys("John");
    }

    @When("user clicks on Launch Modal button")
    public void userClicksOnLaunchModalButton() {
        SwitchToPage.modalButton.click();
    }

    @And("user accepts the Launch Modal alert")
    public void userAcceptsTheLaunchModalAlert() {
        SwitchToPage.clickOkModal.click();
    }

    @And("user enters the name in the empty field")
    public void userEntersTheNameInTheEmptyField() {
        SwitchToPage.frameFill.sendKeys("John Doe");
        driver.switchTo().defaultContent();
    }

    @Then("user successfully completed the SwitchTo page actions")
    public void userSuccessfullyCompletedTheSwitchToPageActions() {
        System.out.println("Switch to page actions has been successfully completed");
    }

    @Given("user is clicked on the Select page")
    public void userIsClickedOnTheSelectPage() {
        navBarTabs("Select");
    }

    @When("user selects a country from drop down menu")
    public void userSelectsACountryFromDropDownMenu() {
        selectCountriesSingleDD("China");
    }

    @When("user multiple selects countries from multiple select menu")
    public void userMultipleSelectsCountriesFromMultipleSelectMenu() {
        selectCountriesMultipleDD("England", "China");
    }

    @When("user selects a country from web drop down menu")
    public void userSelectsACountryFromWebDropDownMenu() {
        SelectPage.countryDropDownButton.click();
        countryDDSelect("England");
    }

    @Then("user successfully completed the Select page actions")
    public void userSuccessfullyCompletedTheSelectPageActions() {
        System.out.println("Select page actions has been successfully completed");
        tearDown();
    }
}
