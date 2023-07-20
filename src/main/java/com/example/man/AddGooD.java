package com.example.man;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class AddGooD implements Initializable {

    @FXML
    private TextField buying_txtfield;

    @FXML
    private ComboBox<String> category;

    @FXML
    private TextField date_txtfield;

    @FXML
    private TextField quantity_txtfield;

    @FXML
    private TextField selling_txtfield;
    private  Stage stage;
    private  Scene scene;




    @FXML
    void GoBackBtn_AddGood(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    void Load_Items(ActionEvent event){}




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        load_ComboBox();

    }





    public void load_ComboBox(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "lorlornyo@2020");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SHOW COLUMNS FROM addgoodtable")) {

            while (resultSet.next()) {
                String columnName = resultSet.getString("Field");
                category.getItems().add(columnName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




