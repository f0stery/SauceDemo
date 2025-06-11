package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CartPage extends BasePage {

    public static final String CART_PAGE_URL = BASE_URL + "/cart.html";
    public static final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage open() {
        log.info("Open cart page");
        driver.get(CART_PAGE_URL);
        return this;
    }

    @Override
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public boolean isProductInCart(String product) {
        log.info("Checking product '{}' in cart", product);
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item']//*[text()='%s']", product)))
                .isDisplayed();
    }

    public String getProductFromCart(int index) {
        log.info("Get product {} from cart", index);
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }

    public ArrayList<String> getProductsName() {
        log.info("Get product Name");
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }

    public double getProductPrice(String product) {
        log.info("Get product '{}' Price", product);
        return Double.parseDouble(driver.findElement(
                        By.xpath(String.format(
                                "//*[text() = '%s']/ancestor::div[@class='cart_item']//" +
                                        "*[@class = 'inventory_item_price']", product)))
                .getText().replace("$", ""));
    }
}
