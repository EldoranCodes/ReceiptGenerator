/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.receiptgenerator;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


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
        quantityTextField.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c)&& c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE){
                    e.consume();// this method ignores the inputed key if matches the conitions
                }
            }

        });
        
        //this code retrict the user of inputing a alphabet characters
        pagesTextField.addKeyListener(new KeyAdapter(){
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

        
        // Apply the document filter to the text field
        ((AbstractDocument) cellPhoneNumberTextField.getDocument()).setDocumentFilter(new LimitDocumentFilter(11));
        
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
        quantityTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ReceiptHistryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Receipt Generator"); // NOI18N

        receiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service / Items", "Pages", "Quantity", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        receiptTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(receiptTable);
        receiptTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (receiptTable.getColumnModel().getColumnCount() > 0) {
            receiptTable.getColumnModel().getColumn(0).setResizable(false);
            receiptTable.getColumnModel().getColumn(1).setResizable(false);
            receiptTable.getColumnModel().getColumn(2).setResizable(false);
            receiptTable.getColumnModel().getColumn(3).setResizable(false);
            receiptTable.getColumnModel().getColumn(4).setResizable(false);
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
        cellPhoneNumberTextField.setText("09");
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
        servicesComboBox.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        servicesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINT", "COPY", "SCANNING" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel4.setText("Services / Items");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setText("Pages");

        pagesTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pagesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagesTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setText("PRICE");

        totalAmountTextField.setEditable(false);
        totalAmountTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalAmountTextField.setForeground(new java.awt.Color(255, 0, 0));
        totalAmountTextField.setText("0.00");

        deleteServiceButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        deleteServiceButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteServiceButton.setText("DELETE ROW");
        deleteServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteServiceButtonActionPerformed(evt);
            }
        });

        doneButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        doneButton.setForeground(new java.awt.Color(0, 204, 51));
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

        quantityTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        quantityTextField.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel10.setText("Quantity");

        ReceiptHistryButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ReceiptHistryButton.setForeground(new java.awt.Color(51, 51, 255));
        ReceiptHistryButton.setText("Receipt History Folder");
        ReceiptHistryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptHistryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servicesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pagesTextField)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addComponent(ReceiptHistryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(doneButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(servicesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReceiptHistryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(18, 18, 18)
                        .addComponent(generateReceiptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        
        if(quantityTextField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Quantity cannot be empty!");
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
        int quantity = Integer.parseInt(quantityTextField.getText());
        
        String priceStr = priceTextField.getText().replaceAll(",", ""); // Remove the comma
        double price = Double.parseDouble(priceStr);
        double amount = pages * price;

        // Format the price and amount to three decimal places
        String formattedPrice = decimalFormat.format(price);
        String formattedAmount = decimalFormat.format(amount);

        String service = servicesComboBox.getSelectedItem().toString();
        table.addRow(new Object[] {service, pages,quantity, formattedPrice, formattedAmount});

        // After adding row, update the total amount text field
        computeTotal();
        
        //clear the textboxes
        pagesTextField.setText("");
        priceTextField.setText("");
        quantityTextField.setText("");

    }//GEN-LAST:event_doneButtonActionPerformed

    private void generateReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReceiptButtonActionPerformed
        // TODO add your handling code here:
        int hasError = 0;
        //checks the jtable if has row
        int jtableRows = receiptTable.getRowCount();
        if (jtableRows <= 0){
            JOptionPane.showMessageDialog(null,"Add ITEMS or SERVICE in the table");
            hasError += 1;
        }
        //checks the textboxes if has vlues
        if(customerNameTextField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter the CUSTOMER NAME");
            hasError += 1;
        }
        if(addressTextField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter the CUSTOMER'S ADDRESS");
            hasError += 1;
        }
        if(cellPhoneNumberTextField.getText().trim().length() != 11) {
            JOptionPane.showMessageDialog(null, "Please enter a valid 11-digit PHONE NUMBER.");
            hasError += 1;
        }
        if(receivedByTextField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter YOUR NAME");
            hasError += 1;
        }
        
        double totalAmount = Double.parseDouble(totalAmountTextField.getText());
        double receivedAmount = Double.parseDouble(amountReceivedTextField.getText().trim().replaceAll(",",""));       
        if(receivedAmount < totalAmount){
            JOptionPane.showMessageDialog(null,"RECEIVED AMOUNT must be the same or greater than TOTAL AMOUNT");
            hasError += 1;
        }
        if (hasError > 0){
            return;
        }
        generateReceiptImage();
    }//GEN-LAST:event_generateReceiptButtonActionPerformed

    private void pagesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagesTextFieldActionPerformed

    private void ReceiptHistryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptHistryButtonActionPerformed
        // TODO add your handling code here:
        try {
        // Get the user's AppData directory (Windows) or home directory (Linux/Mac)
        String appDataPath = System.getenv("APPDATA"); // Windows specific
        if (appDataPath == null) {
            appDataPath = System.getProperty("user.home"); // Fallback for other OS
        }

        // Define the path for the ReceiptHistory folder
        File historyFolder = new File(appDataPath, "ReceiptHistory");

        // Check if the folder exists
        if (historyFolder.exists() && historyFolder.isDirectory()) {
            // Use Desktop class to open the folder in the file explorer
            Desktop.getDesktop().open(historyFolder);
        } else {
            JOptionPane.showMessageDialog(null, "No receipt history found.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to open ReceiptHistory folder.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_ReceiptHistryButtonActionPerformed

   private void computeTotal() {
    DefaultTableModel model = (DefaultTableModel) receiptTable.getModel();
    double totalAmount = 0.0;

    int pagesColumnIndex = model.findColumn("Pages");
    int quantityColumnIndex = model.findColumn("Quantity");
    int priceColumnIndex = model.findColumn("Price");
    int amountColumnIndex = model.findColumn("Amount");

    for (int i = 0; i < model.getRowCount(); i++) {
        Object pagesValue = model.getValueAt(i, pagesColumnIndex);
        Object quantityValue = model.getValueAt(i, quantityColumnIndex);
        Object priceValue = model.getValueAt(i, priceColumnIndex);

        if (pagesValue != null && quantityValue != null && priceValue != null) {
            try {
                // Parse pages, quantity, and price values
                double pages = Double.parseDouble(pagesValue.toString());
                double quantity = Double.parseDouble(quantityValue.toString());
                double price = Double.parseDouble(priceValue.toString());

                // Calculate the amount (pages * quantity * price)
                double amount = pages * quantity * price;

                // Set the calculated amount in the Amount column
                model.setValueAt(String.format("%.2f", amount), i, amountColumnIndex);

                // Add to total amount
                totalAmount += amount;
            } catch (NumberFormatException e) {
                // Handle invalid number formats
                System.err.println("Invalid number format in one of the columns.");
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
        g2d.drawString("", 50, detailsY); //1 line space
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
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String defaultFileName = "Receipt_" + customerName + "_" + currentDate + ".png";
        fileChooser.setSelectedFile(new File(defaultFileName));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                // Save the receipt image to the selected file
                ImageIO.write(receiptImage, "png", fileToSave);
                JOptionPane.showMessageDialog(null, "Receipt saved as " + fileToSave.getAbsolutePath());

                // Automatically save a copy in AppData/ReceiptHistory
                saveReceiptToAppData(receiptImage, defaultFileName);

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving receipt.");
            }
        }
}

    // Method to save the receipt to AppData/ReceiptHistory
    private void saveReceiptToAppData(BufferedImage receiptImage, String fileName) {
        try {
            // Get the user's AppData directory (Windows) or home directory (Linux/Mac)
            String appDataPath = System.getenv("APPDATA"); // Windows specific
            if (appDataPath == null) {
                appDataPath = System.getProperty("user.home"); // Fallback for other OS
            }

            // Create the ReceiptHistory directory in AppData if it doesn't exist
            File historyFolder = new File(appDataPath, "ReceiptHistory");
            if (!historyFolder.exists()) {
                historyFolder.mkdirs(); // Create the folder if it doesn't exist
            }

            // Save the receipt file in the ReceiptHistory folder
            File historyFile = new File(historyFolder, fileName);
            ImageIO.write(receiptImage, "png", historyFile);

            JOptionPane.showMessageDialog(null, "Receipt also saved in AppData/ReceiptHistory: " + historyFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to save receipt to ReceiptHistory.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





    // Custom DocumentFilter to limit input to digits and a max length
    class LimitDocumentFilter extends DocumentFilter {
        private final int max;

        public LimitDocumentFilter(int max) {
            this.max = max;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) return;

            if ((fb.getDocument().getLength() + string.length()) <= max && string.matches("\\d+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null) return;

            if ((fb.getDocument().getLength() + text.length() - length) <= max && text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReceiptHistryButton;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField amountReceivedTextField;
    private javax.swing.JTextField cellPhoneNumberTextField;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JButton deleteServiceButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JButton generateReceiptButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JTable receiptTable;
    private javax.swing.JTextField receivedByTextField;
    private javax.swing.JComboBox<String> servicesComboBox;
    private javax.swing.JTextField totalAmountTextField;
    // End of variables declaration//GEN-END:variables


}
