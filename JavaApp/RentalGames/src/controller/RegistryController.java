/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.MainContiner;

/**
 *
 * @author Esteban
 */
public class RegistryController {
    private MainContiner main;
    private Conexion c;

    public RegistryController(MainContiner main) {
        this.c = new Conexion();
        this.main = main;
        main.getJbtn_user_registry().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crear_usuario();
            }
        });
    }
    
    private boolean crear_usuario(){
        try {
            String sql_query = "INSERT INTO user VALUES(?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql_query);
            String document = this.main.getJtf_user_registry_document().getText();
            System.out.println(document);
            ps.setInt(0, Integer.parseInt(document));
            ps.setString(1, this.main.getJtf_user_registry_email().getText());
            ps.setString(2, this.main.getJtf_user_registry_name().getText());
            ps.setString(3, this.main.getJtf_user_registry_phone().getText());
            ps.setInt(4, Integer.parseInt(this.main.getJtf_user_registry_age().getText()));
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            JOptionPane.showMessageDialog(this.main, "El usuario se creo correctamente.");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo crear el usuario.");
            return false;
        }
    }
}
