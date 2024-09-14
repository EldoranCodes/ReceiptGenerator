/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.receiptgenerator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Eldoran
 */
public class ReceiptSaver {
    // Method to generate and save the receipt with additional details
    public void saveReceipt(JTable receiptTable, String filePath, String customerName, String address, String cellphone, String receivedBy, double amountReceived) {
        DefaultTableModel model = (DefaultTableModel) receiptTable.getModel();
        StringBuilder receipt = new StringBuilder();

        // Append receipt header and customer details
        receipt.append("Receipt\n");
        receipt.append("========================================\n");
        receipt.append("Customer Name: ").append(customerName).append("\n");
        receipt.append("Address: ").append(address).append("\n");
        receipt.append("Cellphone #: ").append(cellphone).append("\n");
        receipt.append("Received by: ").append(receivedBy).append("\n");
        receipt.append("Amount Received: ").append(String.format("%.2f", amountReceived)).append("\n");
        receipt.append("========================================\n");
        receipt.append(String.format("%-20s %-10s %-10s %-10s\n", "Service", "Pages", "Price", "Amount"));
        receipt.append("========================================\n");

        // Append rows from the JTable
        for (int i = 0; i < model.getRowCount(); i++) {
            String service = model.getValueAt(i, 0).toString();
            int pages = Integer.parseInt(model.getValueAt(i, 1).toString());
            double price = Double.parseDouble(model.getValueAt(i, 2).toString());
            double amount = Double.parseDouble(model.getValueAt(i, 3).toString());

            receipt.append(String.format("%-20s %-10d %-10.2f %-10.2f\n", service, pages, price, amount));
        }

        // Append total amount
        receipt.append("========================================\n");
        receipt.append(String.format("Total Amount: %.2f\n", computeTotal(receiptTable)));

        // Save to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(receipt.toString());
            JOptionPane.showMessageDialog(null, "Receipt saved successfully to " + filePath);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving receipt: " + e.getMessage());
        }
    }

    // Method to compute the total amount
    private double computeTotal(JTable receiptTable) {
        DefaultTableModel model = (DefaultTableModel) receiptTable.getModel();
        double totalAmount = 0.0;
        int amountColumnIndex = model.findColumn("Amount");

        for (int i = 0; i < model.getRowCount(); i++) {
            Object amountValue = model.getValueAt(i, amountColumnIndex);
            if (amountValue != null) {
                try {
                    double amount = Double.parseDouble(amountValue.toString());
                    totalAmount += amount;
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in amount column.");
                }
            }
        }
        return totalAmount;
    }
    
}
