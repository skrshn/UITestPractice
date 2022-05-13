package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import steps.PageInitializers;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializers {
    public static WebDriver driver;
    public static Actions action;
    public static Alert alert;
    public static JavascriptExecutor js;

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addExtensions(new File("/Users/sakirsahin/Downloads/extension_4_46_0_0.crx"));
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(capabilities);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        closeAdBlockerTab();
        initializePageObjects();
    }

    public static void closeAdBlockerTab() {
        Set<String> allWindowHandles = driver.getWindowHandles(); // store all the handles in a set
        Iterator<String> it = allWindowHandles.iterator(); // have an iterator in order to
        String mainPageHandle = it.next(); // take the first step and assign the main handle
        String childHandle = it.next(); // take the second step and have a child handle
        driver.switchTo().window(childHandle).close();
        driver.switchTo().window(mainPageHandle);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click;", element);
    }

    public static void alertAccept() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchToFrame(String id) {
        try {
            driver.switchTo().frame(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dragAndDrop() {
        action = new Actions(driver);
        action.clickAndHold(ControlsPage.draggable).moveToElement(ControlsPage.droppable).release().build().perform();
    }

    public static void doubleClick() {
        action.doubleClick(ControlsPage.doubleClickButton).perform();
    }

    public static void navBarTabs(String navBarMenuElement) {
        driver.switchTo().defaultContent();
        for (WebElement nextNavTab : HomePage.navBar) {
            if (nextNavTab.getText().equals(navBarMenuElement)) {
                nextNavTab.click();
                break;
            }
        }
    }

    //delete one user from table with pagination
    public static void deleteUserFromTable(String targetName) {

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        boolean flag = true;
        while (flag) {

            for (WebElement row : HomePage.getRows) {
                String rowText = row.getText();
                if (rowText.contains(targetName)) {
                    flag = false;
                    WebElement customEditButton = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[contains(text(),'" + targetName + "')]/following-sibling::td[3]/button[text()='EDIT']"));
                    customEditButton.click();

                    String studentEditURL = driver.getCurrentUrl();
                    String studentID = studentEditURL.substring(studentEditURL.length() - 4);

                    driver.navigate().back();

                    WebElement customDeleteButton = driver.findElement(By.xpath("//button[@onclick=\"location.href='/Students/DELETE/" + studentID + "';return false;\"]"));
                    customDeleteButton.click();

                    HomePage.deleteButtonConfirmation.click();
                    break;
                }
            }
            if (flag) {
                HomePage.nextButton.click();
            }
        }
    }

    public static void takeScreenShot(String path) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verifyAjaxButtonText() {
        if (AjaxCallPage.ajaxButtonText.isDisplayed()) {
            System.out.println("Text is displayed");
        } else {
            System.out.println("Text is not displayed");
        }
    }

    public static void verifyUploadText() {
        if (WidgetsPage.uploadVerify.getText().contains("File Successfully Uploaded")) {
            System.out.println("The file is uploaded");
        } else {
            System.out.println("The file is not uploaded");
        }
    }

    public static void selectMaritalStatusRadioButtons(String maritalStatus) {
        for (int i = 0; i < FormPage.maritalStatusRadioButtons.size(); i++) {
            if (FormPage.maritalStatusRadioButtonsLabels.get(i).getText().contains(maritalStatus)) {
                FormPage.maritalStatusRadioButtons.get(i).click();
                break;
            }
        }
    }

    public static void selectCountriesDD(String selectCountry) {
        Select selectCountriesDD = new Select(FormPage.countriesDD);
        boolean isMultiple = selectCountriesDD.isMultiple();

        if (!isMultiple) {
            List<WebElement> countryOptions = selectCountriesDD.getOptions();
            Iterator<WebElement> countryIterator = countryOptions.iterator();
            while (countryIterator.hasNext()) {
                WebElement next = countryIterator.next();
                String nextText = next.getText();
                if (nextText.contains(selectCountry)) {
                    next.click();
                    break;
                }

            }
        }
    }

    public static void selectCountriesSingleDD(String selectCountry) {
        Select countriesSingleDD = new Select(SelectPage.countriesSingle);
        boolean isMultiple = countriesSingleDD.isMultiple();

        if (!isMultiple) {
            List<WebElement> countrySingleOptions = countriesSingleDD.getOptions();
            Iterator<WebElement> countrySingleIterator = countrySingleOptions.iterator();
            while (countrySingleIterator.hasNext()) {
                WebElement next = countrySingleIterator.next();
                String nextText = next.getText();
                if (nextText.contains(selectCountry)) {
                    next.click();
                    break;
                }
            }
        }
    }

    public static void selectCountriesMultipleDD(String selectCountry1, String selectCountry2) {
        Select countriesMultipleDD = new Select(SelectPage.countriesMultiple);

        List<WebElement> countryMultipleOptions = countriesMultipleDD.getOptions();
        Iterator<WebElement> countryMultipleIterator = countryMultipleOptions.iterator();
        while (countryMultipleIterator.hasNext()) {
            WebElement next = countryMultipleIterator.next();
            String nextText = next.getText();
            if (nextText.contains(selectCountry1) || nextText.contains(selectCountry2)) {
                next.click();
            }
        }
    }

    public static void countryDDSelect(String selectCountry1) {
        Iterator<WebElement> countryDropdownIterator = SelectPage.countryDropDownOptions.iterator();
        while (countryDropdownIterator.hasNext()) {
            WebElement next = countryDropdownIterator.next();
            String nextText = next.getText();
            if (nextText.contains(selectCountry1)) {
                next.click();
                break;
            }
        }
    }

    public static void calendarFieldSelect(int month, int day, int year) {

        String monthString;
        switch (month) {
            case 1:
                monthString = "Jan";
                break;
            case 2:
                monthString = "Feb";
                break;
            case 3:
                monthString = "Mar";
                break;
            case 4:
                monthString = "Apr";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "Jun";
                break;
            case 7:
                monthString = "Jul";
                break;
            case 8:
                monthString = "Aug";
                break;
            case 9:
                monthString = "Sep";
                break;
            case 10:
                monthString = "Oct";
                break;
            case 11:
                monthString = "Nov";
                break;
            case 12:
                monthString = "Dec";
                break;
            default:
                monthString = "Invalid month";
                break;
        }

        new Select(FormPage.monthDD).selectByVisibleText(monthString);
        new Select(FormPage.yearDD).selectByVisibleText(String.valueOf(year));

        for (WebElement days : FormPage.daysDD
        ) {
            String dateText = days.getText();
            if (dateText.equals(String.valueOf(day))) {
                days.click();
                break;
            }
        }
    }

    public static void selectHobbyCheckboxes(String hobby1, String hobby2) {
        for (int i = 0; i < FormPage.hobbyCheckboxes.size(); i++) {
            String hobbyCheckboxesLabelText = FormPage.hobbyCheckboxesLabels.get(i).getText();
            if (hobbyCheckboxesLabelText.contains(hobby1) || hobbyCheckboxesLabelText.contains(hobby2)) {
                FormPage.hobbyCheckboxes.get(i).click();
            }
        }
    }

    public static void selectAndClickANumberOnTable(int number) {
        for (WebElement numberTable : ActionsPage.numbersTable
        ) {
            String text = numberTable.getText();
            if (text.equals(String.valueOf(number))) {
                numberTable.click();
                break;
            }
        }
    }

    public static void switchToWindow(String pageHandle) {
        try {
            driver.switchTo().window(pageHandle);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
