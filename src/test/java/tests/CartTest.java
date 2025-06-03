package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test (testName = "Проверка добавления товара в корзину")
    @Epic("Корзина")
    @Feature("Добавление товара")
    @Story("Отображение товара в корзине")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Evgeny Khainiuk")
    @Description("Проверка добавления товара в корзину")
    @Flaky
    @Link(name = "Документация", url = "https://www.saucedemo.com/")
    @TmsLink("TMS_T10")
    @Issue("TMS_T11")
    public void checkCart1() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .isPageOpened();
        productsPage.open()
                .isPageOpened()
                .addProduct("Sauce Labs Backpack")
                .openCart()
                .isPageOpened();
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
