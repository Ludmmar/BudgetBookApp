package budgetbook.controller;

import budgetbook.BudgetBookApp;
import budgetbook.model.TableDataRow;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    //Referenz auf die Main.java (hier BudgeBookApp.java)
    private BudgetBookApp budgetBookApp;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField costTextField;

    @FXML
    private ComboBox categoryComboBox;

    @FXML
    private TextField outputField;

    //Klasse TabeleView nutzbar machen
    private TableView tableView;
    //Klasse SaveController nutzbar machen
    private SaveController saveController;

    //Klasse DateFormat (Java Standard) nutzbar machen
    private DateFormat dateFormat;
    private DateFormat fileDateFormat;

    //Klassenobjekt date initialisieren, um ein Datum übergeben zu können
    private Date date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        categoryComboBox.setValue("Test1");
//        categoryComboBox.setItems(kategorien);
        categoryComboBox.getItems().removeAll(categoryComboBox.getItems());
        categoryComboBox.getItems().addAll("Lebensmittel","Kantine","Feiern","Fahrtkosten","Hygiene","Kleidung","Anschaffungen","Bücher/Zeitschriften","Freizeit","Sonstiges");
        this.saveController = new SaveController();
        this.dateFormat = new SimpleDateFormat("dd.MM.");
        this.fileDateFormat = new SimpleDateFormat("dd.MM.-HH.mm");
        date = new Date();

        //setze default-Wert für Datum (Aktuelles Datum)
        dateTextField.setText(dateFormat.format(date));
        outputField.setText(fileDateFormat.format(date));
    }

    //Aktion, die bei Auswahl des Buttons "Hinzufügen" ausgeführt werden soll
    @FXML
    private void onButtonClicked() {
        //Daten aus den Feldern zwischenspeichern
        String date = dateTextField.getText();
        String name = nameTextField.getText();
        String cost = costTextField.getText();
        String category = (String) categoryComboBox.getValue();

        //Prüfen, ob alle Felder Daten enthalten, diese in die Tabelle übertragen und Felder leeren
        if (isStringValid(date, name, cost) && isComboBoxEmpty(category)) {
            //neues Tabellenzeilenobjekt erzeugen und befüllen, anschließend zur Tabelle hinzufügen
            TableDataRow tableEntry = new TableDataRow(date, name, cost, category);
            tableView.getItems().add(tableEntry);

            nameTextField.setText("");
            costTextField.setText("");
            categoryComboBox.getSelectionModel().clearSelection();
        }
    }

    //Aktion, die bei Auswahl des Buttons "Speichern" ausgeführt werden soll
    @FXML
    private void onSaveClicked() {

        //Speicherpfad für Übertragsungsdatei (aktuell im Projekt im Ordner "xml")
        File file = new File("xml", "DataSet-"+fileDateFormat.format(date) +".xml");

        if (file != null) {
            if (!file.getPath().endsWith(".xml")) {
                file =new File(file.getPath() + ".xml");
            }
            ObservableList saveData = tableView.getItems();
            saveController.saveBookingDataToFile(saveData, file);
        }
    }

    private boolean isStringValid(String... stringsToCheck) {
        for (String checkedString : stringsToCheck) {
            if (checkedString == null || checkedString.equals("")) {
                return false;
            }
        }
        return true;
    }

    private boolean isComboBoxEmpty(String stringToCheck) {
        if(stringToCheck == null || stringToCheck.equals("")) {
                return false;
        }
        return true;
    }

    public void setBudgetBookApp(BudgetBookApp budgetBookApp) {
        this.budgetBookApp = budgetBookApp;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }
}