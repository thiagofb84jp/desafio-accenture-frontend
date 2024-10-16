package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.page.AlertsFrameWindowsPage;
import br.pb.thiagofb84jp.seleniumChallenge.page.PracticeFormPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class AlertsFrameWindowsTest {

    private static final String DEMOQA_BROWSER_WINDOWS = "https://demoqa.com/browser-windows";

    WebDriver driver = new ChromeDriver();
    AlertsFrameWindowsPage windowsPage = new AlertsFrameWindowsPage(driver);

    public AlertsFrameWindowsTest() {
        driver.manage().window().maximize();
        driver.get(DEMOQA_BROWSER_WINDOWS);
    }

    @Test
    public void abrirNewWindow() {
        windowsPage.clickNewWindow();
        windowsPage.handleWindow();
        windowsPage.verifyPopUpMessage("This is a sample page");
        windowsPage.closePopUp();
    }

    @After
    public void closePage() {
        driver.quit();
    }
}
