/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.receiptgenerator;

/**
 *
 * @author Eldoran
 */
public class ReceiptGenerator {

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the form is created on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create an instance of MainForm
                MainForm mainForm = new MainForm();
                
                // Set properties of the form
                mainForm.setVisible(true); // Make it visible
                mainForm.setLocationRelativeTo(null); // Center it on the screen
            }
        });
        
    }
}
