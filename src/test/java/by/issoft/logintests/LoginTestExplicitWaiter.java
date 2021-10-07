package by.issoft.logintests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestExplicitWaiter {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void loginTest() throws InterruptedException {
        driver.get("https://mail.yandex.com");
        WebElement generalLoginButton = driver.findElement(By.xpath("//span[contains(text(), 'Log in')]//parent::a"));
        generalLoginButton.click();
        WebElement username = driver.findElement(By.id("passp-field-login"));
        username.sendKeys("accountforautotest");
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
        WebElement password = driver.findElement(By.id("passp-field-passwd"));
        password.sendKeys("Password1!");
        WebElement loginButton2 = driver.findElement(By.id("passp:sign-in"));
        loginButton2.click();
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@target='_parent']//*[@class='user-account__name' and contains(text(), 'accountforautotest')]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@target='_parent']//*[@class='user-account__name' and contains(text(), 'accountforautotest')]")).isDisplayed());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}

