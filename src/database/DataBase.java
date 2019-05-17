/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author johannessulzbacher
 */
public class DataBase {

    /**
     * The one and only object of the class DataBase
     */
     
    
    private Connection conn;
    private static DataBase theInstance;
    /**
     * private constructor for singleton implementation
     */

    public DataBase() throws SQLException {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");
    }
    
    /**
     * Created the instace of the DataBase class if not exist
     * @return The one and only object of the DataBase class.
     */
    public static synchronized DataBase getInstance() throws SQLException {
        if (theInstance == null) {
            theInstance = new DataBase();
        }

        return theInstance;
    }
    
    
    /**
     * It inserts the sales of a game in the database after entering a name.
     */
    public void insertSales(String name, int anzahl) throws SQLException {
        String sqlString = "INSERT INTO sales (name, anzahl) VALUES (?, ?)";
        PreparedStatement stat = conn.prepareStatement(sqlString);
        stat.setString(1, name);
        stat.setInt(2, anzahl);
        stat.executeUpdate();
    }
    
    /**
     * It inserts the year and the amount of games that got released.
     */
    public void insertYear(int year, int anzahl) throws SQLException {
        String sqlString = "INSERT INTO games_per_year (year, anzahl) VALUES (?, ?)";
        PreparedStatement stat = conn.prepareStatement(sqlString);
        stat.setInt(1, year);
        stat.setInt(2, anzahl);
        stat.executeUpdate();
    }
    
    /**
     * Outputs the year with most releases.
     */
    public void getYearWithMostReleases() throws SQLException {
        Statement stat = conn.createStatement();
        String sqlString = "SELECT year FROM games_per_year WHERE anzahl = (SELECT max(anzahl) from games_per_year)";
        ResultSet res = stat.executeQuery(sqlString);
        while(res.next()){
            System.out.println(""+res.getString("name"));
        }
    }

    /**
     * Outputs the game with the most sales.
     */
    public void getGameWithMostSales() throws SQLException {
        Statement stat = conn.createStatement();
        String sqlString = "SELECT name FROM sales WHERE anzahl = (SELECT max(anzahl) from sales)";
        ResultSet res = stat.executeQuery(sqlString);
        while(res.next()){
            System.out.println(""+res.getString("name"));
        }
    }
    
    /**
     * A test method.
     */
    public void listAllDepartments() throws SQLException{
        Statement stat = conn.createStatement();
        String sqlString = "SELECT * FROM sales";
        ResultSet res = stat.executeQuery(sqlString);
        while(res.next()){
            System.out.println(""+res.getString("name"));
        }
    }
}

