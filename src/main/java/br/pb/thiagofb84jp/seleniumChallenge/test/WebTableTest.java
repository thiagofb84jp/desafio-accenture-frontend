package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.page.AlertsFrameWindowsPage;
import br.pb.thiagofb84jp.seleniumChallenge.page.WebTablePage;
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

    WebTablePage webTablePage = new WebTablePage(driver);

    public WebTableTest() {
        driver.manage().window().maximize();
        driver.get(DEMOQA_WEB_TABLES);
    }

    @Test
    public void cadastrarEditarExcluirFuncionarioModal() throws InterruptedException {
        // Inclusão dos dados
        webTablePage.clickAddNewRecordButton();
        webTablePage.switchWindow();
        webTablePage.fillFirstName("John");
        webTablePage.fillLastName("Doe");
        webTablePage.fillEmail("john.doe@example.com");
        webTablePage.fillAge("30");
        webTablePage.fillSalary("50000");
        webTablePage.fillDepartment("Engineering");
        webTablePage.clickSubmitButton();

        // Edição dos dados
        webTablePage.clickEditButton();
        webTablePage.switchWindow();
        webTablePage.fillFirstName("Mary");
        webTablePage.fillLastName("Smith");
        webTablePage.fillEmail("mary.smith@example.com");
        webTablePage.fillAge("40");
        webTablePage.fillSalary("70000");
        webTablePage.fillDepartment("Beauty and Make Up");
        webTablePage.clickSubmitButton();

        // Exclusão dos dados
        webTablePage.deleteRecord();
    }

    @After
    public void closePage() {
        driver.quit();
    }
}
