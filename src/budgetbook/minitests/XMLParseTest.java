package budgetbook.minitests;

import budgetbook.controller.SaveController;
import budgetbook.model.TableDataRow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class XMLParseTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SaveController saveController = new SaveController();
        File file = new File("xml", "Test.xml");

        if (file != null) {
            if (!file.getPath().endsWith(".xml")) {
                file =new File(file.getPath() + ".xml");
            }
            ObservableList<TableDataRow> saveData = FXCollections.observableArrayList();
            saveData.add(new TableDataRow("1", "2", "3", "4"));
            saveController.saveBookingDataToFile(saveData, file);
        }
    }
}
