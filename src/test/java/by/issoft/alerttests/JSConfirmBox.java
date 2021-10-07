package by.issoft.alerttests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSConfirmBox {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void userCanClickOkButton() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg' and contains(text(), 'Click me!')]")).click();
        driver.switchTo().alert().accept();
        Assertions.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'You pressed OK!')]")).isDisplayed());
    }

    @Test
    public void userCanClickCancelButton() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg' and contains(text(), 'Click me!')]")).click();
        driver.switchTo().alert().dismiss();
        Assertions.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'You pressed Cancel!')]")).isDisplayed());
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
