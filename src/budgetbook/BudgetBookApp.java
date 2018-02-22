package budgetbook;

import budgetbook.controller.MainViewController;
import budgetbook.controller.SaveController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;
import java.util.prefs.Preferences;

public class BudgetBookApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("main_view.fxml"));
        Parent root = (Parent)loader.load();
        MainViewController controller = (MainViewController)loader.getController();
        controller.setBudgetBookApp(this);

        primaryStage.setTitle("Haushaltsbuch");
        primaryStage.setScene(new Scene(root, 700, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

