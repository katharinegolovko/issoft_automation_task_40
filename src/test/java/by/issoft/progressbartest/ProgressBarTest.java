package by.issoft.progressbartest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressBarTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void refreshPageAfter50Percents() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        driver.findElement(By.id("cricle-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='percenttext' and contains(text(), '5')]")));
        driver.navigate().refresh();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
