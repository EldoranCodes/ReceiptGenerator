/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.receiptgenerator;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Eldoran
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
        //turns off the grid line
        receiptTable.setShowGrid(false);
        
        //this code retrict the user of inputing a alphabet characters
        cellPhoneNumberTextField.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c)&& c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){
                    e.consume();// this method ignores the inputed key if matches the conitions
                }
            }

        });
        
        //this code retrict the user of inputing a alphabet characters
        cellPhoneNumberTextField.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c)&& c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){
                    e.consume();// this method ignores the inputed key if matches the conitions
                }
            }

        });
        
       amountReceivedTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // Get the current text from the text field
                String text = amountReceivedTextField.getText();

                // Remove commas and non-digit characters
                text = text.replaceAll(",", "");

                // If the input is empty, return (to avoid NumberFormatException)
                if (text.isEmpty()) {
                    return;
                }

                try {
                    // Parse the text into a number
                    long number = Long.parseLong(text);

                    // Format the number with commas
                    String formattedText = NumberFormat.getNumberInstance(Locale.US).format(number);

                    // Set the formatted text back to the text field
                    amountReceivedTextField.setText(formattedText);

                    // Move the caret to the end of the text (so the user can continue typing)
                    amountReceivedTextField.setCaretPosition(amountReceivedTextField.getText().length());
                } catch (NumberFormatException ex) {
                    // Ignore invalid number format (like starting with a letter)
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only numbers (digits), backspace, and delete
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();  // Ignore the key input if it's not a valid character
                }
            }
        });
       // Set the text alignment to left
        amountReceivedTextField.setHorizontalAlignment(priceTextField.RIGHT);
       
       
        // Set the text alignment to left
        priceTextField.setHorizontalAlignment(priceTextField.RIGHT);
        


        // Add a KeyListener to restrict input to digits and format with commas
        priceTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // Get the current text from the text field
                String text = priceTextField.getText();

                // Remove commas and non-digit characters
                text = text.replaceAll(",", "");

                // If the input is empty, return (to avoid NumberFormatException)
                if (text.isEmpty()) {
                    return;
                }

                try {
                    // Parse the text into a number
                    long number = Long.parseLong(text);

                    // Format the number with commas
                    String formattedText = NumberFormat.getNumberInstance(Locale.US).format(number);

                    // Set the formatted text back to the text field
                    priceTextField.setText(formattedText);

                    // Move the caret to the end of the text (so the user can continue typing)
                    priceTextField.setCaretPosition(priceTextField.getText().length());
                } catch (NumberFormatException ex) {
                    // Ignore invalid number format (like starting with a letter)
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only numbers (digits), backspace, and delete
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();  // Ignore the key input if it's not a valid character
                }
            }
        });
        
        receiptTable.setGridColor(receiptTable.getBackground());
        totalAmountTextField.setHorizontalAlignment(priceTextField.RIGHT);
        
        // Enable row selection mode for the table
        receiptTable.setRowSelectionAllowed(true);
        receiptTable.setColumnSelectionAllowed(false);  // Disable column selection, row selection only

        // Add a ListSelectionListener to respond to row selection changes
        receiptTable.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = receiptTable.getSelectedRow();
            if (selectedRow != -1) {
                // Optionally, perform actions on the selected row
                System.out.println("Row " + selectedRow + " selected.");
                
                
            }
        }
        
});

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        receiptTable = new javax.swing.JTable();
        customerNameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cellPhoneNumberTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        receivedByTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        amountReceivedTextField = new javax.swing.JTextField();
        generateReceiptButton = new javax.swing.JButton();
        servicesComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pagesTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totalAmountTextField = new javax.swing.JTextField();
        deleteServiceButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        priceTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Receipt Generator"); // NOI18N

        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service / Items", "Pages / Quantity", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        receiptTable.setCellSelectionEnabled(false);
        receiptTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(receiptTable);
        receiptTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (receiptTable.getColumnModel().getColumnCount() > 0) {
            receiptTable.getColumnModel().getColumn(0).setResizable(false);
            receiptTable.getColumnModel().getColumn(1).setResizable(false);
            receiptTable.getColumnModel().getColumn(2).setResizable(false);
            receiptTable.getColumnModel().getColumn(3).setResizable(false);
        }

        customerNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("Customer Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("Address");

        addressTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setText("Cell Phone #");

        cellPhoneNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cellPhoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cellPhoneNumberTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setText("Received by:");

        receivedByTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        receivedByTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedByTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setText("Received Amount");

        amountReceivedTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        amountReceivedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountReceivedTextFieldActionPerformed(evt);
            }
        });

        generateReceiptButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        generateReceiptButton.setText("Generate Receipt");
        generateReceiptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReceiptButtonActionPerformed(evt);
            }
        });

        servicesComboBox.setEditable(true);
        servicesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DOCUMENT PRINTING", "COPY", "SCANNING" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setText("Services / Items");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setText("Pages / Quantity");

        pagesTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setText("PRICE");

        totalAmountTextField.setEditable(false);
        totalAmountTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalAmountTextField.setForeground(new java.awt.Color(255, 0, 0));
        totalAmountTextField.setText("0.00");

        deleteServiceButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        deleteServiceButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteServiceButton.setText("DELETE SERVICE");
        deleteServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteServiceButtonActionPerformed(evt);
            }
        });

        doneButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        doneButton.setText("ADD");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel9.setText("TOTAL AMOUNT");

        priceTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        priceTextField.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pagesTextField)
                                    .addComponent(priceTextField))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(servicesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(163, 163, 163))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(205, 205, 205))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(143, 143, 143)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(268, 268, 268)))
                                        .addComponent(customerNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(cellPhoneNumberTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(receivedByTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(amountReceivedTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(generateReceiptButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(servicesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(deleteServiceButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cellPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receivedByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountReceivedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generateReceiptButton, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cellPhoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cellPhoneNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cellPhoneNumberTextFieldActionPerformed

    private void receivedByTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedByTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receivedByTextFieldActionPerformed

    private void amountReceivedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountReceivedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountReceivedTextFieldActionPerformed

    private void deleteServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteServiceButtonActionPerformed
        // TODO add your handling code here:
        //check if row is selected at the jtable
       DefaultTableModel model = (DefaultTableModel) receiptTable.getModel();
        int selectedRow = receiptTable.getSelectedRow();

        if (selectedRow != -1) { // Check if a row is selected
            model.removeRow(selectedRow); // Remove the selected row
            JOptionPane.showMessageDialog(null, "Service successfully deleted!");
        } else {
           JOptionPane.showMessageDialog(null, "Select a row from the table");
        }
        
        computeTotal();
        
    }//GEN-LAST:event_deleteServiceButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // TODO add your handling code here:
        
        //checks the textfields before adding 
        if(pagesTextField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Pages field cannot be empty!");
            return;
        }
         if(priceTextField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Pages field cannot be empty!");
            return;
        }
        
        

        // Define DecimalFormat to show three decimal places
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        // Update table row with formatted amount
        DefaultTableModel table = (DefaultTableModel) receiptTable.getModel();
        int pages = Integer.parseInt(pagesTextField.getText());

        String priceStr = priceTextField.getText().replaceAll(",", ""); // Remove the comma
        double price = Double.parseDouble(priceStr);
        double amount = pages * price;

        // Format the price and amount to three decimal places
        String formattedPrice = decimalFormat.format(price);
        String formattedAmount = decimalFormat.format(amount);

        String service = servicesComboBox.getSelectedItem().toString();
        table.addRow(new Object[] {service, pages, formattedPrice, formattedAmount});

        // After adding row, update the total amount text field
        computeTotal();
        
        
        
    }//GEN-LAST:event_doneButtonActionPerformed

    private void generateReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReceiptButtonActionPerformed
        // TODO add your handling code here:
        generateReceiptImage();
    }//GEN-LAST:event_generateReceiptButtonActionPerformed

   private void computeTotal() {
    DefaultTableModel model = (DefaultTableModel) receiptTable.getModel();
    double totalAmount = 0.0;
    
    int amountColumnIndex = model.findColumn("Amount");
    
    for (int i = 0; i < model.getRowCount(); i++) {
        Object amountValue = model.getValueAt(i, amountColumnIndex);
        if (amountValue != null) {
            try {
                // Convert the value to a double and add it to the total
                double amount = Double.parseDouble(amountValue.toString());
                totalAmount += amount;
            } catch (NumberFormatException e) {
                // Handle the case where the amount value is not a valid number
                System.err.println("Invalid number format in amount column.");
            }
        }
    }
    
    // Update the totalAmountTextField with the formatted total
    totalAmountTextField.setText(String.format("%.2f", totalAmount));
}

    
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    
 

   



        private void generateReceiptImage() {
    // Set dimensions for half a letter-sized paper at 300 DPI (8.5 x 5.5 inches)
    int dpi = 300;
    int imageWidth = (int) (5.5 * dpi);   // Width in pixels for portrait mode
    int imageHeight = (int) (8.5 * dpi);  // Height in pixels for portrait mode

    // Define line spacing
    int lineSpacing = 70; // Single line spacing
    int doubleLineSpacing = lineSpacing * 2; // Double line spacing

    // Create a BufferedImage where the receipt will be drawn
    BufferedImage receiptImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = receiptImage.createGraphics();

    // Set background color to white
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0, 0, imageWidth, imageHeight);

    // Set up the font for the shop name (large, pink, bold font)
    g2d.setColor(Color.PINK);
    g2d.setFont(new Font("Arial", Font.BOLD, 72)); // Large font size for 300 DPI

    // Draw the shop name at the top center
    String shopName = "Cinderella's Print Shop";
    FontMetrics fm = g2d.getFontMetrics();
    int xShopName = (imageWidth - fm.stringWidth(shopName)) / 2;
    g2d.drawString(shopName, xShopName, 100); // Adjust Y position for larger font

    // Set up font for the rest of the receipt (normal size)
    g2d.setFont(new Font("Arial", Font.PLAIN, 44)); // Normal font size for 300 DPI

    // Draw customer info
    int yPosition = 200; // Initial Y position for customer info
    g2d.setColor(Color.BLACK);
    g2d.setFont(new Font("Arial", Font.BOLD, 44)); // Bold font for labels

    // Calculate width of the labels
    FontMetrics labelMetrics = g2d.getFontMetrics();
    int labelWidthCustomerName = labelMetrics.stringWidth("Customer Name:");
    int labelWidthAddress = labelMetrics.stringWidth("Address:");
    int labelWidthCellphone = labelMetrics.stringWidth("Cellphone #:");

    // Define padding between label and value
    int padding = 40;

    // Calculate starting x positions for values
    int valueStartX = 50 + Math.max(Math.max(labelWidthCustomerName, labelWidthAddress), labelWidthCellphone) + padding;

    // Draw labels
    g2d.drawString("Customer Name:", 50, yPosition);
    g2d.drawString("Address:", 50, yPosition + lineSpacing);
    g2d.drawString("Cellphone #:", 50, yPosition + 2 * lineSpacing);

    // Set font for values
    g2d.setFont(new Font("Arial", Font.PLAIN, 44)); // Plain font for values

    // Draw values
    g2d.drawString(customerNameTextField.getText(), valueStartX, yPosition);
    g2d.drawString(addressTextField.getText(), valueStartX, yPosition + lineSpacing);
    g2d.drawString(cellPhoneNumberTextField.getText(), valueStartX, yPosition + 2 * lineSpacing);

    // Move down by double line spacing plus additional space for the line
    yPosition += doubleLineSpacing; // Adjust additional space if needed

    // Set the stroke to make the line thicker
    g2d.setStroke(new BasicStroke(3)); // 3 is the thickness of the line

    // Set the color for the line
    g2d.setColor(Color.BLACK);

    // Draw a horizontal line at yPosition + 30 from x=50 to the image width minus 50
    g2d.drawLine(50, yPosition + 30, imageWidth - 50, yPosition + 30);

   

    yPosition += lineSpacing; 
    
    // Draw the table data (Receipt details)
    DefaultTableModel model = (DefaultTableModel) receiptTable.getModel();
    int rowCount = model.getRowCount();
    int colCount = model.getColumnCount();

    int xStart = 50;      // Starting X position for Service column
    int yStart = yPosition + 20; // Starting Y position for the table (with padding)

    int serviceColWidth = 600; // Adjusted width for the "Service" column
    int pagesColWidth = 240;    // Adjusted width for the "Pages" column
    int priceColWidth = 240;    // Adjusted width for the "Price" column
    int amountColWidth = 320;  // Adjusted width for the "Amount" column

    // Draw the column headers
    g2d.setFont(new Font("Arial", Font.BOLD, 44)); // Bold font for column headers
    g2d.drawString(model.getColumnName(0), xStart, yStart);                         // Service
    g2d.drawString(model.getColumnName(1), xStart + serviceColWidth, yStart);       // Pages
    g2d.drawString(model.getColumnName(2), xStart + serviceColWidth + pagesColWidth, yStart); // Price
    g2d.drawString(model.getColumnName(3), xStart + serviceColWidth + pagesColWidth + priceColWidth, yStart); // Amount

    // Draw the row data
    g2d.setFont(new Font("Arial", Font.PLAIN, 44)); // Plain font for row data
    yStart += lineSpacing; // Move down by line spacing for rows
    for (int row = 0; row < rowCount; row++) {
        for (int col = 0; col < colCount; col++) {
            Object value = model.getValueAt(row, col);
            if (value != null) {
                if (col == 0) {
                    // Service column (longer)
                    g2d.drawString(value.toString(), xStart, yStart + row * lineSpacing);
                } else if (col == 1) {
                    // Pages column
                    g2d.drawString(value.toString(), xStart + serviceColWidth, yStart + row * lineSpacing);
                } else if (col == 2) {
                    // Price column
                    g2d.drawString(value.toString(), xStart + serviceColWidth + pagesColWidth, yStart + row * lineSpacing);
                } else if (col == 3) {
                    // Amount column
                    g2d.drawString(value.toString(), xStart + serviceColWidth + pagesColWidth + priceColWidth, yStart + row * lineSpacing);
                }
            }
        }
    }

    // Draw line after table
    yStart += rowCount * lineSpacing; // Adjust additional space if needed
    g2d.drawLine(50, yStart, imageWidth - 50, yStart);

    // Draw total amount
    g2d.setFont(new Font("Arial", Font.BOLD, 44)); // Bold font for labels and amounts
    g2d.drawString("Total Amount:", 50, yStart + 60);
    g2d.drawString("Amount Received:", 50, yStart + 120);

    // Set up DecimalFormat to always show two decimal places
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    // Draw the values in plain font
    g2d.setFont(new Font("Arial", Font.PLAIN, 44)); // Plain font for values

    // Format the total amount and amount received
    String formattedTotalAmount = decimalFormat.format(Double.parseDouble(totalAmountTextField.getText().replace(",", "")));
    String formattedAmountReceived = decimalFormat.format(Double.parseDouble(amountReceivedTextField.getText().replace(",", "")));

    // Draw formatted values on the graphics
    g2d.drawString(formattedTotalAmount, valueStartX, yStart + 60);
    g2d.drawString(formattedAmountReceived, valueStartX, yStart + 120);


    // Calculate and draw change
    try {
        double totalAmount = Double.parseDouble(totalAmountTextField.getText().replaceAll(",", ""));
        double receivedAmount = Double.parseDouble(amountReceivedTextField.getText().replaceAll(",", ""));
        double change = receivedAmount - totalAmount;

        g2d.setFont(new Font("Arial", Font.BOLD, 44)); // Bold font for the change label
        g2d.drawString("Change:", 50, yStart + 180);
        g2d.setFont(new Font("Arial", Font.PLAIN, 44)); // Plain font for the change value
        g2d.drawString(String.format("%.2f", change), valueStartX, yStart + 180);
    } catch (NumberFormatException e) {
        e.printStackTrace();
        g2d.drawString("Change: Error calculating change", 50, yStart + 180);
    }

    // Draw signature section
    int detailsY = yStart + 240; // Adjust Y position for signature section
    g2d.setFont(new Font("Arial", Font.BOLD, 44)); // Bold font for labels
    g2d.drawString("Received By:", 50, detailsY);
    g2d.drawString("Signature:", 50, detailsY + 40);

    // Draw the values in plain font
    g2d.setFont(new Font("Arial", Font.PLAIN, 44)); // Plain font for values
    g2d.drawString(receivedByTextField.getText(), valueStartX, detailsY);
    g2d.drawString("____________________", valueStartX, detailsY + 40);

    // Dispose graphics context
    g2d.dispose();

    // Create the file chooser
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Receipt");

    // Set the default file name with customer name and current date
    String customerName = customerNameTextField.getText().trim().replaceAll(" ", "_");
    String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
    String defaultFileName = "Receipt_" + customerName + "_" + currentDate + ".png";
    fileChooser.setSelectedFile(new File(defaultFileName));

    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        try {
            ImageIO.write(receiptImage, "png", fileToSave);
            JOptionPane.showMessageDialog(null, "Receipt saved as " + fileToSave.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving receipt.");
        }
    }
}







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField amountReceivedTextField;
    private javax.swing.JTextField cellPhoneNumberTextField;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JButton deleteServiceButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JButton generateReceiptButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pagesTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JTable receiptTable;
    private javax.swing.JTextField receivedByTextField;
    private javax.swing.JComboBox<String> servicesComboBox;
    private javax.swing.JTextField totalAmountTextField;
    // End of variables declaration//GEN-END:variables


}
