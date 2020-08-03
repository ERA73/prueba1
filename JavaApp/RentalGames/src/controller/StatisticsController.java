/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.MainContiner;

/**
 *
 * @author Esteban
 */
public class StatisticsController {
    
    private MainContiner main;
    private Conexion c;
    
    public StatisticsController(MainContiner main) {
        this.c = new Conexion();
        this.main = main;
        main.getJbtn_frequent_user().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frequent_user();
            }
        });
        main.getJbtn_most_rented_game().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                most_rented_game();
            }
        });
        main.getJbtn_days_sales().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                days_sales();
            }
        });
    }
    
    public void frequent_user(){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("select * from user as us where us.document in (select enumerator.document from (select re.document ,count(re.id_rental) From rental as re group by re.document desc limit 1) enumerator)");
            while(rs.next()){
                String name = rs.getString("full_name");
                int id  = rs.getInt("document");
                this.main.getJlb_frequent_user_name().setText(name+" -- "+Integer.toString(id));
            }
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el susario mas frecuente.");
        }
    }
    
    public void most_rented_game(){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("select * from game as g where g.id_game in (select enumerator.id_game from (select sel.id_game, count(sel.id_game) from selection as sel group by sel.id_game desc limit 1) enumerator)");
            while(rs.next()){
                String title = rs.getString("title");
                String producer  = rs.getString("producer");
                this.main.getJlb_most_rented_game_title().setText(title+" -- "+producer);
            }
            p.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el juego mas rentado.");
        }
    }
    
    public void days_sales(){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("select * from rental as r where r.rental_date = CURRENT_DATE();");
            int sales = 0;
            while(rs.next()){
                sales += rs.getInt("cost");
            }
            this.main.getJlb_days_sales_total().setText(Integer.toString(sales));
            p.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar la venta del dia.");
        }
    }
}
