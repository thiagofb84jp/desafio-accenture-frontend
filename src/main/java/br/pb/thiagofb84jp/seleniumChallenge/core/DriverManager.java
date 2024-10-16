package br.pb.thiagofb84jp.seleniumChallenge.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver"); // Sem extensão para Linux
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver"); // Sem extensão para Linux
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("O navegador " + browser + " não é suportado.");
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
