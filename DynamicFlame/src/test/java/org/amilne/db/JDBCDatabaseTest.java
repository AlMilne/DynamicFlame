/*
 * Module: DynamicFlame, Project: Unity Digital 
 * Copyright (C) Aviva UK Life, All rights reserved
 */
package org.amilne.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * DatabaseTest.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 21/12/2013
 */
@RunWith(JUnit4.class)
public class JDBCDatabaseTest {

    private static final Logger LOGGER = Logger.getLogger("JDBCDatabaseTest");
    private static Connection dbConnection = null;

    /**
     * setUp for tests.
     * 
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUp() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        LOGGER.info("MySQL JDBC Driver Registered!");

        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamicflame", "root", "password");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (dbConnection != null) {
            LOGGER.info("You made it, take control your database now!");
        } else {
            LOGGER.log(Level.SEVERE, "Failed to make connection!");
        }
    }

    @Test
    public void testQuery() {
        String selectTableSQL = "select * from image i, image_album ia where i.image_id = ia.image_id;";

        Statement statement = null;

        try {
            statement = dbConnection.createStatement();

            LOGGER.log(Level.FINE, "SQL: {}", selectTableSQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

                String userid = rs.getString("image_id");
                String username = rs.getString("title");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

    }

}
