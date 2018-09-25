/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.PersonDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mgrubljesic
 */
public class PersonDAO {
    
        public static boolean savePerson(PersonDTO person) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "insert into person (Personal_id_Number, First_Name, Last_Name, Date_of_birth, Phone_number, E_mail) values (?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, person.getPersonalIdNumber());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getDateOfBirth());
            preparedStatement.setString(5, person.getPhoneNumber());
            preparedStatement.setString(6, person.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
        return false;
    }

    public static ArrayList<String> getClients() {
        ArrayList<String> clients = new ArrayList<>();

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT * FROM get_managers";
            statement = connection.prepareCall(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clients.add(resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
        return clients;
    }
}
