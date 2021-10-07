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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableSortAndSearch {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void userCanGetDataFromTable() {
        driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
        WebElement selectElement = driver.findElement(By.name("example_length"));
        Select showEntriesDropDown = new Select(selectElement);
        showEntriesDropDown.selectByValue("10");
        WebElement simpleTable = driver.findElement(By.id("example"));

        //Get all rows
        List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
        assertEquals(11, rows.size());

        //Get values from each column
        List<WebElement> colName = simpleTable.findElements(By.xpath("//tbody//td[1]"));
        List<WebElement> colPosition = simpleTable.findElements(By.xpath("//tbody//td[2]"));
        List<WebElement> colOffice = simpleTable.findElements(By.xpath("//tbody//td[3]"));
        List<WebElement> colAge = simpleTable.findElements(By.xpath("//tbody//td[4]"));
        List<WebElement> colStartDate = simpleTable.findElements(By.xpath("//tbody//td[5]"));
        List<WebElement> colSalary = simpleTable.findElements(By.xpath("//tbody//td[6]"));

        //Create tableRow objects
        TableRow tableRow1 = new TableRow();
        TableRow tableRow2 = new TableRow();
        TableRow tableRow3 = new TableRow();
        TableRow tableRow4 = new TableRow();
        TableRow tableRow5 = new TableRow();
        TableRow tableRow6 = new TableRow();
        TableRow tableRow7 = new TableRow();
        TableRow tableRow8 = new TableRow();
        TableRow tableRow9 = new TableRow();
        TableRow tableRow10 = new TableRow();

        List<TableRow> tableRows = new ArrayList<>();
        tableRows.add(tableRow1);
        tableRows.add(tableRow2);
        tableRows.add(tableRow3);
        tableRows.add(tableRow4);
        tableRows.add(tableRow5);
        tableRows.add(tableRow6);
        tableRows.add(tableRow7);
        tableRows.add(tableRow8);
        tableRows.add(tableRow9);
        tableRows.add(tableRow10);

        //Fill out objects with table data
        for (int i = 0; i < tableRows.size(); i++) {
            tableRows.get(i).setName(colName.get(i).getText());
            tableRows.get(i).setPosition(colPosition.get(i).getText());
            tableRows.get(i).setOffice(colOffice.get(i).getText());
            tableRows.get(i).setAge(colAge.get(i).getText());
            tableRows.get(i).setStartDate(colStartDate.get(i).getText());
            tableRows.get(i).setSalary(colSalary.get(i).getText());
        }


        for (WebElement col : colName) {
            System.out.print(col.getText() + "\t");
        }
    }


    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
