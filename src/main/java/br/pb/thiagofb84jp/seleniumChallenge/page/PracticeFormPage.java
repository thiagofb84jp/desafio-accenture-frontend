package br.pb.thiagofb84jp.seleniumChallenge.page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PracticeFormPage {

    WebDriver driver;

    By submitButton = By.id("submit");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By maleGender = By.xpath("//label[@for='gender-radio-1']");
    By mobilePhone = By.id("userNumber");
    By dateOfBirth = By.id("dateOfBirthInput");
    By subjects = By.id("subjectsInput");
    By hobbySports = By.xpath("//label[@for='hobbies-checkbox-1']");
    By upload = By.id("uploadPicture");
    By currentAddress = By.id("currentAddress");
    By state = By.id("react-select-3-input");
    By city = By.id("react-select-4-input");
    By modalPopUp = By.id("example-modal-sizes-title-lg");
    By closeButton = By.id("closeLargeModal");
//    By reactComponent = By.xpath("//div[contains(@id,'react-select')]");

    public PracticeFormPage(WebDriver driver) {
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
        WebElement male = driver.findElement(maleGender);
        male.click();
    }

    public void fillMobilePhone(String strMobilePhone) {
        driver.findElement(mobilePhone).sendKeys(strMobilePhone);
    }

    public void fillDateOfBirth(LocalDate selectDate) throws InterruptedException {
        String dataFormatada = selectDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));

        WebElement dateInput = driver.findElement(dateOfBirth);
        dateInput.click();
        dateInput.clear();
        dateInput.sendKeys(dataFormatada);
        dateInput.sendKeys(Keys.RETURN);
    }

    public void fillSubjects(String strSubjects) {
        driver.findElement(subjects).sendKeys(strSubjects);
        driver.findElement(subjects).sendKeys(Keys.ENTER);
    }

    public void fillHobbiesSports() {
        WebElement sports = driver.findElement(hobbySports);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sports);
        sports.click();
    }

    public void sendFile() throws InterruptedException {
        WebElement uploadElement = driver.findElement(upload);

        String caminhoArquivo = Objects.requireNonNull(getClass().getClassLoader().getResource("upload.txt"),
                "Arquivo não encontrado").getPath();
        uploadElement.sendKeys(caminhoArquivo);
    }

    public void fillCurrentAddress(String strCurrentAddress) {
        driver.findElement(currentAddress).sendKeys(strCurrentAddress);
    }

    public void fillState(String strState) {
        WebElement selectState = driver.findElement(state);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectState);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectState));

        selectState.sendKeys(strState);
        selectState.sendKeys(Keys.ENTER);
    }

    public void fillCity(String strCity) {
        WebElement selectCity = driver.findElement(city);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectCity);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectCity));

        selectCity.sendKeys(strCity);
        selectCity.sendKeys(Keys.ENTER);
    }

    public void clickSubmitButton() {
        WebElement button = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

    public void isPopUpOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(modalPopUp));

        Assert.assertTrue("Thanks for submitting the form", modalTitle.isDisplayed());
    }

    public void closePopUp() {
        WebElement button = driver.findElement(closeButton);
        button.click();
    }
}