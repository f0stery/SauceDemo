package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public boolean isProductInCart(String product) {
        return driver.findElement(By.xpath(String.format("//div[@class='cart_item']/*[text()='%s']",
                product))).isDisplayed();
    }

    public String getProductFromCart(int index) {
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }

    public ArrayList<String> getProductName() {
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }

    public String getProductPrice(String product) {
        return driver.findElement(By.xpath(String.format("//[text()='Sauce Labs Backpack']/ancestor::" +
                        "div[@class='cart_item']//*" +
                        "[@class = 'inventory_item_price']",
                product))).getText();
    }
}
