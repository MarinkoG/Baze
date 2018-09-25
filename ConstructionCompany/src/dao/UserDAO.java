package dao;

import connectionpool.ConnectionPool;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LJUBO
 */
public class UserDAO {

    public static String login(String username, String password) {
        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String personalIdNumber = "";
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT Personal_id_Number FROM user_account where username=? and password=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                personalIdNumber = resultSet.getString(1);
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.getInstance().checkIn(connection);
        }
        return personalIdNumber;
    }
    public static void saveLogin(String id) {
        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "insert into login_log (Personal_id_Number, Login_Date) values (?, ?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
            preparedStatement.executeUpdate();
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

    public static ArrayList<UserDTO> getAllUsers() {
        ArrayList<UserDTO> users = new ArrayList<UserDTO>();

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT * FROM show_users";
            statement = connection.prepareCall(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(new UserDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
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

        return users;
    }

    public static ArrayList<String> getEmployeeWithoutAccount() {
        ArrayList<String> employeesWithoutAccount = new ArrayList<>();

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT * FROM employees_without_account";
            statement = connection.prepareCall(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employeesWithoutAccount.add(resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
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
        return employeesWithoutAccount;
    }

    public static ArrayList<String> getPrivileges() {
        ArrayList<String> privileges = new ArrayList<>();

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT name FROM privilege";
            statement = connection.prepareCall(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                privileges.add(resultSet.getString(1));
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
        return privileges;
    }

    public static boolean saveUser(UserDTO user) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "insert into user_account (Username, Password, Personal_id_Number, Privilege) values (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPersonalIdNumber());
            preparedStatement.setString(4, user.getPrivilege());
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

    public static boolean updateUser(UserDTO user) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "update user_account set Username=?, Password=?, Privilege=? where Personal_id_Number=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPrivilege());
            preparedStatement.setString(4, user.getPersonalIdNumber());
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

    public static void deleteUser(UserDTO selectedUser) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "delete from user_account where Personal_id_Number=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, selectedUser.getPersonalIdNumber());
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
