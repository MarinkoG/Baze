/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connectionpool.ConnectionPool;
import dto.AddressDTO;
import dto.EmployeeDTO;
import dto.ProjectDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author LJUBO
 */
public class ProjectDAO {

    public static ArrayList<ProjectDTO> getProjects() {
        ArrayList<ProjectDTO> projects = new ArrayList<ProjectDTO>();

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "SELECT * FROM get_projects";
            statement = connection.prepareCall(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String manager = resultSet.getString(6) + ", " + resultSet.getString(7) + ", " + resultSet.getString(8);
                String client = resultSet.getString(9) + ", " + resultSet.getString(10) + ", " + resultSet.getString(11);
                ProjectDTO project = new ProjectDTO(resultSet.getInt(1), resultSet.getString(2), manager, client, resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5));
                projects.add(project);
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

        return projects;
    }

    public static boolean saveProject(ProjectDTO project) {

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "call save_project(?, ?, ?, ?, ?, ?, ?);";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, project.getName());
            callableStatement.setString(2, project.getStartDate());
            callableStatement.setString(3, project.getCompletionDate());
            callableStatement.setFloat(4, project.getPrice());
            callableStatement.setString(5, project.getManagerId());
            callableStatement.setString(6, project.getClientId());
            callableStatement.registerOutParameter(7, Types.INTEGER);
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


    /*
    public static boolean saveProject(ProjectDTO project) {

        Connection connection = null;
        String query = null;
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;
        try {
            connection = ConnectionPool.getInstance().checkOut();
            query = "INSERT INTO `construction_company`.`project` (`Name`, `Start_date`, `Completion_date`, `Price`) VALUES(?, ?, ?, ?);";
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, project.getName());
            callableStatement.setString(2, project.getStartDate());
            callableStatement.setString(3, project.getCompletionDate());
            callableStatement.setFloat(4, project.getPrice());
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
    
     */
}
