/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.MainContiner;

/**
 *
 * @author Esteban
 */
public class RentalController {
    
    private MainContiner main;
    private Conexion c;
    
    public RentalController(MainContiner main) {
        this.c = new Conexion();
        this.main = main;
    }
    
}
