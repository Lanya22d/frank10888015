package com.example.man;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AddVendor {

    @FXML
    private TextField DateOFBirth;

    @FXML
    private TextField DateOfRegister;

    @FXML
    private TextField Location;

    @FXML
    private TextField Vendor_fName;

    @FXML
    private JFXButton vendor_Save;

    @FXML
    private JFXButton vendor_close;

    @FXML
    private TextField vendor_lname;


    private Scene scene;
    private  Stage stage;
    Connection connection = null;
    PreparedStatement pInsert = null;
    PreparedStatement CheckUserExist = null;
    ResultSet resultSet = null;

    @FXML
    void BackBt_AddVendors(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    void Save_Credential(ActionEvent event) {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "lorlornyo@2020");
            pInsert = connection.prepareStatement("INSERT INTO vendorcredential (FirstName, LastName, DateOfBirth,DateOfRegister,Location) VALUES (?,?,?,?,?)");

            pInsert.setString(1,Vendor_fName.getText());
            pInsert.setString(2,vendor_lname.getText());
            pInsert.setString(3,DateOFBirth.getText());
            pInsert.setString(4,DateOfRegister.getText());
            pInsert.setString(5,Location.getText());


            pInsert.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}





