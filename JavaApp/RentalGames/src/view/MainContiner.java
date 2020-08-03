/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Conexion;
import controller.RegistryController;
import controller.RentalController;
import controller.StatisticsController;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Esteban
 */
public class MainContiner extends javax.swing.JFrame {

    private RegistryController registry;
    private StatisticsController statistics;
    private RentalController rental;
    
    public MainContiner() {
        initComponents();
        this.registry = new RegistryController(this);
        this.statistics = new StatisticsController(this);
        this.rental = new RentalController(this);
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public JSeparator getjSeparator3() {
        return jSeparator3;
    }

    public JSeparator getjSeparator4() {
        return jSeparator4;
    }

    public JSeparator getjSeparator5() {
        return jSeparator5;
    }

    public JButton getJbtn_days_sales() {
        return jbtn_days_sales;
    }

    public JButton getJbtn_frequent_user() {
        return jbtn_frequent_user;
    }

    public JButton getJbtn_game_catalogue() {
        return jbtn_game_catalogue;
    }

    public JButton getJbtn_lowest_rental() {
        return jbtn_lowest_rental;
    }

    public JButton getJbtn_most_rented_game() {
        return jbtn_most_rented_game;
    }

    public JButton getJbtn_rental_selection_add() {
        return jbtn_rental_selection_add;
    }

    public JButton getJbtn_rental_selection_delete() {
        return jbtn_rental_selection_delete;
    }

    public JButton getJbtn_rental_selection_save() {
        return jbtn_rental_selection_save;
    }

    public JButton getJbtn_update_cost() {
        return jbtn_update_cost;
    }

    public JButton getJbtn_user_registry() {
        return jbtn_user_registry;
    }

    public JButton getJbtn_validate_user() {
        return jbtn_validate_user;
    }

    public JComboBox<String> getJcb_rental_selection_name() {
        return jcb_rental_selection_name;
    }

    public JComboBox<String> getJcb_update_cost_name() {
        return jcb_update_cost_name;
    }

    public JLabel getJlb_days_sales() {
        return jlb_days_sales;
    }

    public JLabel getJlb_days_sales_total() {
        return jlb_days_sales_total;
    }

    public JLabel getJlb_director() {
        return jlb_director;
    }

    public JLabel getJlb_frequent_user() {
        return jlb_frequent_user;
    }

    public JLabel getJlb_frequent_user_name() {
        return jlb_frequent_user_name;
    }

    public JLabel getJlb_game_catalogue_title() {
        return jlb_game_catalogue_title;
    }

    public JLabel getJlb_lowest_rental() {
        return jlb_lowest_rental;
    }

    public JLabel getJlb_most_rented_game() {
        return jlb_most_rented_game;
    }

    public JLabel getJlb_most_rented_game_title() {
        return jlb_most_rented_game_title;
    }

    public JLabel getJlb_producer() {
        return jlb_producer;
    }

    public JLabel getJlb_protagonist() {
        return jlb_protagonist;
    }

    public JLabel getJlb_rental_selection_message() {
        return jlb_rental_selection_message;
    }

    public JLabel getJlb_rental_selection_name() {
        return jlb_rental_selection_name;
    }

    public JLabel getJlb_rental_selection_title() {
        return jlb_rental_selection_title;
    }

    public JLabel getJlb_rental_selection_total() {
        return jlb_rental_selection_total;
    }

    public JLabel getJlb_rental_selection_value() {
        return jlb_rental_selection_value;
    }

    public JLabel getJlb_update_cost_title() {
        return jlb_update_cost_title;
    }

    public JLabel getJlb_user_registry_age() {
        return jlb_user_registry_age;
    }

    public JLabel getJlb_user_registry_document() {
        return jlb_user_registry_document;
    }

    public JLabel getJlb_user_registry_email() {
        return jlb_user_registry_email;
    }

    public JLabel getJlb_user_registry_name() {
        return jlb_user_registry_name;
    }

    public JLabel getJlb_user_registry_phone() {
        return jlb_user_registry_phone;
    }

    public JLabel getJlb_user_registry_title() {
        return jlb_user_registry_title;
    }

    public JLabel getJlb_validate_user_document() {
        return jlb_validate_user_document;
    }

    public JLabel getJlb_validate_user_email() {
        return jlb_validate_user_email;
    }

    public JLabel getJlb_validate_user_title() {
        return jlb_validate_user_title;
    }

    public JPanel getJpn_rental_selection() {
        return jpn_rental_selection;
    }

    public JScrollPane getJsp_game_catalogue() {
        return jsp_game_catalogue;
    }

    public JScrollPane getJsp_lowest_rental() {
        return jsp_lowest_rental;
    }

    public JScrollPane getJsp_rental_selection() {
        return jsp_rental_selection;
    }

    public JTable getJtbl_game_catalogue() {
        return jtbl_game_catalogue;
    }

    public JTable getJtbl_lowest_rental() {
        return jtbl_lowest_rental;
    }

    public JTable getJtbl_rental_selection() {
        return jtbl_rental_selection;
    }

    public JTextField getJtf_director() {
        return jtf_director;
    }

    public JTextField getJtf_producer() {
        return jtf_producer;
    }

    public JTextField getJtf_protagonist() {
        return jtf_protagonist;
    }

    public JTextField getJtf_update_cost_value() {
        return jtf_update_cost_value;
    }

    public JTextField getJtf_user_registry_age() {
        return jtf_user_registry_age;
    }

    public JTextField getJtf_user_registry_document() {
        return jtf_user_registry_document;
    }

    public JTextField getJtf_user_registry_email() {
        return jtf_user_registry_email;
    }

    public JTextField getJtf_user_registry_name() {
        return jtf_user_registry_name;
    }

    public JTextField getJtf_user_registry_phone() {
        return jtf_user_registry_phone;
    }

    public JTextField getJtf_validate_user_document() {
        return jtf_validate_user_document;
    }

    public JTextField getJtf_validate_user_email() {
        return jtf_validate_user_email;
    }

    public JTabbedPane getJtp_rental() {
        return jtp_rental;
    }

    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtp_rental = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlb_validate_user_title = new javax.swing.JLabel();
        jlb_validate_user_document = new javax.swing.JLabel();
        jtf_validate_user_document = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jlb_validate_user_email = new javax.swing.JLabel();
        jtf_validate_user_email = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jbtn_validate_user = new javax.swing.JButton();
        jpn_rental_selection = new javax.swing.JPanel();
        jlb_rental_selection_title = new javax.swing.JLabel();
        jlb_rental_selection_name = new javax.swing.JLabel();
        jcb_rental_selection_name = new javax.swing.JComboBox<>();
        jbtn_rental_selection_add = new javax.swing.JButton();
        jbtn_rental_selection_delete = new javax.swing.JButton();
        jsp_rental_selection = new javax.swing.JScrollPane();
        jtbl_rental_selection = new javax.swing.JTable();
        jlb_rental_selection_total = new javax.swing.JLabel();
        jlb_rental_selection_value = new javax.swing.JLabel();
        jbtn_rental_selection_save = new javax.swing.JButton();
        jlb_rental_selection_message = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jlb_frequent_user = new javax.swing.JLabel();
        jbtn_frequent_user = new javax.swing.JButton();
        jlb_frequent_user_name = new javax.swing.JLabel();
        jlb_most_rented_game = new javax.swing.JLabel();
        jbtn_most_rented_game = new javax.swing.JButton();
        jlb_most_rented_game_title = new javax.swing.JLabel();
        jlb_days_sales = new javax.swing.JLabel();
        jbtn_days_sales = new javax.swing.JButton();
        jlb_days_sales_total = new javax.swing.JLabel();
        jlb_game_catalogue_title = new javax.swing.JLabel();
        jlb_director = new javax.swing.JLabel();
        jtf_director = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jlb_protagonist = new javax.swing.JLabel();
        jtf_protagonist = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jlb_producer = new javax.swing.JLabel();
        jtf_producer = new javax.swing.JTextField();
        jbtn_game_catalogue = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jsp_game_catalogue = new javax.swing.JScrollPane();
        jtbl_game_catalogue = new javax.swing.JTable();
        jsp_lowest_rental = new javax.swing.JScrollPane();
        jtbl_lowest_rental = new javax.swing.JTable();
        jlb_lowest_rental = new javax.swing.JLabel();
        jbtn_lowest_rental = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlb_user_registry_title = new javax.swing.JLabel();
        jlb_user_registry_name = new javax.swing.JLabel();
        jtf_user_registry_name = new javax.swing.JTextField();
        jlb_user_registry_document = new javax.swing.JLabel();
        jtf_user_registry_document = new javax.swing.JTextField();
        jlb_user_registry_email = new javax.swing.JLabel();
        jtf_user_registry_email = new javax.swing.JTextField();
        jlb_user_registry_phone = new javax.swing.JLabel();
        jtf_user_registry_phone = new javax.swing.JTextField();
        jbtn_user_registry = new javax.swing.JButton();
        jlb_user_registry_age = new javax.swing.JLabel();
        jtf_user_registry_age = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlb_update_cost_title = new javax.swing.JLabel();
        jcb_update_cost_name = new javax.swing.JComboBox<>();
        jtf_update_cost_value = new javax.swing.JTextField();
        jbtn_update_cost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlb_validate_user_title.setText("Verificar usuario");

        jlb_validate_user_document.setText("Documento");

        jlb_validate_user_email.setText("Correo");

        jbtn_validate_user.setText("Verificar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlb_validate_user_document)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_validate_user_document, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlb_validate_user_email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_validate_user_email, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_validate_user))
                    .addComponent(jlb_validate_user_title))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jlb_validate_user_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_validate_user_document)
                            .addComponent(jtf_validate_user_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlb_validate_user_email)
                        .addComponent(jtf_validate_user_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_validate_user))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpn_rental_selection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlb_rental_selection_title.setText("Selección de juegos");

        jlb_rental_selection_name.setText("Título");

        jcb_rental_selection_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtn_rental_selection_add.setText("Agregar");

        jbtn_rental_selection_delete.setText("Eliminar");

        jtbl_rental_selection.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Productor", "Plataformas", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jsp_rental_selection.setViewportView(jtbl_rental_selection);

        jlb_rental_selection_total.setText("Total");

        jlb_rental_selection_value.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), null));

        jbtn_rental_selection_save.setText("Confirmar");

        javax.swing.GroupLayout jpn_rental_selectionLayout = new javax.swing.GroupLayout(jpn_rental_selection);
        jpn_rental_selection.setLayout(jpn_rental_selectionLayout);
        jpn_rental_selectionLayout.setHorizontalGroup(
            jpn_rental_selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_rental_selectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_rental_selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlb_rental_selection_message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb_rental_selection_title, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpn_rental_selectionLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpn_rental_selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsp_rental_selection)
                            .addGroup(jpn_rental_selectionLayout.createSequentialGroup()
                                .addGroup(jpn_rental_selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpn_rental_selectionLayout.createSequentialGroup()
                                        .addComponent(jlb_rental_selection_total)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlb_rental_selection_value, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpn_rental_selectionLayout.createSequentialGroup()
                                        .addComponent(jlb_rental_selection_name)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcb_rental_selection_name, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtn_rental_selection_add)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtn_rental_selection_delete))
                                    .addComponent(jbtn_rental_selection_save))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jpn_rental_selectionLayout.setVerticalGroup(
            jpn_rental_selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_rental_selectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_rental_selection_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpn_rental_selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_rental_selection_name)
                    .addComponent(jcb_rental_selection_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_rental_selection_add)
                    .addComponent(jbtn_rental_selection_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsp_rental_selection, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpn_rental_selectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_rental_selection_total, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_rental_selection_value, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_rental_selection_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_rental_selection_message, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpn_rental_selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpn_rental_selection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel6);

        jtp_rental.addTab("Alquilar", jScrollPane1);

        jlb_frequent_user.setText("Cliente mas frecuente");

        jbtn_frequent_user.setText("Consultar");

        jlb_frequent_user_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlb_most_rented_game.setText("Título mas rentado");

        jbtn_most_rented_game.setText("Consultar");

        jlb_most_rented_game_title.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlb_days_sales.setText("Ventas del día");

        jbtn_days_sales.setText("Consultar");

        jlb_days_sales_total.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlb_game_catalogue_title.setText("Catalogo de juegos");

        jlb_director.setText("Director");

        jlb_protagonist.setText("Protagonista");

        jlb_producer.setText("Productor");

        jbtn_game_catalogue.setText("Buscar");

        jtbl_game_catalogue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Director", "Protagonista", "Productor", "Año", "Tecnología"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jsp_game_catalogue.setViewportView(jtbl_game_catalogue);

        jtbl_lowest_rental.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Rango de edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jsp_lowest_rental.setViewportView(jtbl_lowest_rental);

        jlb_lowest_rental.setText("Juegos manos rentados por edades");

        jbtn_lowest_rental.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jlb_lowest_rental)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtn_lowest_rental)
                .addContainerGap(551, Short.MAX_VALUE))
            .addComponent(jsp_game_catalogue)
            .addComponent(jsp_lowest_rental)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jsp_game_catalogue, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_lowest_rental)
                    .addComponent(jbtn_lowest_rental))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsp_lowest_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlb_days_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb_most_rented_game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb_frequent_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtn_most_rented_game)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlb_most_rented_game_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtn_frequent_user)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlb_frequent_user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtn_days_sales)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlb_days_sales_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlb_game_catalogue_title)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlb_director)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_director, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_protagonist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_protagonist, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlb_producer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_producer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtn_game_catalogue)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlb_frequent_user_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_frequent_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_frequent_user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlb_most_rented_game_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_most_rented_game, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_most_rented_game))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlb_days_sales_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_days_sales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_days_sales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlb_game_catalogue_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_director)
                            .addComponent(jtf_director, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlb_protagonist)
                        .addComponent(jtf_protagonist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlb_producer)
                        .addComponent(jtf_producer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_game_catalogue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jtp_rental.addTab("Estadisticas", jScrollPane2);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlb_user_registry_title.setText("Registrar Cliente");

        jlb_user_registry_name.setText("Nombre");

        jlb_user_registry_document.setText("Documento");

        jlb_user_registry_email.setText("Correo");

        jlb_user_registry_phone.setText("Teléfono");

        jbtn_user_registry.setText("Registrar");

        jlb_user_registry_age.setText("Edad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_user_registry, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jlb_user_registry_age, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_user_registry_age, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlb_user_registry_title)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jlb_user_registry_name, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtf_user_registry_name, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jlb_user_registry_document, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtf_user_registry_document, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jlb_user_registry_email, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtf_user_registry_email, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jlb_user_registry_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtf_user_registry_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(496, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_user_registry_title, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_user_registry_name)
                    .addComponent(jtf_user_registry_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_user_registry_document)
                    .addComponent(jtf_user_registry_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_user_registry_email)
                    .addComponent(jtf_user_registry_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_user_registry_phone)
                    .addComponent(jtf_user_registry_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_user_registry_age)
                    .addComponent(jtf_user_registry_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtn_user_registry)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlb_update_cost_title.setText("Actualizar precio de alquiler");

        jcb_update_cost_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtn_update_cost.setText("Asignar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_update_cost_title)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jcb_update_cost_name, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_update_cost_value, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_update_cost)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_update_cost_title, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_update_cost_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_update_cost_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_update_cost))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel3);

        jtp_rental.addTab("Registrar", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtp_rental)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtp_rental)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainContiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainContiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainContiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainContiner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainContiner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton jbtn_days_sales;
    private javax.swing.JButton jbtn_frequent_user;
    private javax.swing.JButton jbtn_game_catalogue;
    private javax.swing.JButton jbtn_lowest_rental;
    private javax.swing.JButton jbtn_most_rented_game;
    private javax.swing.JButton jbtn_rental_selection_add;
    private javax.swing.JButton jbtn_rental_selection_delete;
    private javax.swing.JButton jbtn_rental_selection_save;
    private javax.swing.JButton jbtn_update_cost;
    private javax.swing.JButton jbtn_user_registry;
    private javax.swing.JButton jbtn_validate_user;
    private javax.swing.JComboBox<String> jcb_rental_selection_name;
    private javax.swing.JComboBox<String> jcb_update_cost_name;
    private javax.swing.JLabel jlb_days_sales;
    private javax.swing.JLabel jlb_days_sales_total;
    private javax.swing.JLabel jlb_director;
    private javax.swing.JLabel jlb_frequent_user;
    private javax.swing.JLabel jlb_frequent_user_name;
    private javax.swing.JLabel jlb_game_catalogue_title;
    private javax.swing.JLabel jlb_lowest_rental;
    private javax.swing.JLabel jlb_most_rented_game;
    private javax.swing.JLabel jlb_most_rented_game_title;
    private javax.swing.JLabel jlb_producer;
    private javax.swing.JLabel jlb_protagonist;
    private javax.swing.JLabel jlb_rental_selection_message;
    private javax.swing.JLabel jlb_rental_selection_name;
    private javax.swing.JLabel jlb_rental_selection_title;
    private javax.swing.JLabel jlb_rental_selection_total;
    private javax.swing.JLabel jlb_rental_selection_value;
    private javax.swing.JLabel jlb_update_cost_title;
    private javax.swing.JLabel jlb_user_registry_age;
    private javax.swing.JLabel jlb_user_registry_document;
    private javax.swing.JLabel jlb_user_registry_email;
    private javax.swing.JLabel jlb_user_registry_name;
    private javax.swing.JLabel jlb_user_registry_phone;
    private javax.swing.JLabel jlb_user_registry_title;
    private javax.swing.JLabel jlb_validate_user_document;
    private javax.swing.JLabel jlb_validate_user_email;
    private javax.swing.JLabel jlb_validate_user_title;
    private javax.swing.JPanel jpn_rental_selection;
    private javax.swing.JScrollPane jsp_game_catalogue;
    private javax.swing.JScrollPane jsp_lowest_rental;
    private javax.swing.JScrollPane jsp_rental_selection;
    private javax.swing.JTable jtbl_game_catalogue;
    private javax.swing.JTable jtbl_lowest_rental;
    private javax.swing.JTable jtbl_rental_selection;
    private javax.swing.JTextField jtf_director;
    private javax.swing.JTextField jtf_producer;
    private javax.swing.JTextField jtf_protagonist;
    private javax.swing.JTextField jtf_update_cost_value;
    private javax.swing.JTextField jtf_user_registry_age;
    private javax.swing.JTextField jtf_user_registry_document;
    private javax.swing.JTextField jtf_user_registry_email;
    private javax.swing.JTextField jtf_user_registry_name;
    private javax.swing.JTextField jtf_user_registry_phone;
    private javax.swing.JTextField jtf_validate_user_document;
    private javax.swing.JTextField jtf_validate_user_email;
    private javax.swing.JTabbedPane jtp_rental;
    // End of variables declaration//GEN-END:variables
}
