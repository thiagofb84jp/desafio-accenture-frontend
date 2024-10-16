package br.pb.thiagofb84jp.seleniumChallenge.page;

import org.junit.Assert;
import org.openqa.selenium.*;

public class ProgressBarPage {

    WebDriver driver;

    By startStopButton = By.id("startStopButton");
    By progressBarID = By.id("progressBar");
    By progressBarClassName = By.className("progress-bar");
    By resetButtonID = By.id("resetButton");

    int progressValue = 0;

    public ProgressBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStartStopButton() {
        driver.findElement(startStopButton).click();
    }

    public void startProgressBar() {
        WebElement progressBar = driver.findElement(progressBarID);

        while (progressValue < 25) {
            WebElement progressBarValue = progressBar.findElement(progressBarClassName);

            String progressValueStr = progressBarValue.getAttribute("aria-valuenow");
            progressValue = Integer.parseInt(progressValueStr);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void validatePercentual(String msgProgress) {
        Assert.assertTrue(msgProgress, progressValue <= 25);
    }

    public void clickStopButton() {
        WebElement stopButton = driver.findElement(startStopButton);
        stopButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopButton.click();
    }

    public void continueProgress() {
        WebElement progressBar = driver.findElement(progressBarID);

        while (progressValue < 100) {
            WebElement progressBarValue = progressBar.findElement(progressBarClassName);
            String progressValueStr = progressBarValue.getAttribute("aria-valuenow");
            progressValue = Integer.parseInt(progressValueStr);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickResetButton() {
        WebElement resetButton = driver.findElement(resetButtonID);
        resetButton.click();
    }
}