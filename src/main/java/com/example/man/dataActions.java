package com.example.man;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dataActions {

    private void addItemToSelectedColumn(String columnName, String item) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagement", "root", "lorlornyo@2020");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO addgoodtable (" + columnName + ") VALUES (?)")) {

            statement.setString(1, item);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
