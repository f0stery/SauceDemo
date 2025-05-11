package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkCart() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProduct("Sauce Labs Backpack");
        productsPage.openCart();
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "Товар 'Sauce Labs Backpack' должен быть в корзине");
        softAssert.assertEquals(cartPage.getProductFromCart(0),
                "Sauce Labs Backpack",
                "Название первого товара в корзине не совпадает");
        softAssert.assertTrue(cartPage.getProductsName().contains("Sauce Labs Backpack"),
                "Список товаров должен содержать 'Sauce Labs Backpack'");
        softAssert.assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"),
                29.99,
                "Цена товара не соответствует ожидаемой");
        softAssert.assertAll();
    }
}
