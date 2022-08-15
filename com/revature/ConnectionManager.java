package com.revature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection connection;



    private ConnectionManager() {

    }
    public static Connection getConnection() {
        if(connection == null) {
            connection = connect();
            //time to establish connection

        }
        return connection;
    }

    private static Connection connect(){
        //we are going to connect to database here
        try {
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream input = loader.getResourceAsStream("jdbc.properties");

            //FileReader reader = new FileReader("com/revature/jdbc.properties");
            props.load(input);

           String host = props.getProperty("host");
           String port = props.getProperty("port");
           String driver = props.getProperty("driver");
           String username = props.getProperty("username");
           String password = props.getProperty("password");
           String dbname = props.getProperty("dbname");

           StringBuilder builder = new StringBuilder("jdbc:postgresql://");
           builder.append(host);
           builder.append(":");
           builder.append(port);
           builder.append("/");
           builder.append(dbname);
            builder.append("?");
            builder.append(username);
            builder.append("&password=");
            builder.append(password);
            builder.append("currentSchema=myschema");


            //Class.forName(driver);
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(builder.toString());





        } catch (FileNotFoundException e) {
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
