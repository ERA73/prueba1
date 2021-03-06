/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.MainContiner;

/**
 *
 * @author Esteban
 */
public class RentalController {
    
    private MainContiner main;
    private Conexion c;
    private int document;
    private String email;
    private ArrayList<Integer> list_game_id;
    private ArrayList<Integer> rental_game_id;
    private ArrayList<Float> rental_game_cost;
    
    public RentalController(MainContiner main) {
        this.c = new Conexion();
        this.main = main;
        this.list_game_id = new ArrayList<Integer>();
        this.rental_game_id = new ArrayList<Integer>();
        this.rental_game_cost = new ArrayList<Float>();
        load_game_names();
        set_enabled_rental_panel(false);
        main.getJbtn_validate_user().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verify_user();
            }
        });
        main.getJbtn_rental_selection_add().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        main.getJbtn_rental_selection_delete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
        main.getJbtn_rental_selection_save().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        main.getJbtn_rental_selection_calcel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
    }
    
    private void verify_user(){
        try {
            Statement p = c.conectar().createStatement();
            this.document = Integer.parseInt(this.main.getJtf_validate_user_document().getText());
            this.email = this.main.getJtf_validate_user_email().getText();
            ResultSet rs = p.executeQuery("select us.document, us.email from user as us where us.document = "+document+" and us.email = \""+email+"\"");
            int doc = -1;
            while(rs.next()){
                doc = rs.getInt("us.document");
            }
            if(doc > 0){
                set_enabled_validate_panel(false);
                set_enabled_rental_panel(true);
            }else{
                JOptionPane.showMessageDialog(this.main, "El usuario no esta registrado.");
            }
            p.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo verificar el usuario.");
        }
    }
    
    private void set_enabled_rental_panel(boolean flag){
        this.main.getJpn_rental_selection().setVisible(flag);
    }
    
    private void set_enabled_validate_panel(boolean flag){
        this.main.getJpn_validate_user().setEnabled(flag);
        this.main.getJtf_validate_user_document().setEnabled(flag);
        this.main.getJtf_validate_user_email().setEnabled(flag);
        this.main.getJbtn_validate_user().setEnabled(flag);
    }
    
    private void reset_rental(){
        DefaultTableModel dtm = (DefaultTableModel) this.main.getJtbl_rental_selection().getModel();
        dtm.setRowCount(0);
        this.main.getJlb_rental_selection_message().setText("");
        rental_game_id = new ArrayList<Integer>();
    }
    
    private void add(){
        try {
            int index = this.main.getJcb_rental_selection_name().getSelectedIndex();
            int id_game = this.list_game_id.get(index);
            if(!is_rented(id_game)){
                float cost = get_cost(id_game);
                Statement p = c.conectar().createStatement();
            
                String sql_query = "select g.id_game, g.title, g.producer, g.technology, g.age, cos.cost from game as g right join (select c.id_game, c.cost ,max(c.cost_date) from cost as c where c.id_game = "+id_game+" and c.cost_date < CURRENT_DATE()) cos on (g.id_game = cos.id_game)";
                ResultSet rs = p.executeQuery(sql_query);
                while(rs.next()){
                    String title  = rs.getString("g.title");
                    String producer  = rs.getString("g.producer");
                    String technology  = rs.getString("g.technology");
                    DefaultTableModel model = (DefaultTableModel) this.main.getJtbl_rental_selection().getModel();
                    model.addRow(new Object[]{title, producer, technology, cost});
                    this.rental_game_id.add(id_game);
                    this.rental_game_cost.add(cost);
                }
                p.close();
                update_total();
            }else{
                JOptionPane.showMessageDialog(this.main, "El juego ya esta en la lista.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo agregar el juego.");
        }
    }
    
    private void update_total(){
        float total_cost = 0;
        for(Float cost:this.rental_game_cost){
            total_cost += cost;
        }
        this.main.getJlb_rental_selection_value().setText(Float.toString(total_cost));
    }
    
    private float get_cost(int id){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("select max(c.cost_date), c.cost from cost as c where c.id_game = "+id+" and c.cost_date < CURRENT_DATE();");
            float cost = -1;
            while(rs.next()){
                cost  = rs.getFloat("c.cost");
            }
            p.close();
            return cost;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el susario mas frecuente.");
            return -1;
        }
    }
    
    private boolean is_rented(int id){
        for (Integer id_game: this.rental_game_id){
            if(id_game == id){
                return true;
            }
        }
        return false;
    }
    
    private void delete(){
        reset_rental();
    }
    
    private void save(){
        try {
            float total_cost = 0;
            for(Float cost:this.rental_game_cost){
                total_cost += cost;
            }
            String sql_query = "Insert into rental (document, rental_date, status, cost) values(?, CURRENT_DATE(), \"En prestamo\", ?);";
            PreparedStatement ps = c.conectar().prepareStatement(sql_query);
            ps.setInt(1, this.document);
            ps.setFloat(2, total_cost);
            ps.execute();
            ps.close();
            int id_rental = get_last_rental_id(this.document);
            for (Integer id_game:this.rental_game_id){
                save_game_by_game(id_rental, id_game);
            }
            save_bill(id_rental, total_cost);
            JOptionPane.showMessageDialog(this.main, "Se guardo correctamente.");
            cancel();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo guardar el alquiler.");
        }
    }
    
    private void save_bill(int rental, float total_cost){
        String sFichero = "factura_"+rental+".txt";
        System.out.println(sFichero);
        File fichero = new File(sFichero);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write("Factura #:"+ rental + "\n");
            bw.write("Cliente :"+ this.document + "\n");
            Date fecha = new Date();
            bw.write("Fecha :"+ fecha + "\n");
            bw.write("Costo TOTAL :"+ total_cost + "\n");
            bw.close();
            this.main.getJlb_rental_selection_message().setText("La factura se guardó satisfactoriamente en la carpeta raíz.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo guardar la factura.");
        }
    }
    
    private void save_game_by_game(int id_rental, int id_game){
        try {
            String sql_query = "insert into selection values(?, ?)";
            PreparedStatement ps = c.conectar().prepareStatement(sql_query);
            ps.setInt(1, id_rental);
            ps.setInt(2, id_game);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo guardar el juego.");
        }
    }
    
    private int get_last_rental_id(int id_user){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("commit");
            rs = p.executeQuery("Select id_rental from (select max(ren.rental_date), ren.id_rental from rental as ren where ren.document = "+id_user+" and ren.rental_date = CURRENT_DATE()) result");
            int id_rental = -1;
            while(rs.next()){
                id_rental  = rs.getInt("id_rental");
            }
            p.close();
            return id_rental;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el susario mas frecuente.");
            return -1;
        }
    }
    
    private void cancel(){
        set_enabled_validate_panel(true);
        set_enabled_rental_panel(false);
        this.main.getJtf_validate_user_document().setText("");
        this.main.getJtf_validate_user_email().setText("");
        reset_rental();
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
                this.main.getJcb_rental_selection_name().addItem(name);
            }
            p.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el catalogo de juegos.");
        }
    }
}
