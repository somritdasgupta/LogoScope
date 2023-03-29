package DatabaseServlets;

/*
 * 1. import -----> java.sql.*;
 * 2. load and register the driver ----> com.mysql.jdbc.Driver 
 * 3. create connection object
 * 4. create a statement object
 * 5. execute the query
 * 6. process the results 
 * 7. close the connection
 */

import java.sql.*;

// ye servlet sirf connection initialise karne ke liye use kar rahe h
public class DatabaseConnection {
    public static Connection initializeDatabase() throws Exception {
        // Initializing everything needed for connection
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/test";
        // Database name to access
//        String dbName = "test";
        String dbUsername = "root";
        String dbPassword = "";

        // register kar rahe h isko class "Class" ka method "for name" se
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL , dbUsername , dbPassword);
        return con;
    }
}