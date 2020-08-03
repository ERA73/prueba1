/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteban
 */
public class Conexion {

    private Connection cx;
    private String db = "company";
    private String url = "jdbc:mysql://localhost/"+db;
    private String user = "root";
    private String pass = "admin";
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.cx = (Connection)DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException|SQLException ex) {
            System.out.println("Sin conexión.");
        }
    }
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cx = (Connection)DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException|SQLException ex) {
            System.out.println("Sin conexión.");
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo desconectar.");
        }
    }
    
    public static void main(String args[]){
        Conexion c = new Conexion();
        c.conectar();
    }
}
