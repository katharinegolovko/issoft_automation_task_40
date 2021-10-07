package by.issoft.alerttests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertBox {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void userCanClickOkButton() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//*[@class='btn btn-default' and contains(text(), 'Click me!')]")).click();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        String expectedText = "I am an alert box!";
        Assertions.assertEquals(expectedText, alertText);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
