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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        main.getJbtn_game_catalogue().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game_catalogue_search();
            }
        });
        main.getJbtn_lowest_rental().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowest_rental();
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
        } catch (Exception ex) {
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el juego mas rentado.");
        }
    }
    
    public void days_sales(){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("select * from rental as r where r.rental_date = CURRENT_DATE()");
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
    
    public void game_catalogue_search(){
        try {
            Statement p = c.conectar().createStatement();
            String director_query = this.main.getJtf_director().getText();
            String protagonist_query = this.main.getJtf_protagonist().getText();
            String producer_query = this.main.getJtf_producer().getText();
            ResultSet rs = p.executeQuery("select * from game as g where g.director LIKE \"%"+director_query+"%\" and g.protagonist LIKE \"%"+protagonist_query+"%\" and g.producer LIKE \"%"+producer_query+"%\";");
            String title = "";
            String director = "";
            String protagonist = "";
            String producer = "";
            String entry_date = "";
            String technology = "";
            DefaultTableModel dtm = (DefaultTableModel) this.main.getJtbl_game_catalogue().getModel();
            dtm.setRowCount(0);
            while(rs.next()){
                DefaultTableModel model = (DefaultTableModel) this.main.getJtbl_game_catalogue().getModel();
                title = rs.getString("title");
                director = rs.getString("director");
                protagonist = rs.getString("protagonist");
                producer = rs.getString("producer");
                entry_date = rs.getString("entry_date");
                technology = rs.getString("technology");
                model.addRow(new Object[]{title, director, protagonist, producer, entry_date, technology});
            }
            p.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar el catalogo.");
        }
    }
    
    private int get_max_user_age(){
        try {
            Statement p = c.conectar().createStatement();
            ResultSet rs = p.executeQuery("select max(us.age) from user as us");
            int max_age = -1;
            while(rs.next()){
                max_age = rs.getInt("max(us.age)");
            }
            //this.main.getJlb_days_sales_total().setText(Integer.toString(sales));
            p.close();
            return max_age;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar edad de los usuarios.");
            return -1;
        }
    }
    
    private ArrayList<Integer> get_age_interval(int age_delta, int max_age){
        ArrayList<Integer> age_intervals = new ArrayList<Integer>();
        int bottom_age = 0;
        int top_age = age_delta;
        while(bottom_age < max_age){
            age_intervals.add(top_age);
            bottom_age = top_age;
            top_age += age_delta;
        }
        return age_intervals;
    }
    
    private void lowest_rental(){
        try {
            int max_age = get_max_user_age();
            if (max_age > 0){
                int bottom_age = 0;
                int age_delta = 10;
                ArrayList<Integer> age_intervals = get_age_interval(age_delta, max_age);
                System.out.println(age_intervals.toString());
                String title = "";
                int amount = 0;
                DefaultTableModel model = (DefaultTableModel) this.main.getJtbl_lowest_rental().getModel();
                model.setRowCount(0);
                for(Integer age: age_intervals){
                    Statement p = c.conectar().createStatement();
                    ResultSet rs = p.executeQuery("select count(g.id_game), g.title from selection as sel left join (rental as ren, user as us, game as g) on (sel.id_rental = ren.id_rental and ren.document = us.document and sel.id_game = g.id_game) where us.age >= "+bottom_age+" and us.age < "+age.toString()+" group by g.id_game order by g.id_game desc limit 1");
                    while(rs.next()){
                        title = rs.getString("g.title");
                        amount = rs.getInt("count(g.id_game)");
                        model.addRow(new Object[]{title, bottom_age+" -- "+age, amount});
                    }
                    bottom_age = age;
                    p.close();
                }
            }else{
                JOptionPane.showMessageDialog(this.main, "No hay usuarios.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.main, "No se pudo consultar la venta del dia.");
        }
    }
}
