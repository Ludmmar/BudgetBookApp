package budgetbook;

import budgetbook.controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BudgetBookApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("main_view.fxml"));
        Parent root = loader.load();
        MainViewController controller = loader.getController();
        controller.setBudgetBookApp(this);

        primaryStage.setTitle("Haushaltsbuch");
        primaryStage.setScene(new Scene(root, 700, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

