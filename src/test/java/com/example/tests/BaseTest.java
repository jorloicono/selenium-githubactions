package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.example.tests.utils.ScreenshotUtil;

import java.time.Duration;

/**
 * Clase base para las pruebas automatizadas.
 * Configura el WebDriver antes de cada prueba y gestiona la limpieza al finalizar.
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Descarga e instala automáticamente el driver de Chrome
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Modo headless (útil para CI/CD)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        // Captura una captura de pantalla si es necesario
        ScreenshotUtil.takeScreenshot(driver, testInfo.getDisplayName());

        if (driver != null) {
            driver.quit();
        }
    }
}
