package budgetbook.controller;

import budgetbook.BudgetBookApp;
import budgetbook.model.TableDataRow;
import budgetbook.model.TableDataWrapper;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.prefs.Preferences;

public class SaveController {

    public File getBookDataPath() {
        Preferences prefs = Preferences.userNodeForPackage(BudgetBookApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setBookDataFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(BudgetBookApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
        } else {
            prefs.remove("filePath");
        }
    }

    public void saveBookingDataToFile(ObservableList saveData, File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(SaveController.class, TableDataWrapper.class, TableDataRow.class);
            Marshaller erzeuger = context.createMarshaller();
            erzeuger.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            TableDataWrapper wrapper = new TableDataWrapper();
            wrapper.setEntries(saveData);

            erzeuger.marshal(wrapper, file);

            setBookDataFilePath(file);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();

        }
    }

}
