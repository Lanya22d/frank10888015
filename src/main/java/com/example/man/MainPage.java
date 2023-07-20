package com.example.man;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage {
private  Stage stage;
private Scene scene;
    @FXML
    void SwitchToAddGood_Screen(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AddGood.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void SwitchToAddVendors_Screen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddVendor.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void SwithToViewVendors_Screen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewVendors.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
