package com.example.task2_8;

import javax.swing.*;
import java.util.Locale;

public class Program {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountForm().setVisible(true);
            }
        });
    }
}
