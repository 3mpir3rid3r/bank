/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbs.model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kalana
 */
public class JDBC {


    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/nbsERP_Dankotuwa?useUnicode=true&characterEncoding=utf-8";
    static Connection con;

    public Connection getConnection() {
       try{
            Class.forName(driver);
            if (con == null) {
            con = DriverManager.getConnection(url, "root", "123");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Unrechable Host");
        }
        return con;
    }
    public static void main(String[] args) {
        new JDBC().getConnection();
    }
}
