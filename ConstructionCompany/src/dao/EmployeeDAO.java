/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.EmployeeDTO;
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
                String address = resultSet.getString(12) + ", " + resultSet.getString(13) + ", " + resultSet.getString(14) + ", " + resultSet.getString(15);
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
        PersonDAO.savePerson(employee);
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();

            query = "insert into employee (Personal_id_Number, Salary, Hourly_rate) values (?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getPersonalIdNumber());
            preparedStatement.setString(2, employee.getSalary());
            preparedStatement.setString(3, employee.getHourlyRate());
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
