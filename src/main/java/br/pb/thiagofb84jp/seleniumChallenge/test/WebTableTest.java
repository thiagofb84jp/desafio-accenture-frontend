package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.page.AlertsFrameWindowsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WebTableTest {

    private static final String DEMOQA_WEB_TABLES = "https://demoqa.com/webtables";

    WebDriver driver = new ChromeDriver();
    AlertsFrameWindowsPage windowsPage = new AlertsFrameWindowsPage(driver);

    public WebTableTest() {
        driver.manage().window().maximize();
        driver.get(DEMOQA_WEB_TABLES);
    }

    @Test
    public void abrirNewWindow() throws InterruptedException {
        driver.findElement(By.id("addNewRecordButton")).click();
        // Localiza a modal

        // switchModalContent()
        WebElement modal = driver.findElement(By.className("modal-content"));

        // Preencher o campo "First Name"
        // fillFirstName()
        WebElement firstName = modal.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        // Preencher o campo "Last Name"
        WebElement lastName = modal.findElement(By.id("lastName"));
        lastName.sendKeys("Doe");

        // Preencher o campo "Email"
        WebElement email = modal.findElement(By.id("userEmail"));
        email.sendKeys("john.doe@example.com");

        // Preencher o campo "Age"
        WebElement age = modal.findElement(By.id("age"));
        age.sendKeys("30");

        // Preencher o campo "Salary"
        WebElement salary = modal.findElement(By.id("salary"));
        salary.sendKeys("50000");

        // Preencher o campo "Department"
        WebElement department = modal.findElement(By.id("department"));
        department.sendKeys("Engineering");

        // Submeter o formulário clicando no botão "Submit"
        WebElement submitButton = modal.findElement(By.id("submit"));
        submitButton.click();

        // Edição dos dados
        driver.findElement(By.id("edit-record-4")).click();

        editarRegistro();

        Thread.sleep(5000);

        excluirRegistro();

        // Fechar o driver
//        driver.quit();
    }

    private void editarRegistro() {
        // Localiza a modal
        WebElement modal = driver.findElement(By.className("modal-content"));

        // Preencher o campo "First Name"
        WebElement firstName = modal.findElement(By.id("firstName"));
        firstName.clear();
        firstName.sendKeys("Mary");

        // Preencher o campo "Last Name"
        WebElement lastName = modal.findElement(By.id("lastName"));
        lastName.clear();
        lastName.sendKeys("Doe");

        // Preencher o campo "Email"
        WebElement email = modal.findElement(By.id("userEmail"));
        email.clear();
        email.sendKeys("mary.doe@example.com");

        // Preencher o campo "Age"
        WebElement age = modal.findElement(By.id("age"));
        age.clear();
        age.sendKeys("30");

        // Preencher o campo "Salary"
        WebElement salary = modal.findElement(By.id("salary"));
        salary.clear();
        salary.sendKeys("80000");

        // Preencher o campo "Department"
        WebElement department = modal.findElement(By.id("department"));
        department.clear();
        department.sendKeys("Beauty and Make Up");

        // Submeter o formulário clicando no botão "Submit"
        WebElement submitButton = modal.findElement(By.id("submit"));
        submitButton.click();
    }

    private void excluirRegistro() {
        driver.findElement(By.id("delete-record-4")).click();
    }

    @After
    public void closePage() {
//        driver.quit();
    }
}
