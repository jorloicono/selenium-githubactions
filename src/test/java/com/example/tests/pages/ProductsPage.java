package com.example.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Representa la página de productos de SauceDemo.
 * Implementa el patrón Page Object Model (POM) para encapsular las interacciones con la UI.
 */
public class ProductsPage {

    private final WebDriver driver;

    // Selectores
    private final By productTitles = By.className("inventory_item_name");
    private final By addToCartButton = By.xpath("(//button[contains(@id,'add-to-cart')])[1]");
    private final By cartBadge = By.className("shopping_cart_badge");

    /**
     * Constructor que inicializa el WebDriver.
     *
     * @param driver instancia de WebDriver utilizada para interactuar con la página.
     */
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Obtiene los títulos de todos los productos visibles en la página.
     *
     * @return lista de nombres de productos.
     */
    public List<String> getAllProductTitles() {
        return driver.findElements(productTitles)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    /**
     * Agrega el primer producto de la lista al carrito.
     */
    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    /**
     * Devuelve el número de productos actuales en el carrito.
     *
     * @return texto del contador del carrito (por ejemplo, "1").
     */
    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }
}
