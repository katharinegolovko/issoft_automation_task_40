package by.issoft;

import java.util.ArrayList;
import java.util.List;

public class TableRow {

    private String name;
    private String position;
    private String office;
    private String age;
    private String salary;

    public TableRow() {

    }

    public TableRow(String name, String position, String office, String age, String salary) {
        this.name = name;
        this.position = position;
        this.office = office;
        this.age = age;
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<TableRow> ageCheck(List<TableRow> tableRows) {
        List<TableRow> approvedRows = new ArrayList<>();
        for (TableRow tableRow : tableRows) {
            if (Integer.parseInt(tableRow.getAge()) > 35) {
                approvedRows.add(tableRow);
            }
        }
        return approvedRows;
    }

    public List<TableRow> conditionCheck(List<TableRow> tableRows) {
        List<TableRow> approvedRows = new ArrayList<>();
        for (TableRow tableRow : tableRows) {
            int salary = tableRow.parseStringToInt(tableRow.getSalary().substring(1));
            if (Integer.parseInt(tableRow.getAge()) > 35 && salary > 100000) {
                approvedRows.add(tableRow);
            }
        }
        return approvedRows;
    }

    public int parseStringToInt(String s) {
        s = s.replaceAll(",", "");
        s = s.replaceAll("/y", "");
        return Integer.parseInt(s);
    }
}
