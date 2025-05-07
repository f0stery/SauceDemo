package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LocatorTest extends BaseTest {

    @Test
    public void checkLocator() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.className("error-message-container"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.linkText("About"));
        driver.findElement(By.partialLinkText("Reset"));
        driver.findElement(By.xpath("//a[@id='item_4_title_link']"));
        driver.findElement(By.xpath("//a[.//div[text()='Sauce Labs Backpack']]"));
        driver.findElement(By.xpath("//a[contains(@data-test,'title-link'"));
        driver.findElement(By.xpath("//a[contains(text(),'Backpack']"));
        driver.findElement(By.xpath("//input[@id='username']//ancestor::div"));
        driver.findElement(By.xpath("//form/descendant::input[@data-test='username']"));
        driver.findElement(By.xpath("//input[@data-test='username']" +
                "/following::input[@data-test='login-button']"));
        driver.findElement(By.xpath("//input[@data-test='login-button']/parent::form"));
        driver.findElement(By.xpath("//input[@data-test='login-button']" +
                "/preceding::input[@data-test='username']"));
        driver.findElement(By.cssSelector(".error"));
        driver.findElement(By.cssSelector(".error-message-container.error"));
        driver.findElement(By.cssSelector(".error-message-container .error-button"));
        driver.findElement(By.cssSelector("#login-button"));
        driver.findElement(By.cssSelector("h3"));
        driver.findElement(By.cssSelector("div.error-message-container"));
        driver.findElement(By.cssSelector("[type='submit']"));
        driver.findElement(By.cssSelector("[class~='error']"));
        driver.findElement(By.cssSelector("[class^='error']"));
        driver.findElement(By.cssSelector("[class$='container']"));
        driver.findElement(By.cssSelector("[class*='mess']"));
    }
}
