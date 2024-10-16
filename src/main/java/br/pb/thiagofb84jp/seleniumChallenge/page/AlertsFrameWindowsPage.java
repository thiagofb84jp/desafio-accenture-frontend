package br.pb.thiagofb84jp.seleniumChallenge.page;

import org.openqa.selenium.*;

public class AlertsFrameWindowsPage {

    WebDriver driver;

    By submitButton = By.id("submit");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By gender = By.xpath("//input[@name='gender' and @value='%s']");
    By mobilePhone = By.id("userNumber");
    By subjects = By.id("subjectsInput");
    By hobby = By.xpath("//label[text()='Sports']/preceding-sibling::input[@type='checkbox']");
    By currentAddress = By.id("currentAddress");
    By state = By.xpath("//input[@id='react-select-3-input']");
    By reactComponent = By.xpath("//div[contains(@id,'react-select')]");

    public AlertsFrameWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstName(String strFirstName) {
        driver.findElement(firstName).sendKeys(strFirstName);
    }

    public void fillLastName(String strLastName) {
        driver.findElement(lastName).sendKeys(strLastName);
    }

    public void fillEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    public void selectMaleGender() {
        WebElement labelMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        labelMale.click();
    }

    public void fillMobilePhone(String strMobilePhone) {
        driver.findElement(mobilePhone).sendKeys(strMobilePhone);
    }

    public void fillDateOfBirth() {

    }

    public void fillSubjects(String strSubjects) {
        driver.findElement(subjects).sendKeys(strSubjects);
        driver.findElement(subjects).sendKeys(Keys.ENTER);
    }

    public void fillHobbies (String strHobby){
        driver.findElement(hobby).click();
    }

    public void sendPicture() {

    }

    public void fillCurrentAddress(String strCurrentAddress) {
        driver.findElement(currentAddress).sendKeys(strCurrentAddress);
    }

    public void fillState (String strState) {
        driver.findElement(state).sendKeys("NCR");
        driver.findElement(reactComponent).click();
    }

    public void fillCity() {

    }

    public void clickSubmitButton() {
        WebElement button = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }
}