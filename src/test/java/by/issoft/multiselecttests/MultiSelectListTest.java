package by.issoft.multiselecttests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectListTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void userCanSelectValuesInMultiSelect() {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement selectElement = driver.findElement(By.id("multi-select"));
        Select multiselect = new Select(selectElement);
        multiselect.selectByValue("Florida");
        multiselect.selectByValue("Ohio");
        multiselect.selectByValue("California");
        List<WebElement> allSelected = multiselect.getAllSelectedOptions();
        for (WebElement selected : allSelected) {
            System.out.print(selected.getText() + "\t");
        }
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
