/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.AddressDTO;
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
                AddressDTO address = null;
                if (resultSet.getString(12) != null) {
                    address = new AddressDTO(new Integer(resultSet.getString(12)), resultSet.getString(13), resultSet.getString(14), resultSet.getString(15), resultSet.getString(16));
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

    public static boolean deleteEmployee(EmployeeDTO selectedEmployee) {
        Connection connection = null;
        String query = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "delete from employee where Personal_id_Number=?";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, selectedEmployee.getPersonalIdNumber());
            //callableStatement.setInt(2, selectedEmployee.getAddress().getId());
            System.out.println(selectedEmployee+" "+selectedEmployee.getPersonalIdNumber()+" - "+selectedEmployee.getAddress().getId());
            callableStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
    }

    public static boolean saveEmployee(EmployeeDTO employee) {
        employee.getAddress().setId(AddressDAO.saveAddress(employee.getAddress()));

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();

            query = "call save_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, employee.getPersonalIdNumber());
            callableStatement.setString(2, employee.getFirstName());
            callableStatement.setString(3, employee.getLastName());
            callableStatement.setString(4, employee.getDateOfBirth());
            callableStatement.setInt(5, employee.getAddress().getId());
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

    public static boolean updateEmployee(EmployeeDTO employee, int option) {
        if (option == 1) {
            AddressDAO.updateAddress(employee.getAddress());
        }else if (option == 2) {
            employee.getAddress().setId(AddressDAO.saveAddress(employee.getAddress()));
        } 
        
        Connection connection = null;
        String query = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "call update_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, employee.getPersonalIdNumber());
            callableStatement.setString(2, employee.getFirstName());
            callableStatement.setString(3, employee.getLastName());
            callableStatement.setString(4, employee.getDateOfBirth());
            callableStatement.setInt(5, employee.getAddress().getId());
            callableStatement.setString(6, employee.getPhoneNumber());
            callableStatement.setString(7, employee.getEmail());
            callableStatement.setInt(8, new Integer(employee.getHourlyRate()));
            callableStatement.setInt(9, new Integer(employee.getSalary()));
            callableStatement.registerOutParameter(10, Types.VARCHAR);
            callableStatement.executeUpdate();
            
            if (option == 0) {
               AddressDAO.deleteAddress(employee.getAddress());
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
    }

    public static ArrayList<String> getEmployeesForMenager() {
        ArrayList<String> employees = new ArrayList<>();

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
                employees.add(resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
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
}
