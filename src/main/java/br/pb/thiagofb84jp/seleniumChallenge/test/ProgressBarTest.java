package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.page.AlertsFrameWindowsPage;
import br.pb.thiagofb84jp.seleniumChallenge.page.ProgressBarPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgressBarTest {

    private static final String DEMOQA_PROGRESS_BAR = "https://demoqa.com/progress-bar";

    WebDriver driver = new ChromeDriver();
    ProgressBarPage progressBarPage = new ProgressBarPage(driver);

    public ProgressBarTest() {
        driver.manage().window().maximize();
        driver.get(DEMOQA_PROGRESS_BAR);
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
        driver.quit();
    }
}
