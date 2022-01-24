package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Const;
import sample.Driver;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AddDriverController {

    @FXML
    private TableView<Driver> driverTable;

    @FXML
    protected void addDriver(ActionEvent event) {
        ObservableList<Driver> data = driverTable.getItems(); // получаем данные
        data.add(new Driver()); // добавляем строку
    }

}