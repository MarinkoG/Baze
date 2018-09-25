/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.EmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.AddressDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author LJUBO
 */
public class AddressDAO {
    public static int saveAddress(AddressDTO address) {
        int id = -1;
        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();

            query = "call save_address(?, ?, ?, ?, ?)";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, address.getCity());
            callableStatement.setString(2, address.getStreet());
            callableStatement.setString(3, address.getZipCode());
            callableStatement.setString(4, address.getHouseNumber());
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.executeUpdate();
            id = callableStatement.getInt(5);
        } catch (SQLException e) {
            e.printStackTrace();
            return id;
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                    return id;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
        return id;
    }

    public static boolean updateAddress(AddressDTO address) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "update address set City=?, Street=?, Zip_code=?, House_number=? where Address_id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getZipCode());
            preparedStatement.setString(4, address.getHouseNumber());
            preparedStatement.setInt(5, address.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
    }

    static void deleteAddress(AddressDTO address) {
         Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "delete from address where Address_id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
    }
}
