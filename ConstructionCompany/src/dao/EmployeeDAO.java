/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.Address;
import dto.EmployeeDTO;
import dto.UserDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author mgrubljesic
 */
public class EmployeeDAO {

    public static ArrayList<EmployeeDTO> getAllEmployees() {
        ArrayList<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT * FROM show_employees";
            statement = connection.prepareCall(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = null;
                if (resultSet.getString(12) != null) {
                    address = new Address(new Integer(resultSet.getString(12)), resultSet.getString(13), resultSet.getString(14), resultSet.getString(15), resultSet.getString(16));
                }
                employees.add(new EmployeeDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), address));
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

        return employees;
    }

    public static void deleteEmployee(EmployeeDTO selectedEmployee) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "delete from employee where Personal_id_Number=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, selectedEmployee.getPersonalIdNumber());
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

    public static boolean saveEmployee(EmployeeDTO employee) {
        int addressId = -1;
        
        if (employee.getAddress() != null) {
            addressId = saveAddress(employee.getAddress());
        }
        
        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();

            query = "call save_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1,  employee.getPersonalIdNumber());
            callableStatement.setString(2, employee.getFirstName());
            callableStatement.setString(3, employee.getLastName());
            callableStatement.setString(4, employee.getDateOfBirth());
            callableStatement.setInt(5, addressId);
            callableStatement.setString(6, employee.getPhoneNumber());
            callableStatement.setString(7, employee.getEmail());
            callableStatement.setString(8, employee.getHourlyRate());
            callableStatement.setString(9, employee.getSalary());
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
        return false;
        
        
       
    }
    
    public static int saveAddress(Address address) {
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

}
