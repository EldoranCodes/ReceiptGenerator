package com.mycompany.receiptgenerator;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import javax.swing.JOptionPane;

/**
 *
 * @author Eldoran
 */
public class ReceiptGenerator {

    private static FileLock lock;

    public static void main(String[] args) {
        // Prevent multiple instances of the application using a lock file
        File lockFile = new File(System.getProperty("user.home"), ".receiptgenerator.lock");

        try (FileChannel channel = FileChannel.open(lockFile.toPath(), 
                java.nio.file.StandardOpenOption.CREATE, 
                java.nio.file.StandardOpenOption.WRITE)) {

            lock = channel.tryLock();
            
            if (lock == null) {
                // Another instance is running
                JOptionPane.showMessageDialog(null, "The application is already running!", "Duplicate Instance", JOptionPane.WARNING_MESSAGE);
                System.exit(0); // Exit if another instance is running
            } else {
                // Proceed with launching the application
                launchApplication();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error starting the application.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Exit if an error occurs
        }
    }

    // Method to run the main application logic
    private static void launchApplication() {
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
