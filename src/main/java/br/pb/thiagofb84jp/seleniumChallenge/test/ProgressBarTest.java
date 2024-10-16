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
        driver.findElement(By.id("startStopButton")).click();

        // Localiza a barra de progresso
        WebElement progressBar = driver.findElement(By.id("progressBar"));

        // Variável para armazenar o valor da barra de progresso
        int progressValue = 0;

        // Loop para monitorar a barra de progresso até atingir 25%
        while (progressValue < 25) {
            // Captura o valor atual da barra de progresso
            WebElement progressBarValue = progressBar.findElement(By.className("progress-bar"));
            String progressValueStr = progressBarValue.getAttribute("aria-valuenow");

            // Converte o valor atual para inteiro
            progressValue = Integer.parseInt(progressValueStr);

            // Pequena pausa para evitar loops muito rápidos
            try {
                Thread.sleep(100);  // Espera 100 milissegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Valida se a barra de progresso é menor ou igual a 25%
        Assert.assertTrue("A barra de progresso deve estar em 25% ou menos", progressValue <= 25);

        // Quando a barra atingir 25%, clica no botão "Stop"
        WebElement stopButton = driver.findElement(By.id("startStopButton"));
        stopButton.click();

        // Aguarda 5 segundos
        try {
            Thread.sleep(5000);  // Pausa de 5 segundos antes de iniciar novamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Agora, clica no botão "Start" novamente para retomar
        stopButton.click();

        // Loop para monitorar a barra de progresso até atingir 100%
        while (progressValue < 100) {
            WebElement progressBarValue = progressBar.findElement(By.className("progress-bar"));
            String progressValueStr = progressBarValue.getAttribute("aria-valuenow");
            progressValue = Integer.parseInt(progressValueStr);

            // Pequena pausa para evitar loops muito rápidos
            try {
                Thread.sleep(100);  // Espera 100 milissegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Quando a barra atingir 100%, clica no botão "Reset"
        WebElement resetButton = driver.findElement(By.id("resetButton"));
        resetButton.click();

        // Fecha o navegador
//        driver.quit();
    }

    @After
    public void closePage() {
//        driver.quit();
    }
}
