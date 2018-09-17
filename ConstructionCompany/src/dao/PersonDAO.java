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
import java.sql.SQLException;

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
            preparedStatement.executeUpdate();
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
    
}
