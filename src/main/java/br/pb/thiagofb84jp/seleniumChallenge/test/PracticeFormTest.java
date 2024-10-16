package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.core.Constants;
import br.pb.thiagofb84jp.seleniumChallenge.core.DriverManager;
import br.pb.thiagofb84jp.seleniumChallenge.page.PracticeFormPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class PracticeFormTest {
    WebDriver driver = DriverManager.getDriver("chrome");
    PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

    public PracticeFormTest() {
        driver.get(Constants.DEMOQA_PRACTICE_FORM_LINK);
    }

    @Test
    public void cadastrarEstudanteComSucesso() throws InterruptedException {
        practiceFormPage.fillFirstName("Marcos");
        practiceFormPage.fillLastName("dos Santos da Silva Costa");
        practiceFormPage.fillEmail("marcos_santos_silva@gmail.com");
        practiceFormPage.selectMaleGender();
        practiceFormPage.fillMobilePhone("83992516234");
        practiceFormPage.fillDateOfBirth(LocalDate.of(1990, 10, 16));
        practiceFormPage.fillSubjects("Maths");
        practiceFormPage.fillHobbiesSports();
        practiceFormPage.sendFile();
        practiceFormPage.fillCurrentAddress("Rua João Gilberto Lima da Costa e Silva, no. 25");
        practiceFormPage.fillState("NCR");
        practiceFormPage.fillCity("Noida");
        practiceFormPage.clickSubmitButton();
        practiceFormPage.isPopUpOpened();
        practiceFormPage.closePopUp();
    }

    @After
    public void closePage() {
        DriverManager.quitDriver();
    }
}