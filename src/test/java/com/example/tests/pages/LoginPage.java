package com.example.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Representa la página de inicio de sesión de SauceDemo.
 * Implementa el patrón Page Object Model (POM) para separar la lógica de UI de las pruebas.
 */
public class LoginPage {

    private final WebDriver driver;

    // Selectores de los elementos de la página
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    /**
     * Constructor que inicializa el WebDriver.
     *
     * @param driver instancia de WebDriver que controla el navegador.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre la página principal de SauceDemo.
     */
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    /**
     * Realiza el inicio de sesión con las credenciales proporcionadas.
     *
     * @param username nombre de usuario
     * @param password contraseña
     */
    public void login(String username, String password) {
        WebElement user = driver.findElement(usernameField);
        WebElement pass = driver.findElement(passwordField);
        WebElement button = driver.findElement(loginButton);

        user.clear();
        user.sendKeys(username);
        pass.sendKeys(password);
        button.click();
    }
}
