package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test (testName = "Удачный вход", priority = 1, description = "Удачный логин")
    @Epic("Авторизация")
    @Feature("Страница логина")
    @Story("Позитивный логин")
    public void checkSuccessLogin() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .isPageOpened();
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test (testName = "Проверка логина с пустым паролем", priority = 2)
    public void checkLoginWithEmptyPassword() {
        loginPage.open()
                .isPageOpened()
                .login(user, "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "SO BAAD");
    }

    @Test (testName = "Негативные тесты для пароля", priority = 3)
    public void checkWithWrongPassword() {
        loginPage.open()
                .isPageOpened()
                .login(user, "1231412314123");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "SO BAAD");
    }

    @DataProvider (name = "Негативные тесты для логина")
    public Object[][] loginData() {
        return new Object[][] {
                {user, "", "Epic sadface: Password is required"},
                {user, "1231412314123",
                        "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Негативные тесты для логина")
    public void login(String user, String password, String message) {
        loginPage.open()
                .isPageOpened()
                .login(user, password);
        assertEquals(loginPage.getErrorMessage(),
                message,
                "SO BAAD");
    }
}
