package br.pb.thiagofb84jp.seleniumChallenge.test;

import br.pb.thiagofb84jp.seleniumChallenge.core.Constants;
import br.pb.thiagofb84jp.seleniumChallenge.core.DriverManager;
import br.pb.thiagofb84jp.seleniumChallenge.page.AlertsFrameWindowsPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AlertsFrameWindowsTest {
    WebDriver driver = DriverManager.getDriver("chrome");
    AlertsFrameWindowsPage windowsPage = new AlertsFrameWindowsPage(driver);

    public AlertsFrameWindowsTest() {
        driver.get(Constants.DEMOQA_BROWSER_WINDOWS);
    }

    @Test
    public void openNewWindow() {
        windowsPage.clickNewWindow();
        windowsPage.handleWindow();
        windowsPage.verifyPopUpMessage("This is a sample page");
        windowsPage.closePopUp();
    }

    @After
    public void closePage() {
        DriverManager.quitDriver();
    }
}
