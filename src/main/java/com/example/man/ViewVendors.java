package com.example.man;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewVendors {
    private  Stage stage;
    private  Scene scene;
    private Parent root;

    @FXML
    private TableColumn<Vendors, Date> DateOfBirth;

    @FXML
    private TableColumn<Vendors, Date> DateOfRegister;

    @FXML
    private TableColumn<Vendors, String> FirstName;

    @FXML
    private TableColumn<Vendors, String> LastName;

    @FXML
    private TableColumn<Vendors, String> Location;

    @FXML
    private TableView<Vendors> Table;

    private List<Vendors> getPersonData() {
        List<Vendors> personData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "lorlornyo@2020");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM vendorcredential")) {

            while (resultSet.next()) {
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                Date dateOfRegister = resultSet.getDate("DateOfRegister");
                Date dateOfBirth = resultSet.getDate("DateOfBirth");
                String location = resultSet.getString("Location");

                Vendors vendors = new Vendors(firstName,lastName,dateOfRegister,dateOfBirth,location);
                vendors.setFirstName(firstName);
                vendors.setLastName(lastName);
                vendors.setDateOfRegister(dateOfRegister);
                vendors.setDateOfBirth(dateOfBirth);
                vendors.setLocation(location);

                personData.add(vendors);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personData;
    }
    @FXML
    private void initialize() {
        // Set cell value factories to map data to the corresponding columns
        FirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        DateOfRegister.setCellValueFactory(new PropertyValueFactory<>("dateOfRegister"));
        DateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        Location.setCellValueFactory(new PropertyValueFactory<>("location"));

        // Fetch data from the MySQL table and populate the TableView
        Table.getItems().addAll(getPersonData());
    }

    @FXML
    void ViewVendors_BtnClose(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
