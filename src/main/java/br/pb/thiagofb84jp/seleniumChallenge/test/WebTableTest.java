package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.core.DriverManager;
import br.pb.thiagofb84jp.seleniumChallenge.core.Constants;
import br.pb.thiagofb84jp.seleniumChallenge.page.WebTablePage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebTableTest {
    WebDriver driver = DriverManager.getDriver("chrome");
    WebTablePage webTablePage = new WebTablePage(driver);

    public WebTableTest() {
        driver.get(Constants.DEMOQA_WEB_TABLES);
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
        DriverManager.quitDriver();
    }
}
