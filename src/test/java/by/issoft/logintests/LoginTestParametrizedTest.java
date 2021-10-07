package by.issoft.logintests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTestParametrizedTest {

    private WebDriver driver;

    @BeforeEach
    void setUpForTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @CsvSource({"accountforautotest, Password1!", "accountforautotest2, Password2!"})
    @ParameterizedTest
    public void shouldLogInWithValidCredentials(String username, String password) {
        driver.get("https://mail.yandex.com");
        WebElement generalLoginButton = driver.findElement(By.xpath("//span[contains(text(), 'Log in')]//parent::a"));
        generalLoginButton.click();
        WebElement usernameElement = driver.findElement(By.id("passp-field-login"));
        usernameElement.sendKeys(username);
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
        WebElement passwordElement = driver.findElement(By.id("passp-field-passwd"));
        passwordElement.sendKeys(password);
        WebElement loginButton2 = driver.findElement(By.id("passp:sign-in"));
        loginButton2.click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='mail-NestedList-Item-Name'and contains(text(), 'Inbox')]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@target='_parent']//*[@class='user-account__name' and contains(text(), 'accountforautotest')]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='mail-Layout-ContentWrapper']")).isDisplayed());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
