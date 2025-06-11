package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final By TITLE = By.cssSelector("[data-test = title]"),
            CART_BUTTON = By.cssSelector(".shopping_cart_link"),
            SORT_SELECT = By.cssSelector("[data-test='product-sort-container']"),
            PRODUCT_NAME = By.cssSelector("[data-test='inventory-item-name']"),
            ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");
    private static final String ADD_TO_CART_PATTERN = "//*[text() = '%s']/ancestor" +
            "::div[@class = 'inventory_item']//button",
            PRODUCT_PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @Override
    public ProductsPage open() {
        log.info("Product page open");
        driver.get(PRODUCT_PAGE_URL);
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public String getTitle() {
        log.info("Get Title");
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара с именем: {product} в корзину")
    public ProductsPage addProduct(String product) {
        log.info("Add product '{}' in cart", product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие кнопки корзины")
    public CartPage openCart() {
        log.info("Open Cart");
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    public void selectSort(String sort) {
        log.info("Select '{}' sort", sort);
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
        log.info("Checking sort A to Z");
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
        log.info("Checking sort Z to A");
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
        log.info("Get all items prices");
        List<WebElement> priceElements = driver.findElements(ITEM_PRICE);
        List<Double> actualPrices = new ArrayList<>();

        for (WebElement element : priceElements) {
            actualPrices.add(Double.parseDouble(element.getText().
                    replace("$", "").trim()));
        }
        return actualPrices;
    }

    public boolean isSortedLowToHigh() {
        log.info("Checking sort Low to High");
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
        log.info("Checking sort High to Low");
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
