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
        driver.findElement(By.id("windowButton")).click();

        String mainWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        // Percorre as janelas para encontrar a pop-up
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                // Muda o foco para a pop-up
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Valida a mensagem dentro da pop-up
        WebElement heading = driver.findElement(By.id("sampleHeading"));  // Localiza o elemento pelo ID
        // Captura o texto do elemento
        String actualMessage = heading.getText();
        String expectedMessage = "This is a sample page";

        // Valida se a mensagem está correta usando Assert
        Assert.assertEquals("A mensagem da pop-up não corresponde", expectedMessage, actualMessage);

        // Fecha a pop-up
        driver.close();

        // Volta para a janela principal
        driver.switchTo().window(mainWindow);
    }

    @After
    public void closePage() {
//        driver.quit();
    }

}
