/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uas2;
import uas2.view.login; 

/**
 *
 * @author HP
 */
public class UAS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }
    
}
