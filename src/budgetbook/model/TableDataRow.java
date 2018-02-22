package budgetbook.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.DateFormat;
import java.util.Date;

public class TableDataRow {

    private StringProperty date;
    private StringProperty name;
    private StringProperty cost;
    private StringProperty category;

    public TableDataRow(String date, String name, String cost, String category) {
        this.date = new SimpleStringProperty(date);
        this.name = new SimpleStringProperty(name);
        this.cost = new SimpleStringProperty(cost);
        this.category = new SimpleStringProperty(category);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCost() {
        return cost.get();
    }

    public StringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }
}
