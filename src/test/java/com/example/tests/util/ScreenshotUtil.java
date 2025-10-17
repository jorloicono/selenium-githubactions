package com.example.tests.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilidad para capturar capturas de pantalla durante la ejecución de pruebas.
 * Guarda las imágenes en el directorio: target/screenshots/
 */
public class ScreenshotUtil {

    /**
     * Captura una captura de pantalla y la guarda con el nombre del test y una marca de tiempo.
     *
     * @param driver   instancia actual de WebDriver
     * @param testName nombre del test (usualmente proveniente de TestInfo)
     */
    public static void takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) return;

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            Path destDir = Path.of("target", "screenshots");
            Files.createDirectories(destDir);

            Path destination = destDir.resolve(testName + "_" + timestamp + ".png");
            Files.copy(screenshot.toPath(), destination);

            System.out.println("[ScreenshotUtil] Captura guardada en: " + destination);

        } catch (Exception e) {
            System.err.println("[ScreenshotUtil] No se pudo guardar la captura de pantalla: " + e.getMessage());
        }
    }
}
