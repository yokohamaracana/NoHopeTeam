/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsvapp.helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tuan Tien
 */
public class Database {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=QLSVApp;";
        String dbusername = "sa";
        String password = "123";
        Connection con = DriverManager.getConnection(connectionUrl,dbusername,password);
        return  con;
    }
}
