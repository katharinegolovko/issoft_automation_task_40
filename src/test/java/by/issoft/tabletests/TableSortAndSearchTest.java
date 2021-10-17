package by.issoft.tabletests;

import by.issoft.TableRow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TableSortAndSearchTest {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void userCanGetDataFromTable() {
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
        WebElement selectElement = driver.findElement(By.name("example_length"));
        Select showEntriesDropDown = new Select(selectElement);
        showEntriesDropDown.selectByValue("10");
        WebElement simpleTable = driver.findElement(By.id("example"));

        List<TableRow> tableRows = new ArrayList<>();
        TableRow table = new TableRow();

        for (int i = 1; i < 11; i++) {
            String colName = simpleTable.findElement(By.xpath("//tr[" + i + "]//td[1]")).getText();
            String colPosition = simpleTable.findElement(By.xpath("//tr[" + i + "]//td[2]")).getText();
            String colOffice = simpleTable.findElement(By.xpath("//tr[" + i + "]//td[3]")).getText();
            String colAge = simpleTable.findElement(By.xpath("//tr[" + i + "]//td[4]")).getText();
            String colSalary = simpleTable.findElement(By.xpath("//tr[" + i + "]//td[6]")).getText();
            tableRows.add(new TableRow(colName, colPosition, colOffice, colAge, colSalary));
        }

        List<TableRow> newRows = table.conditionCheck(tableRows);
        for (TableRow newRow : newRows) {
            System.out.println(newRow.getName());
            System.out.println(newRow.getAge());
            System.out.println(newRow.getSalary());
        }
    }


    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
