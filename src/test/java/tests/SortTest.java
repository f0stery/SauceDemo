package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SortTest extends BaseTest{

    @Test (testName = "Проверка сортировки от A до Z")
    public void checkSortAToZ() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .isPageOpened()
                .selectSort("Name (A to Z)");
        assertTrue(productsPage.isSortedAToZ(),
                "Товары должны быть отсортированы A-Z");
    }

    @Test (testName = "Проверка сортировки от Z до A")
    public void checkSortZtoA() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .selectSort("Name (Z to A)");
        assertTrue(productsPage.isSortedZToA(),
                "Товары должны быть отсортированы Z-A");
    }

    @Test (testName = "Негативная проверка сортировки A до Z")
    public void checkWrongSortAToZ() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .selectSort("Name (A to Z)");
        assertFalse(productsPage.isSortedZToA(),
                "Это негативный тест, " +
                        "тут должна быть любая сортировка кроме A-Z");
    }

    @Test (testName = "Проверка сортировки low to high")
    public void checkSortLowToHigh() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .selectSort("Price (low to high)");
        assertTrue(productsPage.isSortedLowToHigh(),
                "Товары должны быть отсортированы " +
                        "по возрастанию цены low to high");
    }

    @Test (testName = "Проверка сортировки high to low")
    public void checkSortHighToLow() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .selectSort("Price (high to low)");
        assertTrue(productsPage.isSortedHighToLow(),
                "Товары должны быть отсортированы " +
                        "по убыванию цены high to low");
    }

    @Test (testName = "Негативная проверка сортировки A до Z")
    public void checkWrongSort() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .selectSort("Name (A to Z)");
        assertFalse(productsPage.isSortedHighToLow(),
                "Это негативный тест, " +
                        "тут должна быть любая сортировка кроме Name A to Z");
    }
}