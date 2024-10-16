package br.pb.thiagofb84jp.seleniumChallenge.page;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.Set;

public class AlertsFrameWindowsPage {
    WebDriver driver;

    By windowButton = By.id("windowButton");
    By sampleHeading = By.id("sampleHeading");

    public AlertsFrameWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewWindow() {
        driver.findElement(windowButton).click();
    }

    public void handleWindow() {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void verifyPopUpMessage(String strMessage) {
        WebElement heading = driver.findElement(sampleHeading);
        String actualMessage = heading.getText();
        Assert.assertEquals("A mensagem da pop-up não corresponde", strMessage, actualMessage);
    }

    public void closePopUp() {
        driver.close();
    }
}