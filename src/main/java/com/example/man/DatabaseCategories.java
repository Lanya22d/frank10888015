package com.example.man;

import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCategories {

      public ObservableList getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "lorlornyo@2020");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName + " LIMIT 1")) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

          return (ObservableList) columnNames;
    }

}
