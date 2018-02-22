package budgetbook.controller;

import budgetbook.model.TableDataRow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private TableView mainTableView;
    @FXML
    private TableColumn dateColumn;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn costColumn;
    @FXML
    private TableColumn categoryColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<TableDataRow,String>("date"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<TableDataRow,String>("name"));
        costColumn.setCellValueFactory(new PropertyValueFactory<TableDataRow,String>("cost"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<TableDataRow,String>("category"));
    }

    public TableView getMainTableView() {
        return mainTableView;
    }
}
