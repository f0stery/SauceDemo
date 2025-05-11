package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void test() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.addProduct("Sauce Labs Bike Light");
        productsPage.openCart();
        assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Nothing");
        assertEquals(cartPage.getProductFromCart(0),
                "Sauce Labs Backpack",
                "No");
        assertTrue(cartPage.getProductName().contains("Sauce Labs Backpack"));
    }
}
