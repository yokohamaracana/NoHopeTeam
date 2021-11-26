/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsvapp.helper;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Tuan Tien
 */
public class MessageDialog {
    public static void showMessageDialog(Component parent, String connect, String title) {
        JOptionPane.showMessageDialog(parent, connect, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showErrorDialog(Component parent, String connect, String title) {
        JOptionPane.showMessageDialog(parent, connect, title, JOptionPane.ERROR_MESSAGE);
    }
    public static int showConfirmDialog(Component parent, String connect, String title) {
        int choose = JOptionPane.showConfirmDialog(parent, connect, title, 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
}
