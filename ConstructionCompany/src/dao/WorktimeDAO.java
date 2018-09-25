/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.AddressDTO;
import dto.EmployeeDTO;
import dto.WorktimeDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author LJUBO
 */
public class WorktimeDAO {

    public static ArrayList<WorktimeDTO> getWorktime() {
        ArrayList<WorktimeDTO> workTime = new ArrayList<WorktimeDTO>();

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT * FROM get_worktime";
            statement = connection.prepareCall(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                WorktimeDTO worktime = new WorktimeDTO(resultSet.getFloat(1), resultSet.getString(2), resultSet.getString(3));
                workTime.add(worktime);
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

        return workTime;
    }

    public static boolean saveWorktime(WorktimeDTO worktime) {
        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "INSERT INTO worktime_record (Work_hours, Personal_id_Number, Date) VALUES (?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, worktime.getWorkHours());
            preparedStatement.setString(2, worktime.getPersonalIdNumber());
            preparedStatement.setString(3, worktime.getDate());
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

    public static void deleteWorktime(WorktimeDTO worktime) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "delete from worktime_record where Personal_id_Number=? and Date=?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, worktime.getPersonalIdNumber());
            preparedStatement.setString(2, worktime.getDate());
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

    public static boolean updateWorktime(WorktimeDTO worktime) {
        Connection connection = null;
        String query = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "update worktime_record set Work_hours=? where Personal_id_Number=? and Date=?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, worktime.getWorkHours());
            preparedStatement.setString(2, worktime.getPersonalIdNumber());
            preparedStatement.setString(3, worktime.getDate());
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
