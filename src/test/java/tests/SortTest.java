package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SortTest extends BaseTest{

    @Test
    public void checkSortAToZ() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectSort("Name (A to Z)");
        assertTrue(productsPage.isSortedAToZ(),
                "Товары должны быть отсортированы A-Z");
    }

    @Test
    public void checkSortZtoA() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectSort("Name (Z to A)");
        assertTrue(productsPage.isSortedZToA(),
                "Товары должны быть отсортированы Z-A");
    }

    @Test
    public void checkWrongSortAToZ() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectSort("Name (A to Z)");
        assertFalse(productsPage.isSortedZToA(),
                "Это негативный тест, " +
                        "тут должна быть любая сортировка кроме A-Z");
    }

    @Test
    public void checkSortLowToHigh() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectSort("Price (low to high)");
        assertTrue(productsPage.isSortedLowToHigh(),
                "Товары должны быть отсортированы " +
                        "по возрастанию цены low to high");
    }

    @Test
    public void checkSortHighToLow() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectSort("Price (high to low)");
        assertTrue(productsPage.isSortedHighToLow(),
                "Товары должны быть отсортированы " +
                        "по убыванию цены high to low");
    }

    @Test
    public void checkWrongSort() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectSort("Name (A to Z)");
        assertFalse(productsPage.isSortedHighToLow(),
                "Это негативный тест, " +
                        "тут должна быть любая сортировка кроме Name A to Z");
    }
}
