package br.pb.thiagofb84jp.seleniumChallenge.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage {
    WebDriver driver;

    By modalContentClass = By.className("modal-content");
    By addNewRecordButton = By.id("addNewRecordButton");
    By firstNameSelector = By.id("firstName");
    By lastNameSelector = By.id("lastName");
    By emailSelector = By.id("userEmail");
    By ageSelector = By.id("age");
    By salarySelector = By.id("salary");
    By departmentSelector = By.id("department");
    By submitButtonSelector = By.id("submit");
    By editButton = By.id("edit-record-4");
    By deleteButton = By.id("delete-record-4");

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getModal() {
        return driver.findElement(modalContentClass);
    }

    public void clickAddNewRecordButton() {
        driver.findElement(addNewRecordButton).click();
    }

    public void switchWindow() {
        WebElement modal = getModal();
    }

    public void fillFirstName(String strFirstName) {
        WebElement firstName = getModal().findElement(firstNameSelector);
        firstName.clear();
        firstName.sendKeys(strFirstName);
    }

    public void fillLastName(String strLastName) {
        WebElement lastName = getModal().findElement(lastNameSelector);
        lastName.clear();
        lastName.sendKeys(strLastName);
    }

    public void fillEmail(String strEmail) {
        WebElement email = getModal().findElement(emailSelector);
        email.clear();
        email.sendKeys(strEmail);
    }

    public void fillAge(String strAge) {
        WebElement age = getModal().findElement(ageSelector);
        age.clear();
        age.sendKeys(strAge);
    }

    public void fillSalary(String strSalary) {
        WebElement salary = getModal().findElement(salarySelector);
        salary.clear();
        salary.sendKeys(strSalary);
    }

    public void fillDepartment(String strDepartment) {
        WebElement department = getModal().findElement(departmentSelector);
        department.clear();
        department.sendKeys(strDepartment);
    }

    public void clickSubmitButton() {
        WebElement submitButton = getModal().findElement(submitButtonSelector);
        submitButton.click();
    }

    public void clickEditButton() {
        driver.findElement(editButton).click();
    }

    public void deleteRecord() {
        driver.findElement(deleteButton).click();
    }
}