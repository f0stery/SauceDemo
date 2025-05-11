package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SortTest extends BaseTest{

    @BeforeMethod
    public void authorization() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void checkSortAToZ() {
        sortPage.selectSort("Name (A to Z)");
        assertTrue(sortPage.isSortedAToZ(),
                "Товары должны быть отсортированы A-Z");
    }

    @Test
    public void checkSortZtoA() {
        sortPage.selectSort("Name (Z to A)");
        assertTrue(sortPage.isSortedZToA(),
                "Товары должны быть отсортированы Z-A");
    }

    @Test
    public void checkWrongSortAToZ() {
        sortPage.selectSort("Name (A to Z)");
        assertFalse(sortPage.isSortedZToA(),
                "Это негативный тест, " +
                        "тут должна быть любая сортировка кроме A-Z");
    }

    @Test
    public void checkSortLowToHigh() {
        sortPage.selectSort("Price (low to high)");
        assertTrue(sortPage.isSortedLowToHigh(),
                "Товары должны быть отсортированы " +
                        "по возрастанию цены low to high");
    }

    @Test
    public void checkSortHighToLow() {
        sortPage.selectSort("Price (high to low)");
        assertTrue(sortPage.isSortedHighToLow(),
                "Товары должны быть отсортированы " +
                        "по убыванию цены high to low");
    }

    @Test
    public void checkWrongSort() {
        sortPage.selectSort("Name (A to Z)");
        assertFalse(sortPage.isSortedHighToLow(),
                "Это негативный тест, " +
                        "тут должна быть любая сортировка кроме Name A to Z");
    }
}
