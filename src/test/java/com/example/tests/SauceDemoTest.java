package com.example.tests;

import com.example.tests.pages.LoginPage;
import com.example.tests.pages.ProductsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Prueba end-to-end para el sitio SauceDemo.
 * Verifica el inicio de sesión, la visualización de productos
 * y la funcionalidad del carrito de compras.
 */
public class SauceDemoTest extends BaseTest {

    @Test
    @DisplayName("Login válido y verificación de productos y carrito")
    public void loginAndAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Paso 1: Abrir la página e iniciar sesión
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Paso 2: Verificar que aparecen productos
        List<String> titles = productsPage.getAllProductTitles();
        assertTrue(titles.size() > 0, "Debería haber al menos un producto listado");

        // Paso 3: Añadir el primer producto al carrito
        productsPage.addFirstProductToCart();

        // Paso 4: Verificar que el contador del carrito muestra 1
        assertEquals("1", productsPage.getCartCount(), 
                "El contador del carrito debería mostrar 1");
    }
}
