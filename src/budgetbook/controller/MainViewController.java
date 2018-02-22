package budgetbook.controller;

import budgetbook.BudgetBookApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private TableController tableViewController;

    @FXML
    private FormController formViewController;

    private BudgetBookApp budgetBookApp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableView tableView = tableViewController.getMainTableView();
        formViewController.setTableView(tableView);
    }

    public void setBudgetBookApp(BudgetBookApp budgetBookApp) {
        this.budgetBookApp = budgetBookApp;
        formViewController.setBudgetBookApp(budgetBookApp);
    }
}