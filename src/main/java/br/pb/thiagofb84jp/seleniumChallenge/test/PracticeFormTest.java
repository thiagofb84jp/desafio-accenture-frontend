package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.page.PracticeFormPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PracticeFormTest {

    private static final String DEMOQA_PRACTICE_FORM_LINK = "https://demoqa.com/automation-practice-form";

    WebDriver driver = new ChromeDriver();

    PracticeFormPage searchPage = new PracticeFormPage(driver);

    public PracticeFormTest() {
        driver.manage().window().maximize();
        driver.get(DEMOQA_PRACTICE_FORM_LINK);
    }

    @Test
    public void cadastrarEstudanteComSucesso() throws InterruptedException {
        searchPage.fillFirstName("Marcos");
        searchPage.fillLastName("dos Santos da Silva Costa");
        searchPage.fillEmail("marcos_santos_silva@gmail.com");
        searchPage.selectMaleGender();
        searchPage.fillMobilePhone("83992516234");
        searchPage.fillDateOfBirth(LocalDate.of(1990, 10, 16));
        searchPage.fillSubjects("Maths");
        searchPage.fillHobbiesSports();
        searchPage.sendFile();
        searchPage.fillCurrentAddress("Rua dos Sonhos Perdidos, no. 25");
        searchPage.fillState("NCR");
        searchPage.fillCity("Noida");
        searchPage.clickSubmitButton();
        searchPage.isPopUpOpened();
        searchPage.closePopUp();
    }

    @After
    public void closePage() {
        driver.quit();
    }

}
