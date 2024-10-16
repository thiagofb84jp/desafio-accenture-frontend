package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.core.Constants;
import br.pb.thiagofb84jp.seleniumChallenge.core.DriverManager;
import br.pb.thiagofb84jp.seleniumChallenge.page.ProgressBarPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ProgressBarTest {
    WebDriver driver = DriverManager.getDriver("chrome");
    ProgressBarPage progressBarPage = new ProgressBarPage(driver);

    public ProgressBarTest() {
        driver.get(Constants.DEMOQA_PROGRESS_BAR);
    }

    @Test
    public void controlarProgressBar() {
        progressBarPage.clickStartStopButton();
        progressBarPage.startProgressBar();
        progressBarPage.validatePercentual("A barra de progresso deve estar em 25% ou menos.");
        progressBarPage.clickStopButton();
        progressBarPage.continueProgress();
        progressBarPage.clickResetButton();
    }

    @After
    public void closePage() {
        DriverManager.quitDriver();
    }
}
