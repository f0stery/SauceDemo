package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SortPage extends BasePage {

    public SortPage(WebDriver driver) {
        super(driver);
    }

    private static final By SORT_SELECT = By.cssSelector("[data-test='product-sort-container']");
    private static final By PRODUCT_NAME = By.cssSelector("[data-test='inventory-item-name']");
    private static final By ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");

    public void selectSort(String sort) {
        Select sortDropDown = new Select(driver.findElement(SORT_SELECT));
        sortDropDown.selectByVisibleText(sort);
    }

    public List<String> getAllProductsNames() {
        List<WebElement> nameElements = driver.findElements(PRODUCT_NAME);
        List<String> actualNames = new ArrayList<>();

        for (WebElement element : nameElements) {
            actualNames.add(element.getText().trim());
        }
        return actualNames;
    }

    public boolean isSortedAToZ() {
        List<String> productNames = getAllProductsNames();

        for (int i = 0; i < productNames.size() - 1; i++) {
            String current = productNames.get(i);
            String next = productNames.get(i + 1);
            if (current.compareToIgnoreCase(next) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedZToA() {
        List<String> productNames = getAllProductsNames();
        for (int i = 0; i < productNames.size() - 1; i++) {
            String current = productNames.get(i);
            String next = productNames.get(i + 1);
            if (current.compareToIgnoreCase(next) < 0) {
                return false;
            }
        }
        return true;
    }

    public List<Double> getAllItemsPrices() {
        List<WebElement> priceElements = driver.findElements(ITEM_PRICE);
        List<Double> actualPrices = new ArrayList<>();

        for (WebElement element : priceElements) {
            actualPrices.add(Double.parseDouble(element.getText().
                    replace("$", "").trim()));
        }
        return actualPrices;
    }

    public boolean isSortedLowToHigh() {
        List<Double> priceElements = getAllItemsPrices();
        for (int i = 0; i < priceElements.size() - 1; i++) {
            Double current = priceElements.get(i);
            Double next = priceElements.get(i + 1);
            if (current > next) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedHighToLow() {
        List<Double> priceElements = getAllItemsPrices();
        for (int i = 0; i < priceElements.size() - 1; i++) {
            Double current = priceElements.get(i);
            Double next = priceElements.get(i + 1);
            if (current < next) {
                return false;
            }
        }
        return true;
    }
}
