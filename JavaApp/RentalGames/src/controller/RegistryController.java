/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.MainContiner;

/**
 *
 * @author Esteban
 */
public class RegistryController {
    private MainContiner main;
    private Conexion c;
    private ArrayList<Integer> list_game_id;

    public RegistryController(MainContiner main) {
        this.c = new Conexion();
        this.main = main;
        this.list_game_id = new ArrayList<Integer>();
        load_game_names();
        main.getJbtn_user_registry().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crear_usuario();
            }
        });
        main.getJbtn_update_cost().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_cost();
            }
        });
    }
    
    private void crear_usuario(){
        try {
            String sql_query = "INSERT INTO user (document, email, full_name, phone, age) VALUES(?,?,?,?,?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql_query);
            String document = this.main.getJtf_user_registry_document().getText();
            System.out.println(document);
            ps.setInt(1, Integer.parseInt(document));
            ps.setString(2, this.main.getJtf_user_registry_email().getText());
            ps.setString(3, this.main.getJtf_user_registry_name().getText());
            ps.setString(4, this.main.getJtf_user_registry_phone().getText());
            ps.setInt(5, Integer.parseInt(this.main.getJtf_user_registry_age().getText()));
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            JOptionPane.showMessageDialog(this.main, "El usuario se creo correctamente.");
            clear_usuario();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo crear el usuario.");
        }
    }
    
    private void update_cost(){
        try {
            int index = this.main.getJcb_update_cost_name().getSelectedIndex();
            int id_game = this.list_game_id.get(index);
            String sql_query = "insert into cost (id_game, cost, cost_date) values(?, ?, CURRENT_DATE())";
            PreparedStatement ps = c.conectar().prepareStatement(sql_query);
            ps.setInt(1, id_game);
            float cost = Float.parseFloat(this.main.getJtf_update_cost_value().getText());
            ps.setFloat(2, cost);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            JOptionPane.showMessageDialog(this.main, "Se actualizo el costo correctamente.");
            clear_usuario();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo actualizar el costo.");
        }
    }
    
    private void clear_usuario(){
        this.main.getJtf_user_registry_document().setText("");
        this.main.getJtf_user_registry_email().setText("");
        this.main.getJtf_user_registry_name().setText("");
        this.main.getJtf_user_registry_phone().setText("");
        this.main.getJtf_user_registry_age().setText("");
    }
    
    private void load_game_names(){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("select id_game, title from game");
            int id = 0;
            String name = "";
            while(rs.next()){
                id = rs.getInt("id_game");
                name = rs.getString("title");
                this.list_game_id.add(id);
                this.main.getJcb_update_cost_name().addItem(name);
            }
            p.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el catalogo de juegos.");
        }
    }
}
